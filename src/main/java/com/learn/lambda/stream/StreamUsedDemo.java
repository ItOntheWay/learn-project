package com.learn.lambda.stream;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
        /**
         * 按照list内对象某字段去重返回新的list
         * */
        /*List<UserDao> list = new ArrayList<>();
        UserDao dao1 = new UserDao();
        dao1.setId(1);
        dao1.setName("xiaoying");
        UserDao dao2 = new UserDao();
        dao2.setId(2);
        dao2.setName("xiaoying");
        UserDao dao3 = new UserDao();
        dao3.setId(3);
        dao3.setName("xiaoqiu");
        list.add(dao1);
        list.add(dao2);
        list.add(dao3);
        List<UserDao> lis2 = new ArrayList<>();
       list.stream().collect(Collectors.groupingBy(UserDao::getName, Collectors.toList())).forEach(
                (id,transfer) ->{
                    transfer.stream().reduce((u1,u2)->{
                        UserDao us = new UserDao();
                        us.setName(u1.getName());
                        us.setId(u1.getId());
//                        new UserDao(u1.getId(),u1.getName());
                        return us;
                    }).ifPresent(lis2::add);
                }
        );
        System.out.println(JSON.toJSONString(lis2));*/

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
