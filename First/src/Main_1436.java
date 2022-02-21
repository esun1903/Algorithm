import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1436 {
    //2시 15분 열음  #이해완료 #다시해보기!
    public static void main(String... args) throws IOException {

        //BufferedReader 를 사용하여 받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int num = 0;
        while (n > 0) {  //num을 하나씩 증가해가며 -> 1부터 계속 증가
            num++;
            String str = Integer.toString(num);
            if(str.contains("666")) //666
                n--; //n이 줄어들면서 체크하기!!!!!!!!!!11

        }
        System.out.println(num);
        // 666-> 1660 ~ -> 6660 -> 7660 ->8666-> ~6으로 시작할때는 정리하기
        //이게 키포인트 v 아 나도 진짜 알고리즘 너무너무너문ㅁ너무누ㅜㅜ누 잘하고싶다 :)

    }
}
