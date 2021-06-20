package Programmers;

public class Main_문자열을정수로바꾸기 {
    public static void main(String ... args){

        System.out.println(solution("+-"));

    }//end of main

    public static int solution(String s) {
        int answer = 0;
        //양수, 음수인지 판단하는 boolean값
        boolean flag = true;

        for(int i= 0; i<s.length();i++){


        }//end of for

        return answer;
    }

}//end of class

/**
 *
 * 문제
 *
 * 문자열 s를 숫자로 변환한 결과를 반환하는 함수, solution을 완성하세요
 *
 *
 * 제한조건
 *
 *  s의 길이는 1이상 5이하입니다.
 *  s의 맨앞에는 부호가 올 수 있습니다.
 *  s는 부호와 숫자로만 이루어져 있습니다.
 *  s는 "0"으로 시작하지 않습니다.
 *
 */