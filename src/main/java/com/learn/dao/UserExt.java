package com.learn.dao;

public class UserExt extends User {

    private String sex;
    private String love;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    /**
     * 重写
     * 重写发生在运行期，是子类对父类的允许访问的方法的实现过程进行重新编写。
     *
     * 返回值类型、方法名、参数列表必须相同，抛出的异常范围小于等于父类，访问修饰符范围大于等于父类。
     * 如果父类方法访问修饰符为 private/final/static 则子类就不能重写该方法，但是被 static 修饰的方法能够被再次声明。
     * 构造方法无法被重写
     * */
    public void action(){
        System.out.println("我爱小莹莹！");
    }

    public static void main(String[] args) {
        UserExt userExt = new UserExt();
        userExt.action();
//        userExt.jiao();  //
        User user = new UserExt();
        user.action();
        User user1 = new User();
        user1.action();
    }
}
