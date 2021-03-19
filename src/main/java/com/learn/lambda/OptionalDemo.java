package com.learn.lambda;

import java.util.Optional;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/19 14:15
 *https://blog.csdn.net/icarusliu/article/details/79495534#1-java8%E5%87%BD%E6%95%B0%E5%BC%8F%E7%BC%96%E7%A8%8B%E8%AF%AD%E6%B3%95%E5%85%A5%E9%97%A8
 *
 */
public class OptionalDemo {
    public static void main(String args[]){

        //創建空的optional對象，其value属性为Null。
        /*Optional o = Optional.empty();
        //根据传入的值构建一个Optional对象; 传入的值必须是非空值，否则如果传入的值为空值，则会抛出空指针异常。
        o = Optional.of("test");
        //根据传入值构建一个Optional对象 传入的值可以是空值，如果传入的值是空值，则与empty返回的结果是一样的。
        o = Optional.ofNullable(null);
        //orElse	Value不为空则返回Value，否则返回传入的值；
        System.out.println(o.orElse("test1"));*/

        //变量为空时抛出异常，否则使用
        /*String s = null;
        Optional<String> o = Optional.ofNullable(s);
        try {
            System.out.println(o.orElseThrow(()->new Exception("test")));
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        OptionalDemo demo = new OptionalDemo();
        Integer value1 = null;
        Integer value2 = new Integer(10);

        // Optional.ofNullable - 允许传递为 null 参数
        Optional<Integer> a = Optional.ofNullable(value1);

        // Optional.of - 如果传递的参数是 null，抛出异常 NullPointerException
        Optional<Integer> b = Optional.of(value2);
        System.out.println(demo.sum(a,b));
    }

    public Integer sum(Optional<Integer> a, Optional<Integer> b){

        // Optional.isPresent - 判断值是否存在

        System.out.println("第一个参数值存在: " + a.isPresent());
        System.out.println("第二个参数值存在: " + b.isPresent());

        // Optional.orElse - 如果值存在，返回它，否则返回默认值
        Integer value1 = a.orElse(new Integer(0));

        //Optional.get - 获取值，值需要存在
        Integer value2 = b.get();
        return value1 + value2;
    }
}
