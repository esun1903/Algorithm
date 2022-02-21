import java.util.*;
import java.util.Scanner;

public class Main_30552 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int n[] = new int[10];
        int t[] = new int[10];

        int midlle=0;
        int result = 0;

        //열번 입력
        for (int i = 0; i < 10; i++) {
            n[i] = sc.nextInt(); //10번 입력받기
            t[i] = n[i] % 42; //42로 나눈 나머지값들
        }

        //배열에서 같은 값을 찾기
        // 0 1 2 0 1 2
        for(int x = 0; x <10; x++) {
            int same = 0; //같은 값이 없다
            for (int i = x+1 ; i < 10; i++) {  //같은 값
                if (t[x] == t[i]) //t[0] == t[3]
                    same++;
            }
            if(same == 0)// 같은값이 없을때만 count ++:
                result ++;

        }

        System.out.println(result);
    }
}
