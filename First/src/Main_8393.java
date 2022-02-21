import java.util.Scanner;

public class Main_8393 {
    public static void main(String[] args){

          Scanner sc = new Scanner(System.in);
          int n = sc.nextInt();
          int result = 0;

          for (int i= 1; i<n+1; i++){
              result = i+ result;
          }
               System.out.print(result);

    }
}
