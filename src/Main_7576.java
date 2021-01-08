import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {

    static final int[] dx = {1, -1, 0, 0}; //오른쪽, 왼쪽, 위, 아래
    static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()); //StringTokenizer st  .. 입력 한 줄로 받기
        int m = Integer.parseInt(st.nextToken());  //입력받기
        int n = Integer.parseInt(st.nextToken());
        int[][] arr = new int[n][m]; //n,m 사이즈만큼 배열 만들기
        int[][] sum = new int[n][m];
        int result = 0;
        Queue<Pair> queue = new LinkedList<>(); //링크드리스트로 만들기
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());  //줄수
            for(int j = 0; j < m; j++) { //m만큼
                arr[i][j] = Integer.parseInt(st.nextToken());
                sum[i][j] = -1; // 왜 sum에는 -1 ?
                if(arr[i][j] == 1) { // arr[i][j] ==1 이라는 것은 토마토가 익었을 경우
                    queue.offer(new Pair(i, j)); //queue에 위치값 넣기
                    sum[i][j] = 0; //sum[i][j] = 0  넣기
                }
            }
        }
        while(!queue.isEmpty()) { //큐가 비어있지 않을때까지
            Pair p = queue.poll(); // 가장 먼저 보관된 값 꺼내기
            for(int i = 0; i < 4; i++) {  // 0부터 3까지 총 4번
                int nx = p.x + dx[i]; // p.x + dx[i];  현재값이랑 dx 더하기
                int ny = p.y + dy[i]; // 현재 p.y 값과 + dy[i] 더하기
                if(0 <= nx && nx < n && 0 <= ny && ny < m) { // nx >= 0 하고 nx < n작고 0<= ny  하고 ny < m 하면
                    if(sum[nx][ny] == -1 && arr[nx][ny] == 0) {  //sum[nx][ny] == -1 이 아니고 0 인 경우 그리고 arr[nx][ny]가 0 이 아닌경우 둘 다  토마토가 익은  경우

                        sum[nx][ny] = sum[p.x][p.y] + 1; // 0 + 1 = sum[nx][ny]는 1이 된다. -> 익은걸로 됨
                        queue.offer(new Pair(nx, ny)); // queue에 값 넣기
                    }
                }
            }
        }
        for(int i = 0; i < n; i++) { //n ~ m까지
            for(int j = 0; j < m; j++) {
                if(result < sum[i][j]) result = sum[i][j]; //  0 < sum[i][j] 이면 (즉, 상수이면 ) result = sum[i][j];
            }
        }
        for(int i = 0; i < n; i++) {  // - 1
            for(int j = 0; j < m; j++) {
                if(arr[i][j] == 0 && sum[i][j] == -1) result = -1; // 다 돌았을 때에도 안 익는 것이 있다면 result = -1 ;
            }
        }
        bw.write(String.valueOf(result));
        bw.close();
        br.close();
    }

    static class Pair {
        int x;
        int y;
        public Pair(final int x, final int y) {
            this.x = x;
            this.y = y;
        }
    }
}