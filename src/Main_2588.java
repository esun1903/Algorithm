import java.util.Scanner;

public class Main_2588 {
  public static void main(String [] args){
     Scanner sc = new Scanner (System.in);
     int n = sc.nextInt();
     int n1 = sc.nextInt();

     System.out.println(n*(n1%10));
     System.out.println(n*((n1/10)%10));
     System.out.println(n*(n1/100));
     System.out.println(n*n1);
  }
}

