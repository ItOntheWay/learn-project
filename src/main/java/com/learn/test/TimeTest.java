package com.learn.test;

import java.util.Random;

/**
 * @author jingpb
 * @version 1.0
 * @date 2021/4/15 0:10
 */
public class TimeTest {
    public static void main(String[] args) {
        for(int i =0 ;i<2;i++){
            Random r = new Random();
            int random = r.nextInt(100);
            System.out.println(random);
        }

    }
}
