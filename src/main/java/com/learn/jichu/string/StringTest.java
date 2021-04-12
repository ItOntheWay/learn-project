package com.learn.jichu.string;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.codec.digest.DigestUtils;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/12/3 16:12
 */
public class StringTest {

    public static String getUid(String clientId) {
        String uid = null;
        if (StringUtils.isEmpty(clientId)) {
            return uid;
        }
        if (clientId.indexOf("undefined") != -1) {
            return null;
        }
        if (clientId.indexOf("@") == -1) {
            uid = clientId;
        } else {
            uid = clientId.substring(0, clientId.indexOf("@"));
        }
        return uid;
    }


    public static void main(String[] args) {
        /*String group = "@group/newhouse";
        String chatGroup = getUid(group);
        Long groupUid = StringUtils.isNotEmpty(chatGroup) ? Long.valueOf(chatGroup) : 0;
        Integer.valueOf(groupUid.intValue());*/
        /*SimpleDateFormat sdf = new SimpleDateFormat("YYYYMMdd");
        String authStr = "shmeifang_shmeifang20190410_"+ sdf.format(new Date());
        System.out.println(authStr);
        System.out.println(DigestUtils.md5Hex(DigestUtils.md5Hex(authStr)));*/
        /*String ext = "{\"content\":\"内容\",\"extra\":{\"meifang\":{\"username\":\"经纪人账号\"}}}";
        JSONObject json = JSONObject.parseObject(ext);
        JSONObject extra = json.getJSONObject("extra");
        System.out.println(extra.getJSONObject("meifang").toJSONString());*/
        String version = "3.0.0";
        Integer s = Integer.valueOf(version.replace(".",""));
        System.out.println(s);
    }
}
