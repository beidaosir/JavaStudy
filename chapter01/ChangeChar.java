//演示转义字符的使用
public class ChangeChar{
	//编写一个main方法
	public static void main(String[] args){

	//  \t  一个制表位，实现对齐功能
		System.out.println("北京\t天津\t上海");

	//   \n 换行符
		System.out.println("北京\n天津\n上海");

	//   \\ ->  \
		System.out.println("北京\\天津\\上海");

	//   \r 表示回车，会回到当前行第一个位置 然后继续输出后面内容，会发生覆盖
		System.out.println("好好学习java\r天天向上"); //可能输出内容天天向上java
		//经过验证，输出结果为天天向上java

	//  换行输出好好学习java  天天向上
		System.out.println("好好学习java\r\n天天向上");
	}
}