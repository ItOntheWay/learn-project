package com.learn.test;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/11/20 18:04
 */
public class StringTest {
    public static void main(String[] args) {
        String s = "IMCHATSESSIONID:16263:s7789093";
        String ss = s.replace("IMCHATSESSIONID:","");
        System.out.println(ss);
    }
}
