package com.learn.dao;

public class Father {
    private String department;
    private String departmentName;
    private String departmentCode;

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentCode() {
        return departmentCode;
    }

    public void setDepartmentCode(String departmentCode) {
        this.departmentCode = departmentCode;
    }

    /**
     * 如果父类中只有有参构造函数，子类必须用 super()调用父类特定构造，否则编译错误。
     */
    public Father(String departmentName,String departmentCode){
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
    }

    public Father(){

    }
}
