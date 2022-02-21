import java.io.*;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1929 {
    static StringTokenizer st;
    public static boolean[] primeNum;

    public static void main(String... args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        st = new StringTokenizer(br.readLine());

        //token 으로 받기
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        //에라토스테네스의 체 이걸 써야 해결되는 문제임, 점점 체로 걸러지듯이 지우는 ( 2의 배수 다 지우고 ! 이렇게 _!!!!!!!!!!!!1) 신기쓰


        primeNum = new boolean[n+1];
        getPrimeNum(); // 에라토스테네스의 체로 소수를 구한다.

        //StringBuiler로 생성 -> StringBuilder란 string 2개를 만들때 새로운 String객체를 생성하지 않고 기존에 있던 객체를 붙이는 것을 말함

        StringBuilder sb = new StringBuilder();

        for(int i = m; i <= n; i++) {
            if(!primeNum[i]) {
                sb.append(i + "\n");
            }
        }

        System.out.println(sb.toString());

        br.close();
        }

    public static void getPrimeNum(){
        primeNum[1]  = true;
        for( int i = 2; i<primeNum.length; i++){
            for(int  j = 2; i*j < primeNum.length; j++){
                primeNum[i*j] = true;
            }
        }
    }

}
