package com.learn.lambda.defaultmethod;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 10:55
 */
public interface Vehicle {
    default void print(){
        System.out.println("I'm a car ！");
    }
    default void print1(){
        System.out.println("I'm a new car ！");
    }
    static void blowHorn(){
        System.out.println("push blowhron !!!");
    }
}
