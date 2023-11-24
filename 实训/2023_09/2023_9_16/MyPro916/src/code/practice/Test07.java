package code.practice;

public class Test07 {
    public static void main(String[] args) {
        double profit = 300000.0; // 当月利润
        double bonus = calBonus(profit); // 计算奖金
        System.out.println("应发放奖金总数：" + bonus);
    }

    public static double calBonus(double profit) {
        double bonus = 0.0;
        if (profit <= 100000.0) {
            bonus = profit * 0.1;
        } else if (profit > 100000.0 && profit <= 200000.0) {
            bonus = 100000.0 * 0.1 + (profit - 100000.0) * 0.075;
        } else if (profit > 200000.0 && profit <= 400000.0) {
            bonus = 100000.0 * 0.1 + 100000.0 * 0.075 + (profit - 200000.0) * 0.05;
        } else if (profit > 400000.0 && profit <= 600000.0) {
            bonus = 100000.0 * 0.1 + 100000.0 * 0.075 + 100000.0 * 0.05 + (profit - 400000.0) * 0.03;
        } else if (profit > 600000.0 && profit <= 1000000.0) {
            bonus = 100000.0 * 0.1 + 100000.0 * 0.075 + 100000.0 * 0.05 + 100000.0 * 0.03 + (profit - 600000.0) * 0.015;
        } else {
            bonus = 100000.0 * 0.1 + 100000.0 * 0.075 + 100000.0 * 0.05 + 100000.0 * 0.03 + 100000.0 * 0.015 + (profit - 1000000.0) * 0.01;
        }
        return bonus;
    }
}
