package day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_10972_다음순열 {

	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {
		/*
		 * 입력) 첫째 줄에 N이 주어진다. 둘째 줄에 순열이 주어진다.
		 * 
		 * 출력) 첫째 줄에 입력으로 주어진 순열의 다음에 오는 순열을 출력한다 만약, 사전순으로 마지막에 오는 경우에는 -1을 출력한다 (
		 * 결과적으로 내림차순이 되었다면 )
		 */

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		// nextPermutation하기전 sort해주기
		

		nextPermutation(input);
	}
 
	private static void nextPermutation(int[] numbers) {

		// Step 1. 꼭대기를 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i;
		if (i == 0) {
			System.out.println(-1);
		    return; 
		}
		// Step 2. 꼭대기보다 큰 값 중 가장 작은값을 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;

		// Step 3. 그값과 swap하기
		swap(numbers, i-1, j);

		// Step 4. 꼭대기 인덱스부터 오름차순하기
		int k = N - 1;
		while (i < k)
			swap(numbers, i++, k--);

		for (int t = 0; t < numbers.length; t++)
			System.out.print(numbers[t] + " ");
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;

	}

}
