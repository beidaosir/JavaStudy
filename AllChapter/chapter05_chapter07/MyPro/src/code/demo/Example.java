package code.demo;

public class Example{
	String str = new String("good");
	char[] ch = {'a','b','c'};
	public static void main(String args[]){
		Example ex = new Example();
		ex.change(ex.str,ex.ch);
		System.out.print(ex.str+" and ");
		System.out.print(ex.ch);
	}
	public void change(String str1,char ch[]){
		str1 = "test ok";
		ch[0]='g';
	}
}
