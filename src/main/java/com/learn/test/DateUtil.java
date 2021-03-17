package com.learn.test;

import java.util.Calendar;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/10/30 15:51
 */
public class DateUtil {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE,1);
        System.out.println("..."+Calendar.DATE+"..."+c.getTime());
    }
}
