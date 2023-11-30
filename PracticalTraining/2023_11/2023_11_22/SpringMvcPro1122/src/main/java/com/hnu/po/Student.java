package com.hnu.po;

public class Student {

    private String stuNumber;
    private String stuName;
    private Integer age;

    public Student() {
    }

    public Student(String stuNumber, String stuName, Integer age) {
        this.stuNumber = stuNumber;
        this.stuName = stuName;
        this.age = age;
    }

    public String getStuNumber() {
        return stuNumber;
    }

    public void setStuNumber(String stuNumber) {
        this.stuNumber = stuNumber;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNumber='" + stuNumber + '\'' +
                ", stuName='" + stuName + '\'' +
                ", age=" + age +
                '}';
    }
}
