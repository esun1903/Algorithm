package day0830;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_nextPermutation {
	static int N;
	static int[] input;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		input = new int[N];
		st = new StringTokenizer(br.readLine());

		// 입력받기
		for (int i = 0; i < N; i++) {
			input[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(input);
		do {
			System.out.println(Arrays.toString(input));
		} while (nextPermutation(input));

	}

	private static boolean nextPermutation(int[] numbers) {

		// step 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i]) --i;
		if (i == 0)
			return false;

		// step 2. 꼭대기보다 큰 값 중 가장 작은 값을 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j]) --j;

		// step 3. 그 작은 값과 꼭대기값과 swap하기
		swap(numbers, i - 1, j);

		// step 4.꼭대기 인덱스 다음부터 swap하기
		int k = N - 1;
		while (i<k) {  //내림차순이 이미 되어있기 때문에 오름차순으로 다 변경해줘야함 -> 조건식이 필요없음 
			swap(numbers, i++, k--);
            
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;
	}

}
