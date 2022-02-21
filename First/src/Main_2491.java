package com.algorithm.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491 {
	private static int N;
	private static int result = Integer.MIN_VALUE;
	private static int[] arr;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		arr = new int[N];

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int len = 1;
		int max = 1;
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] <= arr[i]) {
				len++;
			} else {
				len = 1;
			}
			max = Math.max(len, max);
		}
		len = 1; 
		for (int i = 1; i < N; i++) {
			if (arr[i - 1] >= arr[i]) {
				len++;
			} else {
				len = 1;
			}
			max = Math.max(len, max);
		}
		System.out.println(max);

	}
}
