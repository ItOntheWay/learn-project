package com.learn.jichu;

import com.google.common.collect.Lists;
import com.learn.dao.User;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        /*StaticMethod sm = new StaticMethod();
        sm.sayHello();
        StaticMethod.sayHello();*/
        /*Map map = new HashMap<String ,String>();
        map.put("a","a1");
        map.put("a0","a2");
        Object s = map.remove("a0");
        System.out.println(s.toString());*/
        String a = new String("ab"); // a 为一个引用
        String b = new String("ab"); // b为另一个引用,对象的内容一样
        String aa = "ab"; // 放在常量池中
        String bb = "ab"; // 从常量池中查找
        if (aa == bb) // true
            System.out.println("aa==bb");
        if (a == b) // false，非同一对象
            System.out.println("a==b");
        if (a.equals(b)) // true
            System.out.println("aEQb");
        if (42 == 42.0) { // true
            System.out.println("true");
        }
        if(a.equals(aa))  //基本数据类型比较值是否相等
        {
            System.out.println("aEQaa");
        }
//        String body = "对方发送了%s定位";
        /*List<User> users = Arrays.asList(new User("niaomeimei",24,"www"),
                new User("xiaoqiu",25,"www1"),
                new User("yingmeizhi",26,"xxx1"),
                new User("zhangfu",26,"xxx"));
        for(User user :users){
            if(user.getName().equalsIgnoreCase("yingmeizhi")){
                continue;
            }
            System.out.println(user.getName());
        }*/
    }
}
