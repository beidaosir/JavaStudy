package code.practice1;

/*
7.设计一个类Student，该类包括姓名、学号和成绩。
设计一个方法，按照成绩从高到低的顺序输出姓名、学号和成绩信息。
 */
public class Student {

    String name;
    String number;
    float score;

    //构造


    public Student() {

    }

    public Student(String name, String number, float score) {
        this.name = name;
        this.number = number;
        this.score = score;
    }

    void showInfo(){
        System.out.println(name + " " + number + " " + score);
    }


}
