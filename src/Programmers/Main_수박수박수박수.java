package Programmers;

public class Main_수박수박수박수 {

    public static void main(String ... args){

        System.out.println(solution(4));

    }//end of main

    public static String solution(int n) {

        String answer = "";

        for(int i= 1; i<=n; i++){

            if(i%2==1){
                answer+="수";
            }else {
                answer+="박";
            }
        }
        return answer;
    }//end of method
}//end of class

/**
 *
 * 흐름
 *
 * 1. 짝수이면 수, 홀수이면 박 계속 n만큼 반복해서 answer를 만들기
 *
 * 문제
 *
 * 길이가 n이고, "수박수박수박수...."와 같은 패턴을 유지하는 문자열을 리턴하는 함수,
 * solution을 완성하세요.
 * 예를들어 n이 4이면 "수박수박"을 리턴하고 3이라면 "수박수"를 리턴하면 됩니다.
 *
 * 제한조건
 *
 * n은 길이 10,000이하인 자연수입니다.
 *
 * 입출력 예
 *
 * n  return
 * 3  "수박수"
 * 4  "수박수박"
 *
 */