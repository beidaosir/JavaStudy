package code.practice;
/*
假设某员工今年的年薪是30000元，年薪的年增长率6%。
编写一个Java应用程序计算该员工10年后的年薪，并统计未来10年（从今年算起）总收入。
 */
public class Test08 {

    public static void main(String[] args) {
        double salary = 30000.0; // 当前年薪
        double rate = 0.06; // 年增长率
        int years = 10; // 未来10年

        double futureSal = calFutureSal(salary, rate, years); // 计算10年后的年薪
        double totalIncome = calTotalIncome(salary, rate, years); // 计算未来10年总收入

        System.out.println("10年后的年薪：" + futureSal);
        System.out.println("未来10年总收入：" + totalIncome);
    }

    public static double calFutureSal(double salary, double rate, int years) {
        double futureSal = salary * Math.pow(1 + rate, years);
        return futureSal;
    }

    public static double calTotalIncome(double salary, double rate, int years) {
        double totalIncome = salary * years * (1 + rate) * years;
        return totalIncome;
    }
}
