package com.learn.controller;

import com.codahale.metrics.Counter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerDemo {
    private static final Logger log = LoggerFactory.getLogger(ControllerDemo.class);

    @Autowired
    private Counter count;

    @RequestMapping("/hello/test")
    public String test(){
        log.info(".............");
        try{
            count.inc();
        }catch (Exception e){

        }finally {
            count.dec();
        }
        return "ceshi";
    }

}
