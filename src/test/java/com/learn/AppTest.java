package com.learn;

import cn.yueshutong.commoon.entity.RateLimiterRule;
import cn.yueshutong.commoon.entity.RateLimiterRuleBuilder;
import cn.yueshutong.commoon.enums.LimiterModel;
import cn.yueshutong.core.config.RateLimiterConfig;
import cn.yueshutong.core.limiter.RateLimiter;
import cn.yueshutong.core.limiter.RateLimiterFactory;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class AppTest {
    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 本地限流
     */
    @Test
    public void test1() {
        // 1.配置规则
        RateLimiterRule rateLimiterRule = new RateLimiterRuleBuilder()
                .setLimit(1)
                .setPeriod(1)
                .setUnit(TimeUnit.SECONDS) //每秒令牌数为1
                .build();
        // 2.工厂模式生产限流器
        RateLimiter limiter = RateLimiterFactory.of(rateLimiterRule);
        // 3.使用
        while (true) {
            if (limiter.tryAcquire()) {
                logger.info("ok");
            }
        }
    }

    @Test
    public void test(){
        for(int i=0; i<20;i++){
            test1();
        }
    }

    /**
     * 分布式限流
     */
    @Test
    public void test4() throws InterruptedException {
        // 1.限流配置
        RateLimiterRule rateLimiterRule = new RateLimiterRuleBuilder()
                .setApp("Application")
                .setId("myId")
                .setLimit(1) //每秒1个令牌
                .setBatch(1) //每批次取1个令牌
                .setLimiterModel(LimiterModel.CLOUD) //分布式限流,需启动TicketServer控制台
                .build();
        // 2.配置TicketServer地址（支持集群、加权重）
        Map<String, Integer> map = new HashMap<>();
        map.put("127.0.0.1:8521", 1);
        // 3.全局配置
        RateLimiterConfig config = RateLimiterConfig.getInstance();
        config.setTicketServer(map);
        // 4.工厂模式生产限流器
        RateLimiter limiter = RateLimiterFactory.of(rateLimiterRule, config);
        // 5.使用
        while (true) {
            if (limiter.tryAcquire()) {
                logger.info("ok");
            }
            Thread.sleep(10);
        }
    }
}
