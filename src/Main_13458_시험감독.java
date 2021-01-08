import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_13458_시험감독 {

	public static void main(String[] args) throws IOException {
		/*
		 * 총 N개의 시험장이 있고 , 각각의 시험장마다 응시자들이 있다. i번 시험장에 있는 응지사의 수는 Ai명이다 . 감독관은 총감독관과
		 * 부감독관으로 두 종류가 있다,. 총 감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명이고 부감독관은 한 시험장에서 ㄱ마시할 수
		 * 있는 응시자의 수 C명이다. 각각의 시험장에 총감독관은 오직 1명만 있어야하고, 부감독관은 여러 명 있어도 된다. 각 시험장마다 응시생들을
		 * 모두 감시해야 한다. 이때, 필요한 감독관 수의 최솟값을 구하는 프로그램을 작성하시오
		 * 
		 * 입력 ) 첫째 줄에 시험자으이 개수 N이 주어진다, 둘째 줄에는 각 시험장에 있는 응시자의 수 Aj가 주어진다. 셋째 줄에는 B와 C가
		 * 주어진다.
		 * 
		 * 출력 ) 각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수를 출력한다.
		 * 
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 시험장의 수
		long result = 0;

		int[] A = new int[N]; // i번 시험장에 있는 응시자의 수
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		} // end of for

		st = new StringTokenizer(br.readLine());
		int B = Integer.parseInt(st.nextToken()); // 총감독관은 한 시험장에서 감시할 수 있는 응시자의 수가 B명
		int C = Integer.parseInt(st.nextToken()); // 부감독관은 한 시험장에서 감시할 수 있는 응시자의 수

		// 총감독관은 한 시험장에 한 명만 있을 수 있다.
		// 부감독관은 여러 명 있어도 된다.
		for (int i = 0; i < N; i++) {
			// 1) 총감독관 빼고 -> 나머지를 중간 값으로 두기
			int middle = A[i] - B;  
			result++;
			if (middle > 0) {
				if (middle % C == 0)
					result += middle / C;
				else
					result += middle / C + 1;
			}
		} // end of for

		System.out.println(result); // 각 시험장마다 응시생을 모두 감독하기 위해 필요한 감독관의 최소 수를 출력한다.

	} // end of main

} // end of class
