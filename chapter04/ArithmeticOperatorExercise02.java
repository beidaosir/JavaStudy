
public class ArithmeticOperatorExercise02{
	public static void main(String[] args) {
		//1.���󣺶���һ���������滪���¶ȣ������¶�ת�����϶ȵĹ�ʽΪ
		//5/9*(�����¶�-100),����������¶ȶ�Ӧ�������¶�
		//2.˼·������
		//(1)�ȶ���һ��double huashi �������� �����¶�
		//(2)���ݹ�ʽ�����м���   ������ѧ��ʽ��java���Ե����� 5/9 => 0
		//(3)���õ��Ľ�����浽double sheshi

		double huashi = 234.6;
		double sheshi = 5.0 / 9 * (huashi - 100);
		System.out.println("�����¶�" + huashi + "��Ӧ�������¶�=" + sheshi);
 
	}
}