package com.studentdataentrysql.model;

public class Student {
    private int prn;
    private String name;
    private String position;
    private int age; // ✅ Added age

    public Student(int prn, String name, String position, int age) {
        this.prn = prn;
        this.name = name;
        this.position = position;
        this.age = age;
    }

    public int getPrn() {
        return prn;
    }

    public void setPrn(int prn) {
        this.prn = prn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}