import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_4948 {

    static StringTokenizer st;
    public static boolean[] primeNum;
    public static void main(String... args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int n[] = new int[123456]; // 배열만들기

        for (int i = 0; i < 123456; i++) {  // 배열 :)

            if (n[i - 1] == 0) { //0이면 break;
                break;
            }
            n[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; n[i] != 0; i++) { //0일때까지 반복해서 소수찾아내기
         // 곱하기 10해서 찾아내기

        }

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

