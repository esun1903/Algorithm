import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String n = sc.nextLine();


        /*  StringTokenizer : 하나의 문자열을 여러 개의 문자열로
            분리하기 위해 사용-> 토큰 (구분문자로 분리된 문자열,,) */

        StringTokenizer strToken = new StringTokenizer(n, " "); // " " -> 구분문자
        System.out.println(strToken.countTokens()); //countTockens 마지막으로 토큰을 읽어오기전
                                                    // 남아있는 토큰의 수
    }
}