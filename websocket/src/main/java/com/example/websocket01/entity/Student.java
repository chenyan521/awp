package com.example.websocket01.entity;

/**
 * Created by 王尔玉 on 2019/11/20 18:13
 */
public class Student {
    private Integer code;
    private String name;
    private String age;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
