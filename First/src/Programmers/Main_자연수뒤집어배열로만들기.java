package Programmers;

public class Main_자연수뒤집어배열로만들기 {
    public static void main(String ... args){

        long n = 12345;
        int arr[] = solution(n);

    }

    public static int[] solution(long n) {
        int[] answer;

        String str = Long.toString(n);
        answer = new int [str.length()];
        int count  = 0;
        for(int i=str.length()-1; i>=0; i--){
           char c = str.charAt(i);
           answer[count] = c-'0';
           count++;
        }// end of for


        return answer;
    }
}

/**
 * 흐름
 *
 * 1. Long형을 String 으로 변경한뒤
 * 2. 반복문을 뒤에서부터 돌면서 int[]에 하나씩 넣어준다.
 *
 * 문제
 *
 * 자연수 n을 뒤집어 각 자리 숫자를 원소로 가지는 배열 형태로 리턴해주세요.
 * 예를 들어 n이 12345이면 [5,4,3,2,1]을 리턴한빈다.
 *
 *
 *
 */