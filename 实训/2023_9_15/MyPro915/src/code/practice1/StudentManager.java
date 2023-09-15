package code.practice1;


public class StudentManager{

    //给学生成绩排序
    public void sortStuScore(Student[] stus){
        //给学生成绩排序的代码  可以抽取封装成一个方法
        for (int i = 1; i < stus.length; i++) {

            for (int j = 0; j < stus.length-i; j++) {
                //按照降序排列，最大值在前面
                if (stus[j].score <stus[j+1].score){
                    Student temp = stus[j];
                    stus[j] = stus[j+1];
                    stus[j+1] = temp;

                }
            }
        }
    }

}