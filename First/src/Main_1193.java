import sun.awt.geom.AreaOp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1193 {
    public static void main(String ... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        //등차수열의 법칙  n(n+1)/ 2로 몇번째 줄에 위치한 항의 개수인지 판단하기
        int line = 0;
        int cnt = 0;

        while (cnt < x) {
            line++;  //1
            cnt = line * (line + 1) / 2;
        }

        //짝수번째 줄과 홀수번쨰 줄일때 반대방향을 가지므로,
        //마지막조건을 이용하여 홀수일때와 짝수일때의 결과를 나타내기
        if (line % 2 == 0) {  //짝수일때는 크게
            int top = line - (cnt -x);
            int bottom = 1 + (cnt - x);
            System.out.println(top + "/"+bottom);
        } else {  //홀수일때는 작게
            int top = 1 + (cnt-x) ; // 1 + ( 15 - 14)
            int bottom = line - (cnt-x); //4
            System.out.println(top + "/"+bottom);
        }


    }

}
