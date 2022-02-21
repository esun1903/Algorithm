import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main_프로그래머스_가장큰수2 {

	public static void main(String[] args) {
		int[] numbers = { 3, 30, 34, 5, 9 };
		solution(numbers);
	}

	public static String solution(int[] numbers) {
		String str = "";
		String[] temp = new String[numbers.length];
		Map<Integer, String> map = new HashMap<Integer, String>();

		for (int i = 0; i < temp.length; i++) {
			temp[i] = Integer.toString(numbers[i]);
		}
	       //배열 정렬, 정렬 규칙으로는 2개를 더하여 더 큰 쪽이 우선순위가 있도록 정렬
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return (s2+s1).compareTo(s1+s2);
            }
        });
        
        if(temp[0].equals("0")) return "0";
        for (String string : temp) {
			str+=string;
		}
       return str;
	}// end of 함수

}// end of class

/*
 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
 * 
 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 이중
 * 가장 큰 수는 6210입니다.
 * 
 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
 * return 하도록 solution 함수를 작성해주세요.
 * 
 * 
 * 1. n과 m 처럼 순열
 */
