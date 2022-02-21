import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15651 {
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    //같은 수를 여러 번 골라도 된다.
    // 1부터 n까지 자연수 중에서 m개를 고른 수열
    //내가 해야될것은 1 부터 4까지 가능하다는 것이고, 1 1 나오고 1 4 가 나와야함
    public static void dfs(int n, int m, int d) {//dfs
        if (d == m) {
            for (int a : arr)
                sb.append(a + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {  // 이걸로 그전까지 나오게 함

                visit[i] = true; //방문했다면
                arr[d] = i;
                dfs(n, m, d+1);

                visit[i]=  false;
        }
        return;
    }

    public static void main(String... args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        arr = new int[m];
        result = new int[m];
        visit = new boolean[n + 1];
        dfs(n, m, 0);
        System.out.print(sb);
    }
}
