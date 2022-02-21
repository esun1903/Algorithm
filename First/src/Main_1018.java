
import java.util.*;

public class Main_1018 {
    public static void main(String... args) {
        //보지마세욜 ~
        //8 8 은 이해가 되지만 다른 결과가 이해가 안됨 (문제 이해안되고 넘어가는거라 다시봐라,,,,나란애야,,)
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int Min = M * N; //체스판의 크기
        char[][] Chess = new char[N][M]; //크기만큼 배열 완성

        //처음 시작하는 것에 따라 달라지기 때문에 배열변수 2개로 두고 하기
        char[][] Test1 = {{'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'},
                {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}, {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}};
        char[][] Test2 = {{'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'},
                {'B', 'W', 'B', 'W', 'B', 'W', 'B', 'W'}, {'W', 'B', 'W', 'B', 'W', 'B', 'W', 'B'}};

        for (int i = 0; i < N; i++) { // 입력받은 크기만큼 지나가며 chess[]배열에 넣기
            String line = sc.next();
            for (int j = 0; j < M; j++) {
                Chess[i][j] = line.charAt(j);  //charAt(j) 하는게 좋은 것같다.
            }
        }

        for (int i = 0; i < N - 7; i++) {  //0부터 입력받은 가로의 수 -7까지
            for (int j = 0; j < M - 7; j++) {//0부터 입력받은 세로의 수 -7까지
                int ChangeCount1 = 0;
                int ChangeCount2 = 0;
                int Exchange = 0;
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (Chess[i + x][j + y] != Test1[x][y]) {   //만약 다르면
                            ChangeCount1++;  //바꾼 count++하기
                        }
                    }
                }
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        if (Chess[i + x][j + y] != Test2[x][y]) {
                            ChangeCount2++;
                        }
                    }
                }
                Exchange = (ChangeCount1 > ChangeCount2) ? ChangeCount2 : ChangeCount1;  //만약 변한 수가 둘중 적다면
                if (Min > Exchange) Min = Exchange; //Min  ? d아주 이해가 안되유 ~~~~~~!!!!!!!
            }
        }
        System.out.print(Min);

    }
}
        /*Scanner sc = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //값 받기
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int go = 0; //잘가고있는 확인하는 함수
        int bw = 0; //B이면 0 W이면 1
        String[][] chess = new String[m][n]; //세로, 가로

        for (int i = 0; i < m; i++) {  //세로
            String sl = sc.nextLine(); //줄
            StringTokenizer sd = new StringTokenizer(sl, ""); //sl을 ""로 받기
            for (int j = 0; j < n; j++) {
                chess[j][i] = sd.nextToken(); //token으로 받기
            }
        } //받아서 하나하나 계산하면서 b라면 w라면 하면서,,,,하기

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((chess[j][i] == "B")) {
                    bw = 1; //다음은 w이여야하니 1로 변경
                } else {
                    bw = 0;

                }
            }
        }
        System.out.println(chess[0][1]);
*/


