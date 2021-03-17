package com.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SourceDao implements Cloneable{

    private String fatherName;
    private Person user;

    public SourceDao(SourceDao dao){
        this.fatherName = dao.fatherName;
        this.user = dao.getUser();
    }

    //浅拷贝
    /*public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        }catch (Exception e){
            System.out.println("克隆方法错误！");
        }
        return obj;
    }*/
    //深拷贝
    public Object clone(){
        Object obj = null;
        try {
            obj = super.clone();
        }catch (Exception e){
            System.out.println("克隆方法错误！");
        }
        SourceDao dao = (SourceDao) obj;
        dao.user = (Person) dao.getUser().clone();
        return obj;
    }
}
