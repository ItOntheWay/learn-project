package com.learn.lambda;

import com.learn.dao.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    public static void main(String[] args) {
        List<User> entityList = Arrays.asList(
                new User("莹妹纸",27,"laojia"),
                new User("xiaoqiu",25,"laojia1"),
                new User("niaomeimei",24,"laojia2")
        );
       List<String> names = entityList.stream().map(User::getName).collect(Collectors.toList());
        System.out.println(names);
    }
}
