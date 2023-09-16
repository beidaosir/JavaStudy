package code.practice;

public class Test03 {

    public static void main(String[] args) {

        int j=12,i=6,n=19;
        switch(j-i){
            case 5: n=n-i; break;
            case 6: n=n+9;
            case 7: n=n-i; break;
            default:n=n*2;

        }
        System.out.println(n);
    }
}
