

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_17144_미세먼지안녕 {
    public static int map[][];
    public static int map2[][];
    public static int ack_r = -1; // 공기청정기의 위치
    public static int ack_c = -1;
    public static int ack2_r;
    public static int ack2_c;
    public static boolean zero[][];
    public static int R;
    public static int C;
    public static int T;

    public static int[] dr = {-1, 1, 0, 0};
    public static int[] dc = {0, 0, -1, 1};

    public static void main(String... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());


        map = new int[R][C];
        map2 = new int[R][C];
        zero = new boolean[R][C];
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0) {
                    zero[i][j] = true;
                }
                if (map[i][j] == -1 && ack_r == -1) { // 공기청정기의 위치
                    ack_r = i;
                    ack_c = j;
                } else if (map[i][j] == -1 && ack_r != -1) {
                    ack2_r = i;
                    ack2_c = j;
                }
            }
        }// end of for


        for (int t = 0; t < T; t++) {
            map2 = map;
            expand();

        }
    }

    private static void expand() {
        // 1) 미세먼지가 확산된다. 확산은 미세먼지가 있는 모든 칸에서 동시에 일어난다.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                int count = 0;
                if (zero[i][j] == true) {
                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if (nr < R && nc < C && nr >= 0 && nc >= 0) {// 만약, 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
                            if (map[nr][nc] != -1)
                                count++;
                        }

                    }

                    //확산되는 양은 Ar,c/5이고 소수점은 버린다.
                    int Diffusion = map[i][j] / 5;
                    //(r,c)에 남는 미세먼지의 양은 Ar,c - (Ar,c/5)*(확산된 방향의 개수)
                    map2[i][j] = map2[i][j] - (Diffusion * count);

                    for (int d = 0; d < 4; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];

                        // 만약, 인접한 방향에 공기청정기가 있거나, 칸이 없으면 그 방향으로는 확산이 일어나지 않는다.
                        if (nr < R && nc < C && nr >= 0 && nc >= 0) {
                            if (map[nr][nc] != -1) {
                                map2[nr][nc] = map2[nr][nc] + Diffusion;
                            }
                        }
                    }// end of for

                }
                System.out.println("===============");
                for (int i1 = 0; i1 < R; i1++) {
                    System.out.println();
                    for (int j1 = 0; j1 < C; j1++) {
                        System.out.print(map2[i1][j1] + " ");
                    }
                }
            }
        } //end of 확산


    }
}
