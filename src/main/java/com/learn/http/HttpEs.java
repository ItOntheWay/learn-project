package com.learn.http;

import com.github.kevinsawicki.http.HttpRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/11/3 15:35
 */
public class HttpEs {
    public static void main(String[] args) {
        HttpRequest request = HttpRequest.post("http://10.204.26.25:9400/bi__new_news/_search");
        request.header("contentType", "application/json;charset=UTF-8");
        Map<String, Object> map=new HashMap<>();
        map.put("hid","157758");
        HttpRequest s = request.form(map);
        System.out.println("----"+s.body());
        HttpRequest request1 = HttpRequest.get("http://10.204.26.25:9400/bi__new_news/_search",true,"hid","157758");
        System.out.println("----"+request1.body());
    }
}
