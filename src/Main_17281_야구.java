import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17281_야구 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][9];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		} // end of for
		
		
		
	}// end of main

} // end of class

/*
 * 
 * 각 선수가 각 이닝에서 얻는결과를 1번 이닝부터 N번 이닝까지 순서대로 주어진다. 
 * 이닝에서 얻는 결과는 9개의 정수가 공백으로 구분되어져 있다.
 * 각 결과가 의미하는 정수는 다음과 같다.
 * 
 */
