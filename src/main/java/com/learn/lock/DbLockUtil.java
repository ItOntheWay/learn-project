package com.learn.lock;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/10/27 15:38
 */
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.sql.*;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * create table t_lock(
 *   lock_key varchar(32) PRIMARY KEY NOT NULL COMMENT '锁唯一标志',
 *   request_id varchar(64) NOT NULL DEFAULT '' COMMENT '用来标识请求对象的',
 *   lock_count INT NOT NULL DEFAULT 0 COMMENT '当前上锁次数',
 *   timeout BIGINT NOT NULL DEFAULT 0 COMMENT '锁超时时间',
 *   version INT NOT NULL DEFAULT 0 COMMENT '版本号，每次更新+1'
 * )COMMENT '锁信息表';
 * */
@Slf4j
public class DbLockUtil {

    //将requestid保存在该变量中
    static ThreadLocal<String> requestIdTL = new ThreadLocal<>();
    //jvm锁：当多个线程并发获取分布式锁时，需要先获取jvm锁，jvm锁获取成功，则尝试获取分布式锁
    static Map<String, ReentrantLock> jvmLockMap = new ConcurrentHashMap<>();

    /**
     * 获取当前线程requestid
     *
     * @return
     */
    public static String getRequestId() {
        String requestId = requestIdTL.get();
        if (requestId == null || "".equals(requestId)) {
            requestId = UUID.randomUUID().toString();
            requestIdTL.set(requestId);
        }
        log.info("requestId:{}", requestId);
        return requestId;
    }

    /**
     * 获取锁
     *
     * @param lockKey         锁key
     * @param lockTimeOut(毫秒) 持有锁的有效时间，防止死锁
     * @param getTimeOut(毫秒)  获取锁的超时时间，这个时间内获取不到将重试
     * @return
     */
    public static boolean lock(String lockKey, long lockTimeOut, int getTimeOut) throws Exception {
        log.info("start");
        boolean lockResult = false;

        /**
         * 单个jvm中可能有多个线程并发获取一个锁
         * 此时我们只允许一个线程去获取分布式锁
         * 所以如果同一个jvm中有多个线程尝试获取分布式锁，需要先获取jvm中的锁
         */
        ReentrantLock jvmLock = new ReentrantLock();
        ReentrantLock oldJvmLock = jvmLockMap.putIfAbsent(lockKey, jvmLock);
        oldJvmLock = oldJvmLock != null ? oldJvmLock : jvmLock;
        boolean jvmLockSuccess = oldJvmLock.tryLock(getTimeOut, TimeUnit.MILLISECONDS);
        //jvm锁获取失败，则直接失败
        if (!jvmLockSuccess) {
            return lockResult;
        } else {
            //jvm锁获取成功，则继续尝试获取分布式锁
            try {
                String request_id = getRequestId();
                long startTime = System.currentTimeMillis();
                //循环尝试获取锁
                while (true) {
                    //通过lockKey获取db中的记录
                    LockModel lockModel = DbLockUtil.get(lockKey);
                    if (Objects.isNull(lockModel)) {
                        //记录不存在，则先插入一条
                        DbLockUtil.insert(LockModel.builder().lock_key(lockKey).request_id("").lock_count(0).timeout(0L).version(0).build());
                    } else {
                        //获取请求id，稍后请求id会放入ThreadLocal中
                        String requestId = lockModel.getRequest_id();
                        //如果requestId为空字符，表示锁未被占用
                        if ("".equals(requestId)) {
                            lockModel.setRequest_id(request_id);
                            lockModel.setLock_count(1);
                            lockModel.setTimeout(System.currentTimeMillis() + lockTimeOut);
                            //并发情况下，采用cas方式更新记录
                            if (DbLockUtil.update(lockModel) == 1) {
                                lockResult = true;
                                break;
                            }
                        } else if (request_id.equals(requestId)) {
                            //如果requestId和表中request_id一样表示锁被当前线程持有者，此时需要加重入锁
                            lockModel.setTimeout(System.currentTimeMillis() + lockTimeOut);
                            lockModel.setLock_count(lockModel.getLock_count() + 1);
                            if (DbLockUtil.update(lockModel) == 1) {
                                lockResult = true;
                                break;
                            }
                        } else {
                            //锁不是自己的，并且已经超时了，则重置锁，继续重试
                            if (lockModel.getTimeout() < System.currentTimeMillis()) {
                                DbLockUtil.resetLock(lockModel);
                            } else {
                                //如果未超时，休眠100毫秒，继续重试
                                if (startTime + getTimeOut > System.currentTimeMillis()) {
                                    TimeUnit.MILLISECONDS.sleep(100);
                                } else {
                                    break;
                                }
                            }
                        }
                    }
                }
            } finally {
                //释放jvm锁，将其从map中异常
                jvmLock.unlock();
                jvmLockMap.remove(lockKey);
            }
        }
        log.info("end");
        return lockResult;
    }

