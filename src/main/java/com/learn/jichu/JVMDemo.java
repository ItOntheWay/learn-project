package com.learn.jichu;

import com.learn.dao.User;

/**
 *  从jvm内存模型分析值传递，引用传递
 *  https://blog.csdn.net/bntx2jsqfehy7/article/details/83508006
 * */
public class JVMDemo {
    public static void main(String[] args) {
        User u = new User("xiaoA",27,"3501");
        PersonCrossTest(u);
        System.out.println("方法执行后的name:"+u.getName());
    }
    public static void PersonCrossTest(User user){
        System.out.println("传入的user的name:"+user.getName());
//        user.setName("xiaoB");
        user = new User("xiaoC");
        System.out.println("方法内重新赋值后的name:"+user.getName());
    }
}
