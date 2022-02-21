import java.util.Scanner;
import java.util.*;

public class Main_4344 {
    public static void main(String... args) {


        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt(); //(1)  테스트 케이스 개수 C
        int n[] = new int[c]; //(1)  배열을 저장하기 1 (5가지의 과목 갯수 )
        int sum;
        int average;
        int num = 0;
        String result[] = new String[c];  //(1) 만큼의 결과배열 저장

        for (int i = 0; i < c; i++) {   // (1) 5만큼

            n[i] = sc.nextInt();  //  (2) 그 중 첫번째 학생 수
            int ress[] = new int[n[i]]; // (2) 에 대한 점수 배열
            sum = 0; //  (2)
            average = 0;
            num = 0;  //평균 넘는 걸 체크하는 변수
            for (int x = 0; x < n[i]; x++) { // (2) 점수 입력받기
                ress[x] = sc.nextInt();
                sum += ress[x]; //   50+50+70+80+100 = 350이 들어가야함
            }


            // 350 넘는 걸 체크해야됨
            // 넘는 갯수 / 3
            average = sum / n[i];  //(2)의 평균을 계산하기    350 / 5  = 70

            for (int x = 0; x < n[i]; x++) {  //(2)에서 평균을 넘는걸 체크하기
                if (average < ress[x])
                    num++;
            }

            result[i] = String.format("%.3f", 100 * num / (float) n[i]);
        }
        for (int i = 0; i < c; i++)
            System.out.println(result[i] + "%");
    }
}

