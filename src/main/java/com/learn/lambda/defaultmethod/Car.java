package com.learn.lambda.defaultmethod;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 10:58
 * 一个类实现了多个接口，且这些接口有相同的默认方法
 * 可以使用 super 来调用指定接口的默认方法
 */
public class Car implements Vehicle,FourWheeler {
    @Override
    public void print() {
        Vehicle.super.print();
        FourWheeler.super.print();
        Vehicle.blowHorn();
    }

    @Override
    public void print1() {
        Vehicle.super.print();
    }
}
