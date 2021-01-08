package com.algorithm.a;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_17069 {

    private final static int[] DX = {0, 1, 1};
    private final static int[] DY = {1, 0, 1};

    private static Scanner sc = new Scanner(System.in);
    private static int n;
    private static int[][] arr;
    private static long[][][] dp;

    public static void main(String... args) {
        StringTokenizer st;
        n = Integer.parseInt(sc.nextLine());
        arr = new int[n][n];
        dp = new long[n][n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(sc.nextLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j][0] = -1;
                dp[i][j][1] = -1;
                dp[i][j][2] = -1;
            }
        }
        System.out.println(dfs(0, 1, 0));
    }

    //0 오른쪽
    //1 아래
    //2 대각선

    /**
     * 1. 이전 방향에 따라 다음 방향 경우의 수 결정
     * 2. 오른쪽, 아래 검사 후 대각선 검사
     */
    private static long dfs(final int x, final int y, final int dir) {
        if (dp[x][y][dir] != -1) return dp[x][y][dir];
        if (x == n - 1 && y == n - 1) return 1;
        dp[x][y][dir] = 0;

        int count = 0;
        for (int i = 0; i < 3; i++) {
            int nx = DX[i] + x;
            int ny = DY[i] + y;
            if (0 <= nx && nx < n && 0 <= ny && ny < n) {
                if (arr[nx][ny] == 0) {
                    count++;
                    if(i == 0) {
                        if(dir == 0 || dir == 2) {
                            dp[x][y][dir] += dfs(nx, ny, i);
                        }
                    }else if(i == 1) {
                        if(dir == 1 || dir == 2) {
                            dp[x][y][dir] += dfs(nx, ny, i);
                        }
                    }
                }
            }
        }

        if (count == 3) {
            dp[x][y][dir] += dfs(x + 1, y + 1, 2);
        }

        return dp[x][y][dir];
    }

    /**
     * 파이프 옮기기
     * n * n,
     * r = 행 번호
     * c = 열 번호
     * 1부터 시작
     * 각 칸은 빈 칸이거나 벽
     * 파이프는 2칸 차지 ->
     * 회전 가능
     * -> 대각선 아래방향
     * 파이프는 항상 빈 칸만 차지해야 한다
     * 대각선일 경우 3칸 차지
     *
     * 초기 파이프는 1,1 1,2 차지
     *
     * 0은 빈칸, 1은 벽
     */
}