package com.learn.lambda;


import java.util.function.Consumer;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 17:18
 * https://blog.csdn.net/icarusliu/article/details/79495534#1-java8%E5%87%BD%E6%95%B0%E5%BC%8F%E7%BC%96%E7%A8%8B%E8%AF%AD%E6%B3%95%E5%85%A5%E9%97%A8
 * java8函数式接口
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n +"-c2");
        f.accept("a");
        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("b");
        //连续执行F的Accept方法
        f.andThen(f).andThen(f).accept("test");
    }
}
