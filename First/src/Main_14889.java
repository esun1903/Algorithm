import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_14889 {

    public static int n;
    public static int m;
    public static int min = Integer.MAX_VALUE;
    public static int a[][];
    public static boolean visit[];
    public static StringBuilder sb = new StringBuilder();

    public static void func(final int x, final int count) {

        //팀을 나누기 ! ( 2팀으로 나누기 )
        if (count == n / 2) {
            List<Integer> ateam = new ArrayList<>(); //ArrayList는 검색, 조회 등이 빠름
            List<Integer> bteam = new ArrayList<>();  //LiskedList 는 삽입이 빠름
            int asum = 0;
            int bsum = 0;
            for (int i = 0; i < n; i++) {
                if (visit[i]) {  //a팀
                    ateam.add(i);  //list에 넣기
                    //list에서 꺼내서 asum
                } else {
                    //b팀
                    bteam.add(i);
                }
            }
            for (int i : ateam) {
                for (int j : ateam) {
                    if (i == j) continue;
                    asum += a[i][j];
                }
            }
            for (int i : bteam) {
                for (int j : bteam) {
                    if (i == j) continue;
                    bsum += a[i][j];
                }
            }
            min = Math.min(min, Math.abs(asum - bsum)); // asum 이랑 bsum이랑 비교 하기 (절대값)
            return;
        }
        for (int i = x; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;  //true로 하기
                func(i + 1, count + 1); //i +!
                visit[i] = false;
            } else return;
        }
        //만약 6이라면 1,2,3번이 스타트 팀, 4,5,6이 링크팀이 됨 -\>n 에 따라서 몇개의팀을 : )
        // ->팀을 만들 계산이 필요 .
        //1,2번이 스타트 팀, 3,4, 번이 링크 팀에 속한 경우 두 팀의 능력치를 정하기
    }

    public static void main(String ... args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n][n];
        m = n / 2;
        visit = new boolean[n]; // visit를 체크하기위한 boolean형  2차원 변수
        StringTokenizer st; //st

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine()); //
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        func(0, 0);
        System.out.println(min);
    }
}
