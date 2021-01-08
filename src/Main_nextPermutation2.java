package day0830;

import java.util.Arrays;
import java.util.Scanner;
// nCr
public class Main_nextPermutation2 {

	static int N, R;
	static int[] input, p;
	static int totalCount;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		R = sc.nextInt();
		input = new int[N];
		p = new int[N]; // 생성이 곧 0으로 초기화

		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}

		int cnt = 0;
		while (++cnt <= R) {
			p[N - cnt] = 1; // 뒷쪽부터 1을 채우기
		}

		do {
			for (int i = 0; i < N; i++) {
				if (p[i] == 1)
					System.out.print(input[i] + " ");
			}
			System.out.println();
		} while (nextPermutation(p));
	}

	// 여기 못적음
	private static boolean nextPermutation(int[] numbers) {

		// step 1. 꼭대기 찾기
		int i = N - 1;
		while (i > 0 && numbers[i - 1] >= numbers[i])
			--i; // 1 2 3 4 5
		if (i == 0)
			return false; // 마지막 순열의 상태이면 다음 순열 없음

		// step 2. i-1위치와 교환할 다음단계 큰 수 뒷쪽에서 찾기
		int j = N - 1;
		while (numbers[i - 1] >= numbers[j])
			--j; // 4 5

		// step 3.i-1위치값과 j위치값 교환
		swap(numbers, i - 1, j); // 1 2 3 5 4

		// step 4. i위치부터 맨 뒤까지 오름차순 정렬
		int k = N - 1;
		while (i < k) {
			swap(numbers, i++, k--); //
		}
		return true;
	}

	private static void swap(int[] numbers, int i, int j) {
		// TODO Auto-generated method stub
		int temp = numbers[i];
		numbers[i] = numbers[j];
		numbers[j] = temp;

	}

}
