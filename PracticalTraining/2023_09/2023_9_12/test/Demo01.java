/*利用Java的变量创建变量学生学号（值为1002），
学生姓名(值为张三)，学生性别（值为男），
学生成绩（值为98.5），将变量的信息输出在控制台上。*/
public class Demo01{
	public static void main(String[] args) {
		String stu_num = "1002";
		String name = "张三";
		char gender = '男';
		double score = 98.5;
		System.out.println(name+"\t"+gender+"\t"+stu_num+"\t"+score);
	}
}