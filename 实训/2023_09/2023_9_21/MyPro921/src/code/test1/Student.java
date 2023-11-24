package code.test1;
/*
Student必须可比较，才能放入treeset中
1、 implements Comparable<Student>
2、 实现compareTo方法
 */
public class Student implements Comparable<Student>{

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
    按照年龄排序
    可以根据自己的需求编写
     */
    @Override
    public int compareTo(Student o) {
        //比较姓名，根据姓名排序，谁的字典靠前谁就放在前面
        int nameRet = this.name.compareTo(o.name);

        //如果姓名相同  比较年龄
        return nameRet==0?o.age - this.age:nameRet;//降序
        //return this.age - o.age; //升序
    }
}
