package code.test;

public class Student {

    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /*
    根据name和age计算hashCode值
    场景：
       性别  年龄
        1*325    5*2145
        0*325    6*2145
        同时乘上一个固定值(随机，子要两个乘的是一样就行)
     */

    @Override
    public int hashCode() {
        return name.hashCode() * 3256 + age * 2314;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }
        if (obj instanceof Student) {
            Student otherStu = (Student) obj;//强转

            //对比name
            boolean nameOK = this.name.equals(otherStu.name);

            return nameOK ? this.age == otherStu.age : nameOK;

        }
        return false;
    }
}
