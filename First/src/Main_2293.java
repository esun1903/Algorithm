package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_2293 {

	static int n, k;

	// n개의 숫자 조합을 이용해 합 k를 맞추는 경우의 수를 찾는 문제 ( 순서 상관없고 , n개 다 이용 안 해도 됨, 동전 중복 사용 가능)

	public static void main(String[] args) throws IOException {
		 Scanner in = new Scanner(System.in);

	        int n = in.nextInt();
	        int s = in.nextInt();

	        int[] coin = new int[101];//인덱스 번호 1부터 직관적으로 시작하려고 +1씩 해서 배열 선언
	        int[] dp = new int[10001];

	        for(int i = 1 ; i <= n ; i++) {
	            coin[i] = in.nextInt();
	        }

	        //i는 x번째->coin[x번째 동전 종류]의 경우를 의미
	        //j는 i의 동전 종류로 1~s원를 채우는 경우의 수를 의미
	        dp[0] = 1; //최초 시작점
	        for(int i = 1 ; i <= n ; i++) {
	            for(int j = coin[i]; j <= s ; j++) {
	                dp[j] += dp[j - coin[i]];
	                /*
	                 * 다음으로, 3원짜리 동전이 저에게 있다고 가정합니다. 
	3원짜리 동전으로 3원은 1가지지만 6원은 2+2+2와 3+3 2가지의 경우가 존재합니다. 
	여기서 동적 프로그래밍의 개념이 나옵니다. 
	이전의 경우를 저장해놓고, 현재의 경우와 이전의 경우를 합해 나가면서 경우의 수를 계산합니다.
	즉, 6원을 만드는 경우의 수를 계산할 때, 2원짜리로 6원을 만들 수 있는 경우의 수와 3원짜리로 6원을 만들 수 있는 경우의 수를 합해야 한다는 의미입니다. 
	                 */
	            }
	        }

	        System.out.println(dp[s]); 
	}
        
}
