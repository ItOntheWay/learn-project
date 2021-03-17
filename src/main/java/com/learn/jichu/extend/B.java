package com.learn.jichu.extend;

public class B extends A {
    public int getNum(int a, char c){
    return a+1;
    }

    public static void main(String[] args){
        B b=new B();
        System.out.println(b.getNum(0));

    }
}
