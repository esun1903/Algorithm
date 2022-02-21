package Programmers;

public class Main_최대공배수와최소공배수 {

    public static void main(String ... args) {

     int [] arr = solution(2,5);
     System.out.println(arr);

    }

    public static int[] solution(int n, int m) {

        int[] answer = {};



        return answer;

    } // end of solution 함수

}// end of class

/**
 *
 * 흐름
 *
 * 1. 두 수의 입력을 받는다.
 * 2. 최대공약수, 최대공배수를 구하기
 *
 *
 * 문제
 *
 * 두 수를 입력받아 두 수의 최대공약수와 최소공배수를 반환하는 함수, solution을 완성해보세요.
 * 배열의 맨 앞에 있는 최대공약수와, 그 다음 최소공배수를 넣어 반환하면 됩니다.
 * 예를 들어 두 수 3,12의 최대공약수는 3, 최소공배수는 12이므로 solution(3,12)는 [3,12]를 리턴해야한다.
 *
 * 입출력 예
 * n m return
 * 3 12 [3,12]
 * 2 5 [1,10]
 *
 */