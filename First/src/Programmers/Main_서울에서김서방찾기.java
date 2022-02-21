package Programmers;

import java.util.Arrays;

public class Main_서울에서김서방찾기 {
    public static void main(String ... args){

        String [] seoul = {"Jane", "Kim","eunseon"};
        System.out.println(solution(seoul));
    }//end of main

    public static String solution(String[] seoul) {
        String answer = "";

        for(int i= 0; i<seoul.length; i++){
            if(seoul[i].equals("Kim")){
                answer = "김서방은 "+i+"에 있다";
            }//end of if
        }//end of for

        return answer;
    }

}//end of class


/**
 * 흐름
 * 1. Arrays.binarySearch : 이진탐색 함수를 활용하여 특정한 값을 찾는 알고리즘인데 -> 편하게 라이브버리를 사용하려고 했다가 틀려서 당황했던 문제
 *
 * 문제
 *
 *
 * String형 배열 seoul의 element 중 "Kim"의 위치 x를 찾아, "김서방은 x에 있다"는 String을 반환하는 함수,
 * solution을 완성하세요. seoul에 "Kim"은 오직 한 번만 나타나며 잘못된 값이 입력되는 경우는 없습니다.
 *
 * 제한사항
 *  - seoul은 길이 1 이상, 1000 이하인 배열입니다.
 *  - seoul의 원소는 길이 1이상, 20 이하인 문자열입니다.
 *  - "Kim"은 반드시 seoul안에 포함되어 있습니다.
 *
 *  입출력 예
 *  seoul               return
 *  ["Jane", "Kim"]   "김서방은 1에 있다."
 */