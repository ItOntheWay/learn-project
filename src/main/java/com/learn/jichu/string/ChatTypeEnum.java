package com.learn.jichu.string;

/**
 * 聊天发送方向
 * 
 * @author leju
 */
public enum ChatTypeEnum {
    P2P("1", "点对点互发"),
    P2S("2", "客户发给客服"),
    S2P("3", "客服发给客户"),
    P2PC("4", "客户发给顾问"),
    PC2P("5", "顾问发给客户"),
    CUSTOM("6", "自定义消息");

    // 成员变量
    private String type;
    private String description;

    // 构造方法
    private ChatTypeEnum(String type, String description) {
        this.type = type;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 根据key获得对应value
     * */
    public static ChatTypeEnum getByKey(String type) {
        for (ChatTypeEnum chatTypeEnum : ChatTypeEnum.values()) {
            if (type.equalsIgnoreCase(chatTypeEnum.getType())) {
                return chatTypeEnum;
            }
        }
        return null;
    }
    /**
     * 根据value获得对应key
     * */
    public static ChatTypeEnum getByValue(String value) {
        for (ChatTypeEnum chatTypeEnum : ChatTypeEnum.values()) {
            if (value.equalsIgnoreCase(chatTypeEnum.getDescription())) {
                return chatTypeEnum;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        ChatTypeEnum chatTypeEnum = getByKey("2");
        System.out.println(chatTypeEnum.getDescription());
    }
}
