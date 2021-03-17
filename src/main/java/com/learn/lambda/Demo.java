package com.learn.lambda;

/**
 * java8 函数式编程
 *
 * */
public class Demo {
    public static void main(String[] args) {
        //函数式接口 定义了一个方法
        Handler<UserEntity> userEntityHandler = r ->{
            System.out.println(r.getMobile());
            r.setId(1);
            r.setName("123");
            r.setMobile("efg");
            System.out.println(r.getMobile());
        };
        System.out.println("......");
        UserEntity record = new UserEntity();
        record.setId(2);
        record.setName("name");
        record.setMobile("abc");
        userEntityHandler.handle(record);
        System.out.println(record.getMobile());
    }
}
