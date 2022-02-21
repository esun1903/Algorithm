import java.util.Scanner;
import java.util.*;

public class Main_2231 {

    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();
        int nn = Integer.parseInt(n);
        int s = 1000001;
        int r = 0;
        for (int i = nn; i > 0; i--) {//부터
            String t = Integer.toString(i);
            r = i;

            for (int e = 0; e < t.length(); e++) {
                char o = t.charAt(e);
                r += o - '0';
            }
            if ((r == nn) && (s > i)) { //s생성자 같고있는 친구 (작아야됨 ) r은 그 다 합계
                s = i;
            }
        }
       if( s == 1000001)
           s = 0;

        System.out.println(s);
    }
}
