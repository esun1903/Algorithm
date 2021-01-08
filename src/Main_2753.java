 import java.util.Scanner;
public class Main_2753 {
    public static void main (String[] args){
        //윤년은 연도가 4의 배수이면서,
        // 100의 배수가 아닐 때 또는 400의 배수일때
       Scanner rc = new Scanner(System.in);
       int n = rc.nextInt();
       //연도가 1보다 크거나 같아야하고 , 4000보다 작거나 같아야 됨
        if( n <1 || n >4000)
            System.exit(0);

        //윤년 계산
        if( n%4 != 0 ){
            System.out.print("0");
       }else if( n%4 == 0 && n%100 != 0) {
            System.out.print("1");
        } else if(n%4 == 0 && n%400 == 0){
            System.out.print("1");
        } else
            System.out.print("0");
    }
}
