package Programmers;

import java.util.Arrays;

public class Main_문자열내림차순으로배치하기 {

    public static void main(String ... args){

        System.out.println( solution("Zbcdefg"));
    }

    public static String solution(String s) {
        String answer = "";

        char [] c = new char[s.length()];

        for(int i= 0; i<s.length(); i++){
           c[i] =  s.charAt(i);
        }//end of for

        Arrays.sort(c);

        for(int i= s.length()-1; i>=0; i--){
            answer+=c[i];
        }//end of for
        return answer;
    }// end of method
}

/**
 *
 *
 * 문제
 *
 * 문자열 s에 나타나는 문자를 큰것부터 작은 순으로 정렬해 새로운 문자열을 리턴하는 함수,
 * solution을 완성해주세요.
 *
 * s는 영문 대소문자로만 구성되어 있으며, 대문자는 소문자보다 작은것으로 간주합니다.
 *
 * 제한사항
 *  - str은 길이 1이상인 문자열입니다.
 */