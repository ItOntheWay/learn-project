package com.learn.thread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.*;

/**
 * 令牌桶算法
 * */

public class TokensLimiter {
    private static final Logger log = LoggerFactory.getLogger(TokensLimiter.class);
    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    // 最后一次令牌发放时间
    public long timeStamp = System.currentTimeMillis();
    // 桶的容量
    public int capacity = 10;
    // 令牌生成速度10/s
    public int rate = 10;
    // 当前令牌数量
    public int tokens;

    public void acquire() {
        scheduledExecutorService.scheduleWithFixedDelay(() -> {
            long now = System.currentTimeMillis();
            // 当前令牌数
            tokens = Math.min(capacity, (int) (tokens + (now - timeStamp) * rate / 1000));
            //每隔0.5秒发送随机数量的请求
            int permits = (int) (Math.random() * 9) + 1;
            log.info("请求令牌数：" + permits + "，当前令牌数：" + tokens);
            timeStamp = now;
            if (tokens < permits) {
                // 若不到令牌,则拒绝
                log.info("限流了");
            } else {
                // 还有令牌，领取令牌
                tokens -= permits;
                log.info("剩余令牌=" + tokens);
            }
        }, 1000, 500, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        TokensLimiter tokensLimiter = new TokensLimiter();
        tokensLimiter.acquire();
    }
}
