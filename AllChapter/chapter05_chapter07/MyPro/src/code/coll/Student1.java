package code.coll;

import java.util.Objects;

public class Student1 {
    private String name;
    private int age;

    public Student1() {
    }

    public Student1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student1 student1 = (Student1) o;
        return age == student1.age && Objects.equals(name, student1.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "Student1{name = " + name + ", age = " + age + "}";
    }
}
