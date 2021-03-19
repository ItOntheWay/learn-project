package com.learn.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/17 16:58
 */
public class DateUtils {

    //計算兩個日期相差幾個月，不判斷大小
    public static int getMonthAbs() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str1 = "2009-01";
        String str2 = "2010-01";
        Calendar bef = Calendar.getInstance();
        Calendar aft = Calendar.getInstance();
        bef.setTime(sdf.parse(str1));
        aft.setTime(sdf.parse(str2));
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int month = (aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR)) * 12;
        System.out.println(Math.abs(month + result));
        return Math.abs(month + result);
    }

    public static void main(String[] args) throws ParseException {

    }
}
