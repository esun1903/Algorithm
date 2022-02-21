
import java.io.*;
import java.util.StringTokenizer;

public class Main_2869 {
    public static void main(String... args) throws IOException {

        /*땅 위에 달팽이가 있다. 이 달팽이는 높이가 v미터인 나무 막대를 올라갈 것이다
         달팽이는 낮에 A미터를 올라간다. 하지만, 밤에 자는 동안 B미터 미끄러진다.
         또 정상에 올라간 후에는 미끄러지지 않는다.*/

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); //올라감
        int b = Integer.parseInt(st.nextToken()); //미끌어짐
        int v = Integer.parseInt(st.nextToken()); //목표

        int result = (v - b) / (a - b); // ( 목표 - 미끌어지는거 )  / ( 올라감 - 미끌어짐 )
        if ((v - b) % (a - b) != 0) {
            result += 1;
            System.out.println(result);
        } else System.out.println(result);

    }
}
