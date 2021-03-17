package com.learn.test;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSub {
    public static void main(String[] args) {
        String group = "103934972@person/socket-test153-pc/iOS";
        String uid = getUid(group);
        System.out.println("----"+uid);
        getLongUid(group);
    }

    public static String getUid(String clientId) {
        String uid = null;
        if (StringUtils.isEmpty(clientId)) {
            return uid;
        }
        if (clientId.indexOf("@") == -1) {
            System.out.println(1111111);
            uid = clientId;
        } else {
            System.out.println(2222);
            uid = clientId.substring(0, clientId.indexOf("@"));
        }
        return uid;
    }

    public static long getLongUid(String clientId) {
        long uid = 0;
        if (clientId == null || clientId.equals("")) {
            return uid;
        }
        if (clientId.indexOf("@") == -1) {
            System.out.println(33333);
            Pattern pattern = Pattern.compile("[0-9]*");
            Matcher isNum = pattern.matcher(clientId);
            if( !isNum.matches() ){
                uid = 0;
            }else{
                uid = Long.parseLong(clientId);
            }
        } else {
            //业务方 有时候会传错误的groupUid("@group/newhouse"),导致后端无法处理
            String subStr = clientId.substring(0, clientId.indexOf("@"));
            System.out.println(444);
            if(!StringUtils.isEmpty(subStr)){
                uid = Long.parseLong(subStr);
            }
//            uid = Long.parseLong(clientId.substring(0, clientId.indexOf("@")));
        }
        return uid;
    }
}
