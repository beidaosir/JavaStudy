
public class ArithmeticOperator{
	public static void main(String[] args) {
		//除法使用
		System.out.println(10/4);
		System.out.println(10.0/4);
		double d = 10/4;
		System.out.println(d);

		// 取模，取余
		//本质： a % b = a - a / b * b
		// 10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1
		System.out.println(10 % 3); // 1
		System.out.println(-10 % 3); // -1
	    System.out.println(10 % -3); // 1
	    System.out.println(-10 % -3); // -1
	    // -10 % -3 => -10 - (-10) / -3 * -3 = -10 + 9 = -1
	

		//++的使用
		//作为表达式使用
		//1. 前++：++i先自增后赋值
		//2. 后++：i++先赋值后自增

		int j = 8;
		// int k = ++j;//等价于 j = j + 1; k = j;
		// System.out.println("k = " + "j = " + j);//9 , 9
		int k = j++;//等价于 k = j; j = j + 1;
		System.out.println("k = " + k + "j = " + j);//8 , 9
	}
}