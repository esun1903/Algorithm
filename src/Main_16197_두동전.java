package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16197_두동전 {


    public static int N;
    public static int M;
    public static int []dr = {-1,1,0,0};
    public static int []dc = {0,0,-1,1};

    public static void main(String ... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

         N = Integer.parseInt(st.nextToken());
         M = Integer.parseInt(st.nextToken());
        int count = 0;
        int [][]coin = new int [2][2];
        char [][] arr = new char [N][M];
        boolean visited[][] = new boolean[N][M];
        int answer = Integer.MAX_VALUE;

        //1)
        for(int i= 0; i<N; i++){
            String str = br.readLine();
            for(int j = 0; j<M; j++){
                arr[i][j] = str.charAt(j);
                if(arr[i][j]=='o'&&count == 0){
                    coin[0][0] = i; coin[0][1] = j; count++;
                }else if(arr[i][j]=='o'&&count == 1){
                    coin[1][0] = i; coin[1][1] = j;
                }
            }
        }//end of 입력


        //2)
        for(int i= 0; i<2; i++){
           answer = Math.min(dfs(coin[i][0],coin[i][1], visited, arr, 0),answer);
        }

        System.out.println(answer);


    }//end of main

    private static int dfs(int coin_r, int coin_c, boolean[][] visited, char[][] arr, int count) {

        if(count == 10){
            return -1;
        }
        if(visited[coin_r][coin_c]){
            return Integer.MAX_VALUE;  //일단 이렇게 해놓음
        }

        for(int i =0; i<4; i++){
            int nr = coin_r+ dr[i];
            int nc = coin_c+ dc[i];

            if(arr[nr][nc]=='.'){
                continue;
            }
            else if((0<=nr && 0<=nc) || (nr<N && nc<M)){
                return count;
            }
            else if(visited[nr][nc] == false){ // 이동하려고 했을 떄 조건이 다 된다면
                dfs(nr,nc,visited,arr,count+1);
            }
        }//end of for

       return Integer.MAX_VALUE;
    }//end of dfs


}//end of class


/**
 *
 * 흐름
 *
 * dfs로 풀어야 하지 않을까 생각함
 *
 * 1. 입력받으면서 두 동전의 위치를 저장한다.
 * 2. 그 다음 하나씩 동전에 위치에서 dfs를 돌린다.
 * 2-1. dfs를 돌릴 때에 방문체크 , 벽인 경우, 10번 이상를 체크한다.
 * 2-2. 만약 칸이 없다면 return하기
 * 3.  2번에서 최소 몇번 몇 번 눌러야 하는지를 각각의 동전마다 구한다.
 *
 * 문제
 *
 * N*M 크기의 모브와 4개의 버튼으로 이루어진 게임이 있다. 보드는 1*1크기의 정사각형 칸으로 나누어져 있고,
 * 각각의 칸은 비어있거나, 벽이다. 두 개의 빈 칸에는 도전이 하나씩 놓여져 있고, 두 동전의 위치는 다르다.
 *
 * 버튼 "왼쪽" "오른쪽" "위" 아래"와 같이 4가지가 있다. 버튼을 누르면 두 동전이 버튼에 쓰여 있는 방향으로 동시에
 * 이동하게 된다.
 *
 *    - 동전이 이동하려는 칸이 벽이면, 동전은 이동하지 않는다.
 *    - 동전이 이동하려는 방향에 칸이 없으면 동전은 바깥으로 떨어진다.
 *    - 그 외의 경우에는 이동하려는 방향으로 한 칸 이동한다. 이동하려는 칸에 동전이 있는 경우에도 한 칸 이동한다.
 *
 * 두 동전 중 하나만 보드에서 떨어뜨리기 위해 버튼을 최소 몇 번 눌러야하는지 구하는 프로그램을 작성하시오.
 *
 *
 * 입력
 *
 * 첫째 줄에 보드의 세로 크기 N과 가로 크기 M이 주어진다. (1 ≤ N, M ≤ 20)
 *
 * 둘째 줄부터 N개의 줄에는 보드의 상태가 주어진다.
 *
 * o: 동전
 * .: 빈 칸
 * #: 벽
 * 동전의 개수는 항상 2개이다.
 *
 * 출력
 *
 * 첫째 줄에 두 동전 중 하나만 보드에서 떨어뜨리기 위해 눌러야 하는 버튼의 최소 횟수를 출력한다.
 * 만약, 두 동전을 떨어뜨릴 수 없거나, 버튼을 10번보다 많이 눌러야 한다면, -1을 출력합니다.
 */