package code.test;

public class Student {

    private String name;
    private String number;
    private int age;
    private char gender;
    private String major;

    public Student() {
    }

    public Student(String name, String number, int age, char gender, String major) {
        this.name = name;
        this.number = number;
        this.age = age;
        this.gender = gender;
        this.major = major;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", number='" + number + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", major='" + major + '\'' +
                '}';
    }
}
