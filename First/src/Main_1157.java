import java.util.*;

import static com.sun.org.apache.xalan.internal.lib.ExsltStrings.split;

public class Main_1157 {
    public static void main(String... args) {

        Scanner sc = new Scanner(System.in);
        String x = sc.next(); //734
        String y = sc.next(); //839

        x = reverseString(x);
        y = reverseString(y);

        int result1 = Integer.parseInt(x);
        int result2 = Integer.parseInt(y);

        if (result1 > result2)
            System.out.println(result1);
        else
            System.out.println(result2);
    }
//여기부분 !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    public static String reverseString(String s) {
        return (new StringBuffer(s)).reverse().toString();
    }
}