    /**
     * 释放锁
     *
     * @param lock_key
     * @throws Exception
     */
    private static void unlock(String lock_key) throws Exception {
        //获取当前线程requestId
        String requestId = getRequestId();
        LockModel lockModel = DbLockUtil.get(lock_key);
        //当前线程requestId和库中request_id一致 && lock_count>0，表示可以释放锁
        if (Objects.nonNull(lockModel) && requestId.equals(lockModel.getRequest_id()) && lockModel.getLock_count() > 0) {
            if (lockModel.getLock_count() == 1) {
                //重置锁
                resetLock(lockModel);
            } else {
                lockModel.setLock_count(lockModel.getLock_count() - 1);
                DbLockUtil.update(lockModel);
            }
        }
    }

    /**
     * 重置锁
     *
     * @param lockModel
     * @return
     * @throws Exception
     */
    private static int resetLock(LockModel lockModel) throws Exception {
        lockModel.setRequest_id("");
        lockModel.setLock_count(0);
        lockModel.setTimeout(0L);
        return DbLockUtil.update(lockModel);
    }

    /**
     * 更新lockModel信息，内部采用乐观锁来更新
     *
     * @param lockModel
     * @return
     * @throws Exception
     */
    private static int update(LockModel lockModel) throws Exception {
        return exec(conn -> {
            String sql = "UPDATE t_lock SET request_id = ?,lock_count = ?,timeout = ?,version = version + 1 WHERE lock_key = ? AND  version = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            int colIndex = 1;
            ps.setString(colIndex++, lockModel.getRequest_id());
            ps.setInt(colIndex++, lockModel.getLock_count());
            ps.setLong(colIndex++, lockModel.getTimeout());
            ps.setString(colIndex++, lockModel.getLock_key());
            ps.setInt(colIndex++, lockModel.getVersion());
            return ps.executeUpdate();
        });
    }

    private static LockModel get(String lock_key) throws Exception {
        return exec(conn -> {
            String sql = "select * from t_lock t WHERE t.lock_key=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            int colIndex = 1;
            ps.setString(colIndex++, lock_key);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return LockModel.builder().
                        lock_key(lock_key).
                        request_id(rs.getString("request_id")).
                        lock_count(rs.getInt("lock_count")).
                        timeout(rs.getLong("timeout")).
                        version(rs.getInt("version")).build();
            }
            return null;
        });
    }

    private static int insert(LockModel lockModel) throws Exception {
        return exec(conn -> {
            String sql = "insert into t_lock (lock_key, request_id, lock_count, timeout, version) VALUES (?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            int colIndex = 1;
            ps.setString(colIndex++, lockModel.getLock_key());
            ps.setString(colIndex++, lockModel.getRequest_id());
            ps.setInt(colIndex++, lockModel.getLock_count());
            ps.setLong(colIndex++, lockModel.getTimeout());
            ps.setInt(colIndex++, lockModel.getVersion());
            return ps.executeUpdate();
        });
    }

    private static <T> T exec(SqlExec<T> sqlExec) throws Exception {
        Connection conn = getConn();
        try {
            return sqlExec.exec(conn);
        } finally {
            closeConn(conn);
        }
    }

    @FunctionalInterface
    public interface SqlExec<T> {
        T exec(Connection conn) throws Exception;
    }

    @Getter
    @Setter
    @Builder
    public static class LockModel {
        private String lock_key;
        private String request_id;
        private Integer lock_count;
        private Long timeout;
        private Integer version;
    }

    private static final String url = "jdbc:mysql://localhost:3306/dlock?useSSL=false";        //数据库地址
    private static final String username = "";        //数据库用户名
    private static final String password = "";        //数据库密码
    private static final String driver = "com.mysql.jdbc.Driver";        //mysql驱动

    /**
     * 连接数据库
     *
     * @return
     */
    private static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName(driver);  //加载数据库驱动
            try {
                conn = DriverManager.getConnection(url, username, password);  //连接数据库
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 关闭数据库链接
     *
     * @return
     */
    private static void closeConn(Connection conn) {
        if (conn != null) {
            try {
                conn.close();  //关闭数据库链接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}