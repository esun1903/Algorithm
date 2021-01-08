import java.awt.Point;
import java.util.*;

public class Main_2667 {
    /* https://ballpython.tistory.com/6
    * Main함수에서는
    * 1) 단지를 입력 받기
    * 2) 단지 배열 값이 1이고 , 이전에 방문한 적 없는 값은 bfs함수를 호출합니다.
    * 3) BFS를 호출할 때마다 count를 해서 그 값을 총 단지수로 출력해줍니다.
    * 4) ArrayList와 Collection을 이용해서 값을 오름차순으로 정렬해 각 단지내 집의 수를 출력해줍니다.
    *
    * BFS함수에서는
    * 1)메인에서 전해준 값을 큐에 넣고, VISIT체크를 합니다.
    * 2)그 값의 주변(상하좌우)을 살피며 값이 1이고 방문한 적 없는 값은 Queue에 넣습니다.
    * 그리고 local_cnt를 증가하며 한 단지 내의 집의 개수를 카운트합ㄴ디ㅏ.
    * 3)local_cnt를 ArrayList에 추가합니다. */
    static Queue<Point> q = new LinkedList<>(); //LinkedList<>()
    static int[][]map; //map
    static int[][]visited; //방문했다라는 boolean
    static int []dx = {-1,1,0,0}; //dx , dy의 의미 : -1,1,0,0으로 위아래, 이런거 확인하기,,!
    static int []dy = {0,0,-1,1};
    static ArrayList<Integer> al = new ArrayList<>(); //ArrayList ()
    static int N;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); //입력받기
        int call_num = 0;
        N = scan.nextInt();   //입력받기

         //map , visited 를 [n]만큼 배열로 만들기
        map = new int[N][N];
        visited = new int[N][N];
        String temp;

        for(int i=0;i<N;i++) {
            temp = scan.next(); //한줄로 받아서
            for(int j=0;j<N;j++) //넣기
                map[i][j] = temp.charAt(j)-'0';
        }

        for(int i=0;i<N;i++)
            for(int j=0;j<N;j++) //map 1이고 방문하지 않았을때
                if(map[i][j] == 1 && visited[i][j] == 0) {
                    BFS(i,j); //BFS로 해당위치
                    call_num++; //call_num ++하기
                }

        System.out.println(call_num);

        Collections.sort(al);

        for (Integer integer : al) System.out.println(integer);
    }

    static void BFS(int i, int j)
    {
        int nx,ny;
        int local_cnt = 1;
        q.offer(new Point(i,j));
        visited[i][j] = 1;

        while(!q.isEmpty())
        {
            Point now;
            now = q.poll();

            for(int h=0;h<4;h++) {
                nx = now.x+dx[h];
                ny = now.y+dy[h];

                if(nx>=0&&ny>=0&&nx<N&&ny<N) {
                    if(map[nx][ny] == 1 && visited[nx][ny]==0) {
                        q.offer(new Point(nx,ny));
                        visited[nx][ny] = 1;
                        local_cnt++;
                    }
                }
            }
        }
        al.add(local_cnt);
    }
}
