package com.learn.lambda.stream;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/29 16:15
 */
public class StreamUsedDemo {


    public static void main(String[] args) {
        stream();
    }


    public static void stream(){
        List<UserDao> list = new ArrayList<>();
        for(int i =0;i<4;i++){
            UserDao user = new UserDao();
            user.setId(i);
            user.setName("name_"+i);
            user.setVersion(i+"."+i+"."+i);
            list.add(user);
        }
        UserDao user = new UserDao();
        user.setId(5);
        user.setName("name_"+5);
        list.add(user);
        list.stream().forEach(u -> {
            if(StringUtils.isEmpty(u.getVersion())){
            u.setVersion("0");
            }
        });
       List<UserDao> s = list.stream().filter(u -> Integer.valueOf(u.getVersion().replace(".",""))>=200).collect(Collectors.toList());
       s.forEach(e -> System.out.println(e.getId()+"-"+e.getVersion()));
       List<UserDao> s1 = list.stream().filter(u -> Integer.valueOf(u.getVersion().replace(".",""))<200).collect(Collectors.toList());
       s1.forEach(e -> System.out.println(e.getId()+"-"+e.getVersion()));
    }
}
