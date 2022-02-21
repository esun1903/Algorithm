import java.util.*;

public class Main_2606 {

    static Scanner input = new Scanner(System.in); //입력받기
    static int n, m, i, a, b, count = 0;
    static int[] p;

    public static void main(String[] args) {
        n = input.nextInt(); // 정점의 개수
        m = input.nextInt(); // 간선의 개수
        p = new int[n+1]; // 간선 +1 만큼 p
        for(i = 0; i <= n; i++) { //정점만큼
            p[i] = i;
        }
        for(i = 0; i < m; i++) { //간선의 개수 만큼
            a = input.nextInt(); //입력받기
            b = input.nextInt(); //입력받기
            union(a, b);
        }
        for(i = 2; i <= n; i++) {
            if(find(1) == find(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static int find(int x) { //x를 넣어
        if(x == p[x]) { //x == p[x]
            return x; //return
        }else {
            int y = find(p[x]);
            p[x] = y;
            return y;
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        p[y] = x;
    }

}