package cn.neusoft.test;

/*

问题描述：母鸡3元/只，公鸡4元/只，小鸡0.5元/只，
如果花100元钱买100只鸡，每一种鸡可以买0只，请问有哪些可能？
 */
public class Baiyuanbaiji {

    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) { // 母鸡数量
            for (int j = 0; j <= 100; j++) { // 公鸡数量
                for (int k = 0; k <= 100; k++) { // 小鸡数量
                    // 判断数量是否为100，以及金额是否为100
                    if ((i+j+k == 100) && (i*3+j*4+k*0.5 == 100)) {
                        System.out.println("母鸡数量：" + i+ "公鸡数量：" + j + "小鸡数量" + k);
                    }
                }
            }
        }
    }
}
