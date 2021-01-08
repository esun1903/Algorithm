package com.algorithm.a;

import java.io.*;
import java.util.*;

public class Main_14499 {

    private final static int[] DX = {0, 0, 0, -1, 1};
    private final static int[] DY = {0, 1, -1, 0, 0};

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static StringBuilder stringBuilder = new StringBuilder();
    private static StringTokenizer st;

    private static int n, m, x, y;

    private static int[][] arr;
    private static int[] dice = new int[7];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        Integer.parseInt(st.nextToken());

        arr = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int i = Integer.parseInt(st.nextToken());
            int nx = DX[i] + x;
            int ny = DY[i] + y;
            if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                if(i == 1) {
                    int temp = dice[4];
                    dice[4] = dice[6];
                    dice[6] = dice[3];
                    dice[3] = dice[1];
                    dice[1] = temp;
                }else if(i == 2) {
                    int temp = dice[4];
                    dice[4] = dice[1];
                    dice[1] = dice[3];
                    dice[3] = dice[6];
                    dice[6] = temp;
                }else if(i == 3) {
                    int temp = dice[2];
                    dice[2] = dice[1];
                    dice[1] = dice[5];
                    dice[5] = dice[6];
                    dice[6] = temp;
                }else {
                    int temp = dice[2];
                    dice[2] = dice[6];
                    dice[6] = dice[5];
                    dice[5] = dice[1];
                    dice[1] = temp;
                }
                if(arr[nx][ny] == 0) arr[nx][ny] = dice[6];
                else {
                    dice[6] = arr[nx][ny];
                    arr[nx][ny] = 0;
                }
                x = nx;
                y = ny;
                stringBuilder.append(dice[1]).append("\n");
            }
        }

        bw.write(stringBuilder.toString());
        bw.close();
        br.close();
    }
}