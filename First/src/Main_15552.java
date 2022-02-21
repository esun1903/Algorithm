import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main_15552 {
    public static void main(String ... args) throws java.io.IOException {
      //main() method 에서는 IOException이 발생할 수도 있는 작업. 발생한다면 에러를 던진다.
       BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
       BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

       //버퍼리더 (많은양의 데이터를 받기에 빠르다 ), enter만 경계로 인식,
       int T = Integer.parseInt(n.readLine()); //int형으로 숫자 받기
       int num[] =new int [T*2]; //배열 생성 t개의 2배

       for(int i =0; i<T; i++){

       }

        bw.flush();
        bw.close();
    }
}
