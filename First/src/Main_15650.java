
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_15650 {
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();

    public static void dfs(int n, int m, int d) {  //dfs
        if (d == m) {
            for (int a : arr)
                sb.append(a + " ");
            sb.append("\n");
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true; //다녀왔다는 것을 true하기
                arr[d] = i;
                if (d == 0)
                    dfs(n, m, d + 1);
                if (d > 0 && arr[d] > arr[d - 1])
                    dfs(n, m, d + 1);

                visit[i] = false; //다녀왔다는 것은 false;
            }

        }
        return;

    }

    public static void main(String... args) throws IOException {
        StringTokenizer st = new StringTokenizer(new BufferedReader(new InputStreamReader(System.in)).readLine());
        int n = Integer.parseInt(st.nextToken()); //4
        int m = Integer.parseInt(st.nextToken()); //2
        arr = new int[m];
        result = new int[m];
        visit = new boolean[n + 1];
        dfs(n, m, 0);
        System.out.print(sb);
    }
}
