import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main_1012 {
 /* 유기농 배추
 * 차세대 영농인 한나는 강원도 고랭지에서 유기농뱇를 재배하기ㅎ로 하였다.
 * 농약을 쓰지 않고 배추를 재배하려면 배추를 해충으로부터 보호나는 것이 중요하기 때문에,*/
    final static int[] dx = {1, -1, 0, 0};
    final static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); //BufferedRedader
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder stringBuilder = new StringBuilder();
        StringTokenizer st;
        int b = Integer.parseInt(br.readLine());
        for(int a = 0; a < b; a++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int count = 0;
            Queue<Pair> queue = new LinkedList<>();
            int[][] arr = new int[n][m];
            boolean[][] visit = new boolean[n][m];
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(arr[i][j] == 1 && !visit[i][j]) {
                        count++;
                        queue.add(new Pair(i, j));
                        visit[i][j] = true;
                        while (!queue.isEmpty()) {
                            Pair p = queue.poll();
                            for(int c = 0; c < 4; c++) {
                                int nx = dx[c] + p.x;
                                int ny = dy[c] + p.y;
                                if(0 <= nx && nx < n && 0 <= ny && ny < m) {
                                    if(!visit[nx][ny] && arr[nx][ny] == 1) {
                                        visit[nx][ny] = true;
                                        queue.offer(new Pair(nx, ny));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            stringBuilder.append(count + "\n");
        }
        bw.write(stringBuilder.toString());
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