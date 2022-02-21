import java.util.Scanner;
import java.util.*;

public class Main_2675 {
    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i < num; i++) {

            //입력받기
            int cnt = sc.nextInt();
            String str = sc.nextLine();

            //결과값 초기화
            String result = "";
            for (int j = 0; j < str.length(); j++) { //abc길이만큼
                for (int k = 0; k < cnt; k++) //3
                    result += str.charAt(j);//result 에 하기
            }
            result = result.replaceAll(" ", "");
            System.out.println(result);
        }
        sc.close();

    }
}
