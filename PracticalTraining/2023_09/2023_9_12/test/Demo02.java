

public class Demo02 {

    public static void main(String[] args) {

        System.out.println("Hello World");

        int score = 80;

        //单分支
        /*if(score>=80){
            System.out.println("买游戏机");
        }*/

        //双分支
        /*if(score>=80){
            System.out.println("给买游戏机");
        }else{
            System.out.println("请客吃饭");
        }*/

        //多分支

        //先判断合理性
        if(score>100 || score<0){

            System.out.println("分数不在合理范围[0~100]");

        }else{

            if (score>=90){
                System.out.println("优秀");
            }else if(score>=70){
                System.out.println("良好");
            }else if(score>=60){
                System.out.println("及格");
            }else{
                System.out.println("不及格");
            }


        }



    }

}
