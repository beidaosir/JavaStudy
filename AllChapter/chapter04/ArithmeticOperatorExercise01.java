//课堂练习
public class ArithmeticOperatorExercise01{
	public static void main(String[] args) {
		//1.需求：假如还有59天放假，问：合xx个星期零x天
		//2.思路分析：
		//(1)使用int 变量days 保存 天数
		//(2)一个星期是7天 星期数weeks：days / 7 零xx天leftDays days % 7
		//(3)输出

		int days = 59;
		int weeks = days / 7;
		int leftDays = days % 7;
		System.out.println(days + "天 合" + weeks + "星期零" + leftDays + "天");




	}
}