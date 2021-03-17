package com.learn.test;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;

public class ConsultantInfo implements Serializable {
    private String nid; //对应im系统user表的userName
    private String imid; //对应im系统user表的userId
    private String username;//顾问名
    private String mobile;//手机
    private String years;//服务年限
    private String mobile_tel;//移动端用400电话
    private String pc_tel; // pc用400电话
    private String subphone;//分机号
    private String logo;
    private String live_uid; //腾讯vr、直播用户id
    private String imVersion;

    public String getNid() {
        return nid;
    }

    public void setNid(String nid) {
        this.nid = nid;
    }

    public String getImid() {
        return imid;
    }

    public void setImid(String imid) {
        this.imid = imid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getMobile_tel() {
        return mobile_tel;
    }

    public void setMobile_tel(String mobile_tel) {
        this.mobile_tel = mobile_tel;
    }

    public String getPc_tel() {
        return pc_tel;
    }

    public void setPc_tel(String pc_tel) {
        this.pc_tel = pc_tel;
    }

    public String getSubphone() {
        return subphone;
    }

    public void setSubphone(String subphone) {
        this.subphone = subphone;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getLive_uid() {
        return live_uid;
    }

    public void setLive_uid(String live_uid) {
        this.live_uid = live_uid;
    }

    public String getImVersion() {
        return imVersion;
    }

    public void setImVersion(String imVersion) {
        this.imVersion = imVersion;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
