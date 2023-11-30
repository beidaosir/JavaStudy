package code.test3;

import java.io.Serializable;

/*
要将Student类的对象写入到文件中  需要对其进行序列化
Student类实现接口 Serializable
 */
public class Student implements Serializable {

    private Integer number;
    private String name;
    private double score;

    public Student() {
    }

    public Student(Integer number, String name, double score) {
        this.number = number;
        this.name = name;
        this.score = score;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

