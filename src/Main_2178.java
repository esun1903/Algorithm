

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
1시 26분
 n * m 크기의 배열로 표현되는 미로가 있다.
 미로에서 1은 이동할 수 있는 칸을 나타내고 ,
 0은 이동할 수 없는 칸을 나타낸다.
 이러한 미로가 주어졌을 때, (1,1)에서 출발하여 (N,M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를
 구하는 프로그램을 작성하시오. 한 칸에서 다른 칸으로 이동할때, 서로 인접한
 서로 인접한 칸으로만 이동할 수 있다.
 위의 예에서는 15칸을 지나야 (n,m)의 위치로 이동할 수 있따.
 칸을 셀때에는 시작위치와 도착위치도 포함한다.

입력: 첫째 줄에 두 정수 N,M(2<=N,M<=100)이 주어진다. 다음 N개의 줄에는 M개의 정수로 미로가
주어진다. 각각의 수들은 붙어서 입력으로 주어진다.
출력: 첫째 줄에 지나야하는 최소의 칸 수를 출력한다. 항상 도착위치로 이동할 수 있는 경우만 입력으로 주어ㄴ진다.
*/
public class Main_2178 {

    //문제를 보고 DFS라고 생각. (깊이 우선 탐색)
    /* -> BFS였음. BFS의 특징은 각 정점을 최단경로로 방문한다는 것 .
       -> 최단거리가 나오는 것 : BFS로 풀기 ! */
    static int[][] miro;
    static boolean[][] visited;
    static int n, m;


    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};

    public static void main(String... args) throws IOException {
        //입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        miro = new int[n][m];
        visited = new boolean[n][m];


        //miro의 값을 받기


        //입력받을 때 붙어서 입력받는 것이 중요.
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); //한 줄씩 입력받기  한
            String line = st.nextToken(); //(1) . 이부분이 헷갈려서 NoSuchElementException 났었음
            for (int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0'; // (1)-2 . char형을 int형으로 변환하여 miro에 넣기
            }
        }

      /*  for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.println(miro[i][j]);
            }
        }
*/

        BFS(0, 0);
        System.out.println(miro[n - 1][m - 1]);
    }

    public static void BFS(int x, int y) {

        Queue<int[]> queue = new LinkedList<>(); //linkedList 객체 생성 (Queue에서 왜 linkedList를 하는 이유는 -> 자바의 "다형성"을 위해 , -> 설명들었는데 왜그런지 까먹음
        // java에서는 Queue를 편리하게 사용할 수 있도록 API를 제공합니다.
        // java의 Queue는 인터페이스 형태이므로 LinkedList 또는 ArrayList를 통해 사용할 수 있스빈다.
        /*
        * */
        queue.offer(new int[]{x, y}); // Java의 Queue 인터페이스에서는 보관할 때 offer 메서드를 사용
        while (!queue.isEmpty()) { //큐가 비어있지않으면
            int p[] = queue.poll(); //가장 먼저 보관한 값 꺼내고 반환
            visited[x][y] = true;
            for (int dir = 0; dir < 4; dir++) {
                int r = p[0] + dx[dir];
                int c = p[1] + dy[dir];

                //좌표가 -1이 되거나 N or M이 되어 map의 범위를 벗어나면 안되므로
                if (r >= 0 && c >= 0 && r < n && c < m) {
                    if (miro[r][c] != 0 && !visited[r][c]) {
                        queue.offer(new int[]{r, c});
                        visited[r][c] = true;
                        miro[r][c] = miro[p[0]][p[1]] + 1;
                    }
                }

            }
        }
    }
}


