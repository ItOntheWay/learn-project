package com.learn.dao;

public class Son extends Father {

    private String floor;

    public Son(String departmentName, String departmentCode) {
        super(departmentName, departmentCode);
//        super();
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }


}
