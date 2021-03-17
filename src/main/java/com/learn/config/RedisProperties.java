package com.learn.config;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * 加载配置文件的两种方法
 * */
/**方法1 自定义配置文件,redisson.properties、
 * 引入spring-boot-configuration-processor、
 * 使用@Configuration @PropertySource @ConfigurationProperties
*/
/**
 * 方法2 application.properties中配置、使用@Component @ConfigurationProperties
 */
@Configuration
@PropertySource("classpath:redisson.properties")
@ConfigurationProperties(prefix = "redisson.redis", ignoreUnknownFields = false)
@Data
@ToString
public class RedisProperties {


    private int database;

    /**
     * 等待节点回复命令的时间。该时间从命令发送成功时开始计时
     */

    private int timeout;


    private String password;


    private String mode;

    /**
     * 单机信息配置
     */

    private RedisSingleProperties single;

    /**
     * 池配置
     */
//    private RedisPoolProperties pool;

    private int maxIdle;


    private int minIdle;


    private int maxActive;

    private int maxWait;

    private int connTimeout;

    private int soTimeout;

    /**
     * 池大小
     */
    private  int size;
    /**
     * 集群 信息配置
     */
//    private RedissonClusterProperties cluster;

}
