import java.io.BufferedReader;
import java.util.Scanner;

public class Main_10250 {
    public static void main(String... args) {
        /*각 층에 W개의 방이 있는 H층 건물이라고 하자.*/

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); //2
        int t1[] = new int[t * 3];
        int line = 1;
        for (int i = 0; i < t * 3; i++) { // t만큼 입력받기
            t1[i] = sc.nextInt();
        }

   // 호텔의 층수 , 각 층의 방 수 , 몇 번째 손님인 지 를 나타내기

            for (int i = 0; i < t*3; ) {
                      line = 1;
                while (t1[i] * line < t1[i + 2]) // 6 <10
                {
                    line++;
                }

                if (line < 10) {
                     System.out.println( t1[i+2] - (line-1)*t1[i]+"0"+line);
                }
                else
                    System.out.println(t1[i+2] - (line-1)*t1[i]+""+line);

                i = i +3;
            }



    }
}
