package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Main_문자열내마음대로정렬하기 {

    public static void main(String ... args ){

        String [] strings = {"sun","bed", "car"};
        int n = 1;
        System.out.println(solution(strings, n));
    }//end of main

    public static String[] solution(String[] strings, int n) {
        String[] answer = {};
        TreeMap<Character, Integer> map = new TreeMap<Character,Integer>();

        for(int i = 0; i<strings.length; i++){
            map.put(strings[i].charAt(n), i);
        }//end of for

//        for(int i= 0; i<map.size(); i++){
            System.out.println(map);
//        }//end of for

      return answer;
    }//end of method

}//end of class


/**
 *
 * 흐름
 * 1. n이라는 int형 숫자를 입력받은 뒤 -> for 반복문을 돌면서 char형 배열에 하나하나 넣기
 * 2. 그 다음 char배열을
 *
 *
 * 문제
 *
 * 문자열로 구성된 리스트 string와, 정수' n이 주어졌을 때, 각 문자열의 인덱스 n번째 글자를 기준으로 오름차순 정렬하려 합니다.
 * 예를 들어 strings가 ["sun", "bed]
 */