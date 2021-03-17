package com.learn.jichu;

public class StaticMethodDemo {

    public StaticMethodDemo(){
        System.out.println("无参构造方法！");
    }
    {
        System.out.println("代码块！");
    }
    static {
        System.out.println("静态代码块！");
    }
    public static void test(){
        System.out.println("静态方法内容！");
        {
            System.out.println("静态方法中的代码块！");
        }
    }
    public static void main(String[] args) {
        StaticMethodDemo.test();//静态代码块！- 静态方法内容！- 静态方法中的代码块！
       /* StaticMethodDemo demo = new StaticMethodDemo(); //静态代码块！- 代码块！- 无参构造方法！
        demo.test();*/    //静态方法内容！ - 静态方法中的代码块！
    }
}
