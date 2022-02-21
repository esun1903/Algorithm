import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;

import java.util.*;

public class Main_2839 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x, y;
        x = n / 5;
        y = n % 5;

        int a = 0;
        int c = x-1;
        int c1 = n-5*c;

        //설탕배달 -> 최대한 적은 봉지를 가져가기위한 상근이
        // 3kg , 5kg의 봉지가 있다


//        (1)     5로 잘 나눠질때
        if(x > 0 && y == 0 ){
            System.out.println(x);
            System.exit(0);
        }
//        (2)     5로 안나눠지는데 3으로 잘나눠질때
        if(y>0 && n/3 >0 && n%3 == 0 ){
            System.out.println(n/3);
            System.exit(0);
        }

//        (3)     5로 나눠지는 것도 아니고 3으로 나눠지는 것도 아닐때
       if (y == 1 || y == 2 || y == 4) {
            if(n % 3 == 0 ) {
                System.out.println(n / 3);
                System.exit(0);
            }
            if(c>0 && c1%3==0){
                System.out.println(c+(c1/3));
                System.exit(0);
            }
            System.out.println(-1);
        } else {

            if (y == 4 && x > 0)
                a = 2;
            else if (x > 0)
                a = 1;
            System.out.println(x + a);
        }
    }
}
