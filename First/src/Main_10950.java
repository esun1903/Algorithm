import java.util.Scanner;

public class Main_10950 {
   public static void main(String [] args){

       Scanner rc = new Scanner(System.in);

       int t = rc.nextInt();
       int num[] =new int [t*2]; //배열 생성 t개의 2배
       int number=0;
       int resnum=0;

       for(int i= 0; i<t ; i++){ //배열을 받기
           int n1 = rc.nextInt();
           num[number++]= n1;
           int n2 = rc.nextInt();
           num[number++]= n2;
       }

       for(int i =0; i<t; i++){
           System.out.println(num[resnum++]+num[resnum++]);
       }
 }
}
