import java.awt.*;
import java.util.*;

public class Main_2667_1 {

    static Queue<Point> q = new LinkedList<>();
    static int[][] map;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static ArrayList<Integer> al = new ArrayList<>();
    static int N;

    public static void main(String... args) {

        Scanner scan = new Scanner(System.in);
        int call_num = 0;
        N = scan.nextInt(); //입력받기

        map = new int[N][N];
        visited = new int[N][N];
        String temp;

        for (int i = 0; i < N; i++) {
            temp = scan.next(); //한 줄로 받아서
            for (int j = 0; j < N; j++)
                map[i][j] = temp.charAt(j) - '0';
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1 && visited[i][j] == 0) { //map =1 이고 방문하지 않았다면bfs를 돌기

                    BFS(i, j);
                    call_num++; //call_num++
                }
            }
        }
        System.out.println(call_num); //총 단지 수 : BFS 호출한 수
        Collections.sort(al); //arrayList 오름차순

        for (Integer integer : al) System.out.println(integer);

    }

    static void BFS(int i, int j) {

        int nx, ny;
        int local_cnt = 1;
        q.offer(new Point(i, j));
        visited[i][j] = 1;
        while (!q.isEmpty()) {
            Point now;
            now = q.poll();

            for (int h = 0; h < 4; h++) {
                nx = now.x + dx[h];
                ny = now.y + dy[h];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) { //
                    if (map[nx][ny] == 1 && visited[nx][ny] == 0) {
                        q.offer(new Point(nx, ny));
                        visited[nx][ny] = 1;
                        local_cnt++; //단지 수
                    }
                }
            }
        }
        al.add(local_cnt);
    }
}
