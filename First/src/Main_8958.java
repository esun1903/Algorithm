import java.util.Scanner;
import java.util.*;

public class Main_8958 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 5입력받기
        String test[] = new String[n]; //String 배열 받기
        int result[] = new int[n];  //result
        int res = 0;
        int sum = 0;


        for (int i = 0; i < n; i++) {
            res = 0;
            test[i] = sc.next(); //OXOOX        //next()메소드는 공백전까지 입력받은(이게중요)

            String[] s2 = test[i].split("X");// s2[0] = O , s2[1] = OOO

            for (int t = 0; t < s2.length; t++) { // 1+ 3 = 4 길이에 따라 달라진다는 것을 계산해야됨

                if (s2[t].length() == 1)
                    res += s2[t].length();
                else if (s2[t].length() > 1) {
                    sum = 0;
                    for (int x = 1; x < s2[t].length() + 1; x++)
                        sum += x;

                    res += sum;
                }
            }

            result[i] = res;
        }
        for (int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
