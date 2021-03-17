package com.learn.jichu;

public class StaticMethod {
    private String language;

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public static void sayHello(){
        System.out.println("java say hello world !");
    }
}
