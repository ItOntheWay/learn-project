package com.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 阿里开发手册建议 所有的POJO类必须使用包装类
 * 因为：包装类为空和为0可以代表不同的含义，
 * */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Person implements Cloneable{
    private String name;
    private Integer age;
    private String addr;

    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        }catch (Exception e){
            System.out.println("--- there has error with object copy method ---");
        }
        return obj;
    }
}
