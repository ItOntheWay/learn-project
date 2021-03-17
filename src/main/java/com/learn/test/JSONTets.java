package com.learn.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Objects;

public class JSONTets {
    public static void main(String[] args) {
        String str = "{\"message\":\"\\u6210\\u529f\",\"status\":1,\"host\":\"0\",\"etime\":\"0.015\",\"time\":\"0.005\",\"data\":[{\"id\":\"844466574134991048\",\"nid\":\"121032\",\"mobile\":\"18611514565\",\"password\":\"\",\"weixin\":\"12345678\",\"uid\":\"20000000016304\",\"username\":\"\\u9ad8\\u6768\\u5b87\",\"sex\":\"1\",\"birthday\":\"0\",\"logo\":\"http:\\/\\/src.leju.com\\/imp\\/imp\\/deal\\/01\\/fd\\/9\\/5c1bb26097ff63146f66eda65f4_p47_mk47.jpg\",\"subphone\":\"18639\",\"card\":\"http:\\/\\/src.leju.com\\/imp\\/imp\\/deal\\/18\\/3b\\/e\\/9eafa64e35c05588d1971944469_p47_mk47.jpg\",\"role\":\"1\",\"status\":\"5\",\"car_status\":\"2\",\"s_status\":\"2\",\"pingjia\":\"\",\"city_en\":\"ab\",\"hid\":\"143822\",\"house_id\":\"164709\",\"company\":\"\\u4e50\\u5c45\",\"years\":\"8\",\"live_uid\":\"4500200077\",\"is_orders\":\"1\",\"imid\":\"103103870\",\"trash\":\"0\",\"tags\":\"\\u9500\\u552e\\u51a0\\u519b,\\u5168\\u80fd\\u987e\\u95ee\",\"device\":\"0\",\"apptoken\":\"\",\"is_deal\":\"1\",\"is_recommend\":\"1\",\"sort\":\"0\",\"tid_1\":\"0\",\"tid_2\":\"0\",\"tid_3\":\"0\",\"begin_time\":\"0:00\",\"end_time\":\"24:00\",\"create_time\":\"1541572070\",\"update_time\":\"1582983383\",\"login_time\":\"1600223720\",\"create_source\":\"9\",\"audit_time\":\"1541572096\",\"reject_time\":\"0\",\"is_limit\":\"0\",\"weight\":\"0\",\"is_trade\":\"0\",\"is_clue\":\"0\",\"system_create_time\":\"1568017319\",\"system_update_time\":\"1600223721\",\"open_id\":\"\",\"is_wchat_bind\":\"0\",\"service_house_show\":\"1\",\"system_sharding_id\":\"606\",\"system_sharding_flag\":\"3000\",\"system_type\":\"laike_zygw\",\"city_hid\":\"ab143822\",\"dongtai_createtime\":\"1569728223\",\"is_svip\":\"0\",\"homepage\":\"http:\\/\\/zygw.bch.leju.com\\/homepage\\/index?zid=121032\",\"pc_tel\":\"4000010568\",\"mobile_tel\":\"4000550568\",\"imgroupid\":\"100155693@group\\/newhouse\",\"score\":\"\\u597d\\u8bc4\\u7387\\uff1a0%\",\"service_city\":\"ab\",\"level_ident\":\"0\",\"main_hid\":\"143822\",\"serve_hid\":\"\",\"level_name\":\"\",\"live_status\":\"1\",\"status_sub\":\"0\",\"liveroom_status\":\"1\",\"is_eju\":\"0\",\"act_level\":\"\"}]}";
        JSONObject jsonObject = JSON.parseObject(str);
        Object data = jsonObject.get("data");
        if (!Objects.isNull(data)) {
            List<ConsultantInfo> consultants = JSONObject.parseArray(jsonObject.get("data").toString(), ConsultantInfo.class);
            if (!CollectionUtils.isEmpty(consultants)) {
                ConsultantInfo consultantInfo = consultants.get(0);
                JSONObject consultantInfoObj = JSON.parseObject(JSONObject.toJSONString(consultantInfo));
                System.out.println(consultantInfoObj);
            }
        }
    }
}
