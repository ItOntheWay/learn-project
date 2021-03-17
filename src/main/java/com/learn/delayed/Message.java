package com.learn.delayed;

import org.apache.commons.lang3.StringUtils;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @author jingpb
 * @version 1.0
 * @date 2020/11/25 10:08
 */
public class Message implements Delayed {

    private Integer id;
    private String body; // 消息内容
    private long excuteTime;// 延迟时长，这个是必须的属性因为要按照这个判断延时时长。

    public Message(int id, String body, long delayTime) {
        this.id = id;
        this.body = body;
//        this.excuteTime = TimeUnit.NANOSECONDS.convert(delayTime, TimeUnit.MILLISECONDS) + System.nanoTime();
        this.excuteTime = delayTime + System.currentTimeMillis();
    }

    @Override
    public long getDelay(TimeUnit unit) {
//        return unit.convert(this.excuteTime - System.nanoTime(), TimeUnit.NANOSECONDS);
        return excuteTime - System.currentTimeMillis();
    }

    /**
     * 用于延迟队列内部进行排序，将最先到期的放在队首，保证take出来的是到期的那个
     */
    @Override
    public int compareTo(Delayed delayed) {
        Message msg = (Message) delayed;
        //按id 出队列
        return Integer.valueOf(this.id) > Integer.valueOf(msg.id) ? 1
                : (Integer.valueOf(this.id) < Integer.valueOf(msg.id) ? -1 : 0);
        //按到期时间出队列
//        return this.excuteTime > msg.excuteTime ? 1 :this.excuteTime<msg.excuteTime ?-1:0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public long getExcuteTime() {
        return excuteTime;
    }

    public void setExcuteTime(long excuteTime) {
        this.excuteTime = excuteTime;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj ){
            return true;//地址相等
        }
        if(obj == null ){
            return false;//非空性：对于任意非空引用x，x.equals(null)应该返回false。
        }
        if(obj instanceof Message){
            Message m = (Message) obj;
            if(equalsInt(this.id, m.id)){
                return true;
            }
        }
        return false;
    }

    private boolean equalsStr(String str1, String str2){
        if(StringUtils.isEmpty(str1) && StringUtils.isEmpty(str2)){
            return true;
        }
        if(!StringUtils.isEmpty(str1) && str1.equals(str2)){
            return true;
        }
        return false;
    }

    private boolean equalsInt(Integer int1, Integer int2){
        if(int1 ==null && int2 ==null){
            return true;
        }
        if(int1.intValue() == int2.intValue()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + (id == null ? 0 : String.valueOf(id).hashCode());
//        result = 31 * result + (age == null ? 0 : age.hashCode());
        return result;
    }
}
