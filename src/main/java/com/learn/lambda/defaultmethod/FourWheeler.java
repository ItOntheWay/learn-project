package com.learn.lambda.defaultmethod;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 10:57
 */
public interface FourWheeler {
    default void print(){
        System.out.println("I'm a FourWheeler car !");
    }
}
