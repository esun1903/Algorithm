import java.util.Scanner;
import java.util.*;

public class Main_1546 {
    public static void main(String... args) {
        //세준이는 자기 점수 중 최댓값을 골랐다.  이 값을 M이라고 한다.
        // 모든 점수를 점수/M*100으로 고쳤다. ex) 최고점이 70이고, 수학점수가 50점이었으면 수학점수는 50/70*100이 되어
        // 71.43 이 된다.

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();  //시험 본 과목의 개수 3

        double max = 0;

        double score[] = new double[n];  //현재점수
        double news[] = new double [n]; //새로운 점수
        double result = 0;

        for (int i = 0; i < n; i++) { //입력받기 , 최댓값 찾기
            score[i] = sc.nextInt();
            if (max < score[i])
              max = score[i];
        }
        for( int t = 0; t<n; t++){
           news[t] = (score[t]/max)*100;

           result += news[t];
        }

        System.out.println(result/n);


    }
}
