package com.learn.jichu;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.learn.dao.Person;
import com.learn.dao.SourceDao;
import com.learn.dao.SourceDao1;
import com.learn.dao.User;

/**
 * java 深拷贝、浅拷贝
 * */
public class ObjectCopyDemo {
    public static void main(String[] args) {
       /* //浅拷贝 对基本数据类型进行值传递，对引用数据类型进行引用传递般的拷贝，此为浅拷贝，重写clone方法、通过拷贝构造方法实现浅拷贝
        Person user = new Person("xiaoU",11,"bj");
        SourceDao dao1 = new SourceDao("laoF",user);
        SourceDao dao2 = new SourceDao(dao1);
        System.out.println("构造方法浅拷贝dao1:"+dao1);
        System.out.println("构造方法浅拷贝dao2:"+dao2);
        dao1.setFatherName("xiaoF");
        user.setName("小Y");
        user.setAge(29);
        System.out.println("修改后的dao1:"+dao1);
        System.out.println("修改后的dao2:"+dao2);*/
       /*//clone方法浅拷贝
        Person p = new Person("xiaoP",11,"bj");
        SourceDao dao1 = new SourceDao("laoF",p);
        SourceDao dao2 = (SourceDao) dao1.clone();
        System.out.println("clone方法浅拷贝dao1:"+dao1);
        System.out.println("clone方法浅拷贝dao2:"+dao2);
        p.setName("gaiP");
        p.setAge(27);
        dao1.setFatherName("gaiF");
        System.out.println("修改后的dao1:"+dao1);
        System.out.println("修改后的dao2:"+dao2);*/
       //深拷贝 对基本数据类型进行值传递，对引用数据类型，创建一个新的对象，并复制其内容，此为深拷贝
        /*Person p = new Person("xiaoP",11,"bj");
        SourceDao dao1 = new SourceDao("laoF",p);
        SourceDao dao2 = (SourceDao) dao1.clone();
        System.out.println("clone方法浅拷贝dao1:"+dao1);
        System.out.println("clone方法浅拷贝dao2:"+dao2);
        p.setName("gaiP");
        p.setAge(27);
        dao1.setFatherName("gaiF");
        System.out.println("修改后的dao1:"+dao1);
        System.out.println("修改后的dao2:"+dao2);*/
    }
}
