package Programmers;

public class Main_문자열다루기기본 {
    public static void main(String ... args){

        System.out.println(solution("a124"));
    }//end of main

    public static boolean solution(String s) {
        boolean answer = true;

        if(s.length() == 4 || s.length() == 6){
            for(int i= 0; i<s.length(); i++){
                if(s.charAt(i)-'0'>=0 && s.charAt(i)-'0'<=9) {// 0 ~ 9까지인지 체크하기
                    continue;
                }else {
                    answer = false;
                    break;
                }
            }//end of for
        }else {
            answer = false;
        }//end of if

        return answer;
    }//end of method


}//end of class

/**
 *
 * 흐름
 * 1. 일단, 길이가 4 or 6인지 체크한 후
 * 2. 숫자로만 되어있는지 체크  아님 false 리턴
 * 문제
 *
 * 문자열 s의 길이가 4 혹은 6이고,
 * 숫자로만 구성돼있는지 확인해주는 함수,
 * solution을 완성하세요.
 * 예를 들어 s가 "a234"이면 False를 리턴하고 "1234"라면 True를 리턴하면 됩니다.
 */