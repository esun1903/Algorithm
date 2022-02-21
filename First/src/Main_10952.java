import java.util.Scanner;
import java.util.*;
public class Main_10952 {
    public static void main(String ... args){

        Scanner sc = new Scanner (System.in);
        int a = -1; // 0 0 인거를 체크하기 위해
        int b = -1;

        int a2[] = new int [10000];   //입력받은거 저장할 변수
        int b2[] = new int [10000];

        int t = 0;   //입력의 끝을 위해 체크할 변수

        //입력받은게 0이면 안된다.
        while((a != 0 ) &&(b != 0)){
            a2[t] = sc.nextInt(); //입력받은거 배열에 넣기
            b2[t] = sc.nextInt(); //입력받은거 배열에 넣기

            a = a2[t];  // 방금 입력받은거 넣기
            b = b2[t];
            t++;  //t-1까지 출력해야됨 왜냐하면 0 0 도 배열에 넣어지기 때문
        }

        for( int i=0; i<t-1; i++) {
            System.out.println(a2[i]+b2[i]);
        }
}
}
