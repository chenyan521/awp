package com.example.websocket01.entity;

/**
 * Created by 王尔玉 on 2019/11/20 19:08
 */
public class RequestParam {

    private Student student;

    private ClassRoom classRoom;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public ClassRoom getClassRoom() {
        return classRoom;
    }

    public void setClassRoom(ClassRoom classRoom) {
        this.classRoom = classRoom;
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "student=" + student +
                ", classRoom=" + classRoom +
                '}';
    }
}
