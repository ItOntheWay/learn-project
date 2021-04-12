package com.learn.lambda.stream;

/**
 * @author jpb
 * @version 1.0
 * @date 2021/3/29 16:16
 */
public class UserDao {
    private Integer id;
    private String name;
    private String phone;
    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
