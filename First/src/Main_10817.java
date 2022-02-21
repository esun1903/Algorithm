import java.util.Scanner;

public class Main_10817 {
    public static void main(String [] args){

        //세 정수 a,b,c가 공백으로 구분되어 주어진다.
        Scanner rc = new Scanner(System.in);

        int a = rc.nextInt();
        int b = rc.nextInt();
        int c = rc.nextInt();
        int middle =0;

        if((a <=b) && (a >= c))
            middle = a;
        if((a <= c) && (a >= b))
            middle = a;

        if((b <=a) && (b >= c))
            middle = b;
        if((b <=c) && (b >= a))
            middle = b;

        if((c <=a) && (c >= b))
            middle = c;
        if((c <=b) && (c >= a))
            middle = c;

        System.out.println(middle);
    }
}
