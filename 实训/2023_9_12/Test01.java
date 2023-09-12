public class Test01{
    public static void main(String[] args) {
    	int a=4, b=1, x=6;
		if(a==b) x+=a;
		else x=++a*x;
		System.out.println(x);
    }
}

