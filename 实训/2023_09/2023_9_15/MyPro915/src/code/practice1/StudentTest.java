package code.practice1;

public class StudentTest {

    public static void main(String[] args) {

        Student s1 = new Student("张三","1001",78);
        Student s2 = new Student("李四","1002",98);
        Student s3 = new Student("王五","1003",72);
        Student s4 = new Student("赵六","1004",85);
        Student s5 = new Student("Tom","1005",91);
        Student s6 = new Student("Jack","1006",61);

        Student[] stus = {s1,s2,s3,s4,s5,s6};

        //给学生成绩排序的代码  可以抽取封装成一个方法
        StudentManager studentManager = new StudentManager();
        studentManager.sortStuScore(stus);



        for (int i = 0; i < stus.length; i++) {
            stus[i].showInfo();
        }


    }
}
