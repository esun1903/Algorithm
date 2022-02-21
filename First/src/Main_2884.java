import java.util.*;

public class Main_2884 {
    public static void main(String... args) {
        //알람시계

        /* 상근이만의 알람
         45분 일찍 알람 설정하기

         원래 설정되어있는 것에 -> 45분 ㅇ리찍 */
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt(); //알람 시간 H , M
        int m = sc.nextInt();

        if (m < 45) { //44분까지면 -> 그전으로 감
            int a = 45 - m;
            m = 60 - a; //분수
            if (h == 0)
                h = 23;
            else
                h--;
        } else
            m -=45;

        System.out.print(h+" ");
        System.out.print(m);
    }
}
