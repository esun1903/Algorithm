import java.util.Scanner;

public class Main_9498 {
    public static void main(String[] args) {
        Scanner rc = new Scanner(System.in);
        int n = rc.nextInt();

        if (n < 0 || n > 100) {
            System.exit(0);
        }

        if (90 <= n && 100 >= n) {
            System.out.print("A");
        } else if(80 <= n && 90 > n){
            System.out.print("B");
        }  else if(70 <= n && 80 > n){
            System.out.print("C");
        }  else if(60 <= n && 70 > n) {
            System.out.print("D");
        }  else
             System.out.print("F");
    }
}
