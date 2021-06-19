package Programmers;

public class Main_자릿수더하기 {
    public static void main(String ... args){

        System.out.println(solution(123));
    }

    public static int solution(int n) {
        int answer = 0;

        String str = Integer.toString(n);

        for(int i= 0; i<str.length(); i++){
            char c = str.charAt(i);
            answer += c- '0';
        }//end of for

        return answer;
    }
}

/**
 *
 * 문제
 *
 * 자연수 N이 주어지면 N의 각 자릿수의 합을 구해서 return 하는 solution함수를 만들어 주세요.
 * 예를 들어 N= 123이면 1 + 2 + 3 = 6을 return 하면 됩니다.
 *
 * 제한사항
 *  - N의 범위 : 100,000,000 이하의 자연수
 *
 *  입출력 예
 *  N  answer
 *  123 6
 *  987 24
 *
 */