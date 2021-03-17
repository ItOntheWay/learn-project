package com.learn.springboot;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@RequestMapping("/hitest")
@ResponseBody
public class Test {

    public String test(){
        return "hi test!";
    };
}
