import java.util.*;
import java.util.Scanner;

public class Main_2577 {
    public static void main(String... args) {
        Scanner s = new Scanner(System.in);
        int a, b, c, rst;
        int temp[] = new int[11]; //숫자 카운트할 배열

        a = s.nextInt();
        b = s.nextInt();
        c = s.nextInt();

        rst = a * b * c;

        while (true) {
            //여기부분이 막혔다,,,,,ㅜ 계속 헤맴
            temp[rst % 10]++;
            rst = rst/10;
            if(rst == 0)
                break;
        }

         for(int i= 0; i<10; i++)
         {
             System.out.println(temp[i]);
         }



    }
}
