package com.learn.jichu.fanshe;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射操作 TargetObject类
 * */
public class ReflectOperationTargetObject {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> targetClass = Class.forName("com.learn.jichu.fanshe.TargetObject");
        TargetObject targetObject = (TargetObject)targetClass.newInstance();
        /**
         * 获取所有类中所有定义的方法
         */
        Method[] methods = targetClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /**
         * 获取指定方法并调用
         */
        Method publicMethod = targetClass.getDeclaredMethod("publicMethod",String.class);
        publicMethod.invoke(targetObject,"yingmeizhi");
        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = targetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject,"xiaoyingying");
        /**
         * 调用 private 方法
         */
        Method privateMethod = targetClass.getDeclaredMethod("privateMethod");
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
