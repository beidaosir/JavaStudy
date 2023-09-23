
public class ArithmeticOperatorExercise02{
	public static void main(String[] args) {
		//1.需求：定义一个变量保存华氏温度，华氏温度转换摄氏度的公式为
		//5/9*(华氏温度-100),请求出华氏温度对应的摄氏温度
		//2.思路分析：
		//(1)先定义一个double huashi 变量保存 华氏温度
		//(2)根据公式，进行计算   考虑数学公式和java语言的特性 5/9 => 0
		//(3)将得到的结果保存到double sheshi

		double huashi = 234.6;
		double sheshi = 5.0 / 9 * (huashi - 100);
		System.out.println("华氏温度" + huashi + "对应的摄氏温度=" + sheshi);
 
	}
}