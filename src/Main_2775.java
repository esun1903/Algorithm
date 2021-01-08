import java.util.Scanner;
import java.util.*;

public class Main_2775 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        /*  Test case 의 수 T */
        int t = sc.nextInt();
        int[] k = new int[t];
        int[] n = new int[t];
        int[][] total = new int[15][15]; //2차원 배열

        int [] result = new int [t];
        int test =0;


       for (int i = 0; i < t; i++) {
            k[i] = sc.nextInt();  //2
            n[i] = sc.nextInt();   //3
        }

        for (int i = 0; i < 15; i++) { // 1층
            for (int a = 1; a < 15; a++) { // 호수 가 늘어간다.
                if (i == 0) {
                    total[i][a] = a;
                } else {
                    for (int x = 1; x < a + 1; x++) {
                      test += total[i-1][x];
                    }
                    total [i][a] = test;
                    test = 0;
                }

            }
        }



         //각각의 Text case에 대해서 해당 집에 거주민 수를 출력하라.
        for (int i = 0; i < t; i++) {  //(1) test case수
          result[i] = total[k[i]][n[i]];
        }

        for(int i=0; i<t; i++)
            System.out.println(result[i]);


    }
}
