package com.algorithm.a;

import java.io.*;
import java.util.*;



public class Main_15961{

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String... args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int coupon = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        for (int i = 0; i < n; ++i) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int[] check = new int[d + 1];

        check[coupon]++;
        int count = 1;

        for (int i = 0; i < k; i++) {
            if (check[arr[i]] == 0) {
                count++;
            }
            check[arr[i]]++;
        }

        int max = count;

        for (int i = k; i < n + k; i++) {
            int start = i - k;
            int end = i % n;

            --check[arr[start]];
            if (check[arr[start]] == 0) {
                count--;
            }

            if (check[arr[end]] == 0) {
                count++;
            }
            check[arr[end]]++;

            if (count > max) {
                max = count;
            }
        }

        bw.write(max + "");
        bw.close();
        br.close();
    }


}