package code.practice;

/*
猴子第一天摘下若干个桃子，当即吃了一半，还不瘾，又多吃了一个，
第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
以后每天早上都吃了前一天剩下的一半零一个。
到第10天早上想再吃时，见只剩下一个桃子了。求第一天共摘了多少
 */
public class Test09 {

    public static void main(String[] args) {

        int total = 1;//第十天仅剩一个
        for (int i = 9; i > 0; i--) {
            //天数递减，倒推
            total = (total+1)*2;//计算每一天的吃桃数
        }


        System.out.println("第一天共摘了：" + total + " 个桃子");
    }


}
