package com.example.websocket01.entity;

/**
 * Created by 王尔玉 on 2019/11/20 18:18
 */
public class ClassRoom {


    private String className;
    private String school;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "ClassRoom{" +
                "className='" + className + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}
