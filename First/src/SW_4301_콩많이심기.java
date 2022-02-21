package com.ssay.algo;



import java.util.*;


public class SW_4301_콩많이심기 {

    static int N, M, count;
    static int[][] map;

    static int[] dy = { -2, 2,  0, 0 };
    static int[] dx = {  0, 0, -2, 2 };
    
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int t = 1; t <= T; t++) {

            N = sc.nextInt();  // 가로 - x
            M = sc.nextInt();  // 세로 - y

            map = new int[M][N];
            count = 0;
            
            for (int i = 0; i < M; i++) {
                for (int j = 0; j < N; j++) {
                	
                	boolean isOK = true;
                	// 4방 탐색해서 그 자리가 유효하면서 1 로 이미 콩이 있으면 i,j 는 콩을 놓지 못하므로 break 하고 다음 자리로
                	for (int k = 0; k < 4; k++) {
                		
                		int ny = i + dy[k];
                        int nx = j + dx[k];

                        if (ny >= 0 && nx >= 0 && ny < M && nx < N && map[ny][nx] == 1 ) {
                        	isOK = false;
                        	break;
                        }
                    }
                	
                    if(isOK) {
                    	map[i][j] = 1;	// 콩 심는다.
                        count++; // 콩 개수 증가
                    }
                }
                
            }
            System.out.println("#" + t + " " + count);
        }
        sc.close();
    }
}

/*
https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWLv-yZah48DFAVV&
*/

/*
1
3 2

#1 4
*/