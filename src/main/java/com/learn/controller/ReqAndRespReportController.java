package com.learn.controller;

import com.alibaba.fastjson.JSONObject;
import com.learn.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReqAndRespReportController {
    private static final Logger log = LoggerFactory.getLogger(ReqAndRespReportController.class);

    @RequestMapping("/test/report/restandresp")
    @ResponseBody
    public Result test(String name,String age,String addr){
        JSONObject json = new JSONObject().fluentPut("name",name)
                .fluentPut("age",age).fluentPut("addr",addr);
        Result result = new Result(json);
        return result;
    }

}
