

public class Demo02 {

    public static void main(String[] args) {

        System.out.println("Hello World");

        int score = 80;

        //����֧
        /*if(score>=80){
            System.out.println("����Ϸ��");
        }*/

        //˫��֧
        /*if(score>=80){
            System.out.println("������Ϸ��");
        }else{
            System.out.println("��ͳԷ�");
        }*/

        //���֧

        //���жϺ�����
        if(score>100 || score<0){

            System.out.println("�������ں���Χ[0~100]");

        }else{

            if (score>=90){
                System.out.println("����");
            }else if(score>=70){
                System.out.println("����");
            }else if(score>=60){
                System.out.println("����");
            }else{
                System.out.println("������");
            }


        }



    }

}
