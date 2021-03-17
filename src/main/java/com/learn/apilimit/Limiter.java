package com.learn.apilimit;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * redis实现分布式令牌桶算法
 * */

public class Limiter {
    //现有token
    private volatile long token;
    // 桶中最大有多少令牌
    private final long maxTokenNum;
    // 单位时间（1s）往桶中放令牌数量
    private  final double unitAddNum;

    private ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

    public Limiter(double unitAddNum,long maxToken,boolean isFullStart){
        if (unitAddNum <= 0 || maxToken <= 0) {
            throw new RuntimeException("unitAddNum and maxToken can't less than 0");
        }
        if (unitAddNum > 1000) {
            throw new RuntimeException("unitAddNum max is 1000");
        }
        this.unitAddNum = unitAddNum;
        this.maxTokenNum = maxToken;
        if (isFullStart) {
            this.token = maxToken;
        } else {
            this.token = 0;
        }
        //生成令牌
        scheduledExecutorService.scheduleWithFixedDelay(()->{

        },1000,5000, TimeUnit.MILLISECONDS);
    }
}
