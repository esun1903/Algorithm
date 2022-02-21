package Programmers;

public class Main_짝수와홀수 {
    public static void main(String ... args){

        System.out.println(solution(4));

    }// end of main
    public static String solution(int num) {
        String answer = "";
        if(num%2==0){
            return "Even";
        }
        else{
            return "Odd";
        }
    }
}// end of class


/**
 *
 * 문제
 *
 * 정수 num이 짝수일 경우 "Even"을 반환하고 홀수인경우 "Odd"를 반환하는 함수
 * solution을 완성해주세요.
 *
 * 제한 조건
 * - num은 int 범위의 정수입니다.
 * - 0은 짝수입니다.
 */