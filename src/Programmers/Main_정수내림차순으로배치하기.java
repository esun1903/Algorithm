package Programmers;

import java.util.Arrays;
import java.util.Collections;

public class Main_정수내림차순으로배치하기 {

    public static void main(String ... args){

        long n = 118372;
        System.out.println(solution(n));

    }//end of main

    public static long solution(long n) {
        long answer = 0;

        String str = Long.toString(n);
        System.out.println("1 :" + str);
        int [] arr = new int [str.length()];

        for(int i= 0; i<str.length(); i++){
            char c = str.charAt(i);
            arr[i] = c -'0';
        }//end of for


        Arrays.sort(arr);

        str="";
        for(int i= arr.length-1; i>=0; i--){
            str+=arr[i];
        }

        answer = Long.parseLong(str);

        System.out.println("2 :" + answer);
        return answer;
    }//end of method

}//end of class

/**
 * 흐름
 *
 *  1. long이라는 자료형을 int 자료형으로 바꾸려고 한다면?
 *  1-1. 일단, String으로 변경하기
 *
 * 문제
 *
 * 함수 solution은 정수 n을 매개변수로 입력받습니다. n의 각 자릿수를 큰것부터 작은 순으로
 * 정렬한 새로운 정수를 리턴해주세요. 예를 들어 118372면 873211을 리턴하면됩니다.
 *
 * 제한 조건
 *  - n은 1이상 800~~ 이하인 자연수입니다.
 *
 *  입출력 예
 *
 *     n     return
 *  118372   873211
 */