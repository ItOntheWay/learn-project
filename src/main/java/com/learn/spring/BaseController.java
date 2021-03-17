package com.learn.spring;

import com.codahale.metrics.Counter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


@RequestMapping("/hi")
@ResponseBody
public class BaseController {

    @Autowired
    private Counter count;

    @RequestMapping("/springboot")
    public String query() {

        return "hi springBoot!";
    }

    @RequestMapping("/test")
    public String test(@RequestParam(defaultValue = "0") Long timeToLive){
        count.inc();
        if (timeToLive != null && timeToLive > 2592000) {
            timeToLive = timeToLive/1000;
        }
//        System.out.println("----"+timeToLive);
        return "ceshi";
    }
}
