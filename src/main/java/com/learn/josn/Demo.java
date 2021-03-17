package com.learn.josn;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.List;
import java.util.Objects;

public class Demo {
public static String str = new String("java");
public static char[] ch = {'p','y','t','h','o','n'};
    public static void main(String[] args) {
        /*String res = "{\"message\":\"\\u6210\\u529f\",\"status\":0,\"host\":\"0\",\"etime\":\"0.025\",\"time\":\"0.005\"}\n";
        JSONObject jsonObject = JSON.parseObject(res);
//        String data1 = jsonObject.get("data").toString();
        Object data = jsonObject.get("data");
        if(Objects.isNull(data)){
            System.out.println("ooooo"+data);
        }*/
        /*JSONArray jsonArray = null;
        if(!jsonArray.isEmpty() && jsonArray.size()>0){
            System.out.println("bu");
        }else{
            System.out.println("null");
        }*/
        /*Demo demo = new Demo();
        demo.exchange(str,ch);
        System.out.println(demo.str);
        System.out.println(demo.ch);
    }
    public void exchange(String str, char[] ch){
        str = "hello";
        ch[0] = 'g';
    }*/
        String arg= "";
        System.out.println(null == arg || "null".equals(arg) || arg.trim().length() < 1);
    }
}
