
public class ArithmeticOperator{
	public static void main(String[] args) {
		//����ʹ��
		System.out.println(10/4);
		System.out.println(10.0/4);
		double d = 10/4;
		System.out.println(d);

		// ȡģ��ȡ��
		//���ʣ� a % b = a - a / b * b
		// 10 % 3 => -10 - (-10) / 3 * 3 = -10 + 9 = -1
		System.out.println(10 % 3); // 1
		System.out.println(-10 % 3); // -1
	    System.out.println(10 % -3); // 1
	    System.out.println(-10 % -3); // -1
	    // -10 % -3 => -10 - (-10) / -3 * -3 = -10 + 9 = -1
	

		//++��ʹ��
		//��Ϊ���ʽʹ��
		//1. ǰ++��++i��������ֵ
		//2. ��++��i++�ȸ�ֵ������

		int j = 8;
		// int k = ++j;//�ȼ��� j = j + 1; k = j;
		// System.out.println("k = " + "j = " + j);//9 , 9
		int k = j++;//�ȼ��� k = j; j = j + 1;
		System.out.println("k = " + k + "j = " + j);//8 , 9
	}
}