package com.learn.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SourceDao1 implements Serializable {
    private String fatherName;
    private User user;

    public SourceDao1(String fatherName){
        this.fatherName = fatherName;
    }
}
