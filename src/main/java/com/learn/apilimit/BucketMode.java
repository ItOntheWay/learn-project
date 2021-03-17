package com.learn.apilimit;

public enum BucketMode {
    /**
     * blocked token bucket
     */
    BTB("btb"),


    /**
     * none blocked token bucket
     */
    NTB("ntb"),


    /**
     * 没有可用token 抛出异常的token bucket
     */
    FFTB("fftb");

    private String name;

    BucketMode(String name) {
        this.name = name;
    }
}
