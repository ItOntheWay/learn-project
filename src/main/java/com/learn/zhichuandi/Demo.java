package com.learn.zhichuandi;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/1/18 16:59
 * 值传递、引用传递
 */
public class Demo {
    public static void main(String[] args) {
        int num = 10;
        foo(num);   //num值未改变
        System.out.println(num);
        String tt = "sh";
        foo(tt);//tt值未改变
        System.out.println(tt);
        StringBuilder str = new StringBuilder("iphone");
        foo(str);  //str值改变
        System.out.println(str);
        StringBuilder str2 = new StringBuilder("iphone");
        foo2(str2); //str2值未改变
        System.out.println(str2);

    }

    public static void foo(int value){
        value =100;
    }
    public static void foo(String text) {
        text = "windows";
    }
    public static void foo(StringBuilder sb) {
         sb = sb.append("12");
    }
    public static void foo2(StringBuilder sb) {
        sb = new StringBuilder("huawei");
    }
}
