package com.learn.dao;

import com.alibaba.fastjson.JSON;
import org.springframework.util.StringUtils;

import java.io.Serializable;

public class User implements Serializable {

    private String name;
    private Integer age;
    private String addr;

    public User(){

    }
// 重载（overloading） 发生在同一个类中，方法名必须一样， 参数类型不同、个数不同、顺序不同，返回值和修饰符可以不同。
    public User(String name){
        this.name = name;
    }

    public User(String name, Integer age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
    }

    public String getName() {
        if(!StringUtils.isEmpty(name)){
            return name;
        }
        return "小莹莹";
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public void action(){
        System.out.println("小莹莹爱我！");
    }

    private void jiao(){
        System.out.println("父类私有方法jiao");
    }

    public static void main(String[] args) {
        User u = new User();
        u.setName("");
        System.out.println(JSON.toJSONString(u));
    }
}
