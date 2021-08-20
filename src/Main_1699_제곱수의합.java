package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_1699_제곱수의합 {
    public static void main(String ... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int [] dp = new int [n+1];
        ArrayList<Integer> arrayList = new ArrayList<>();

        //arrayList에 추가하기
        for(int i =1; i<n; i++){
          if(i*i<n){
            arrayList.add(i);
         }
        }//end of for

        //dp[1] : 1의 제곱은 1 / dp[2] : 1 + 1  / dp[2] : 1 + 1 + 1
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;

        // arrayList.get(i)
//        for(int i = 1; i<)
        for(int i = 2; i<=arrayList.get(arrayList.size()-1); i++){
           dp[i]  = Math.min(arrayList.get(i), arrayList.get(i));
        }//end of for


        System.out.println(dp[n]);


    }//end of main
}//end of class

/**
 * 흐름
 * 1. n보다 작은 수이면서 제곱값이 n보다 작은 수이면 허용! (arr)로
 * 2. 1번의 값들을 개수에 상관없이 합이 n이 나오면 됨
 * 3. 2번의 경우들을 조합했읋 때 그 항의 최소개수를 구하면 된다.
 *
 * 2,3 번을 할 때 자세히 살펴보니 dp문제 유형임을 알게 됐다.
 * -> 흑 하나도 기억 안나서 ㅎ 다시 봤다.
 *
 * =============================================
 *
 * 문제
 * 어떤 자연수 N은 그보다 작거나 같은 제곱수들의 합으로 나타낼 수 있다.
 * 예를 들어 11=32+12+12(3개 항)이다. 이런 표현방법은 여러 가지가 될 수 있는데,
 * 11의 경우 11=22+22+12+12+12(5개 항)도 가능하다.
 * 이 경우, 수학자 숌크라테스는 “11은 3개 항의 제곱수 합으로 표현할 수 있다.”라고 말한다.
 * 또한 11은 그보다 적은 항의 제곱수 합으로 표현할 수 없으므로,
 * 11을 그 합으로써 표현할 수 있는 제곱수 항의 최소 개수는 3이다.
 *
 * 주어진 자연수 N을 이렇게 제곱수들의 합으로 표현할 때에
 * 그 항의 최소개수를 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 자연수 N이 주어진다. (1 ≤ N ≤ 100,000)
 *
 * 출력
 * 주어진 자연수를 제곱수의 합으로 나타낼 때에 그 제곱수 항의 최소 개수를 출력한다.
 */