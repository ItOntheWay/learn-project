package com.learn.jichu;
/**
 * 当在 try 块或 catch 块中遇到 return 语句时，finally 语句块将在方法返回之前被执行。
 * 当 try 语句和 finally 语句中都有 return 语句时，在方法返回之前，
 * finally 语句的内容将被执行，并且 finally 语句的返回值将会覆盖原始的返回值。
 * */
public class ExceptionDemo {
    public static void main(String[] args) {
        int res = test3();
        System.out.println("res= "+res);
    }

    public static int test3() {
        //try 语句块中有 return 语句时的整体执行顺序
        int i = 1;
        String[] s = new String[2];
        s[0] = "0";
        s[1] = "1";
        try {
            i++;
            System.out.println("try block, i = " + i);
            System.out.println("异常语句："+s[3]);
            System.exit(1);

            return i;
        } catch (Exception e) {
            i++;
            System.out.println("catch block i = " + i);
            return i;
        } finally {
            //异常发生在finally块第一行时finally不执行
//            System.out.println(s[3]);
            System.out.println("finally block ");
            i = 10;
//            System.out.println(s[3]);
            System.out.println("i = " + i);
//            return i;
        }
    }

}
