import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_9095_123더하기 {

	public static int map[];
	public static int n;

	public static void main(String[] args) throws Exception, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int i = 0; i < T; i++) {
			map = new int[11];
			n = Integer.parseInt(br.readLine());
			map[0] = 1;
			map[1] = 1;
			map[2] = 2;
			map[3] = 3;
			

			dp(n);
			System.out.println(map[n]);

		} // end of for

	}// end of main

	private static void dp(final int n) {
		for (int i = 3; i <= n; i++) {
			map[i] = map[i - 1] + map[i - 2] + map[i - 3];
		} // end of for
	} // end of DP

} // end of class

/*
 * 정수 4를 1,2,3 의 합으로 나타내는 방법은 총 7가지가 있다. 합을 나타낼 때는 수를 1개 이상 사용해야한다 1+1+1+1 1+1+2
 * 1+2+1 2+1+1 2+2 1+3 3+1 정수 n이 주어졌을 때, n을 1,2,3의 합으로 나타내는 방법의 수를 구하는 프로그램을
 * 작성하시오
 * 
 * 입력 : 첫째 줄에 테스트 케이스의 개수T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져있고 출력 : 각 테스트 케이스마다 n을
 * 1,2,3의 합으로 나타내는 방법의 수를 출력한다.
 */
