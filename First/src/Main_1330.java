import java.util.Scanner;

public class Main_1330 {
    public static void main(String[] args){
        Scanner rc = new Scanner(System.in);
        int n1 = rc.nextInt();
        int n2=  rc.nextInt();

        if( n1 <= -10000 || n1 > 10000 || n2 <= -10000 || n2 > 10000 ){
            System.exit(0);
        }

        if( n1 < n2)
            System.out.println("<");
        if (n1 == n2)
            System.out.println("==");
        if(n1 > n2)
            System.out.println(">");
    }
}
