package Programmers;

public class Main_시저암호 {
    public static void main(String ... args){

        System.out.println(solution("a B z",4));

    }//  end of main

    public static String solution(String s, int n) {
        String answer = "";

        for(int i = 0; i<s.length(); i++){

            int one = s.charAt(i)  -'0';

            if(one<0){
                char d = (char) (one+'0');
                answer+= d;
                continue;
            }

            int two = one + n;


            //만약,대문자인데 z를 넘어섰다? -> 이만큼 a에서 더한값을 넣기
            if(one>=17&&one<=42 && two>42){
                two = two - 42;
                two += 16;
            }//end of if

            //만약, 소문자인데 z를 넘어섰다? -> 이만큼 a에서 더한값을 넣기
            if(one>=49&&one<=74 && two>74){
                two = two - 74;
                two += 48;
            }//end of if

            char d = (char) (two+'0');
            answer+= d;

        }// end of for

        return answer;
    }
}// end of class


/**
 *
 * 흐름
 *
 * 1. 만약, String을 int형으로 바꿨는데 ->  AB는 1만큼 밀면 BC가 되고,
 *    3만큼 밀면 DE가 됩니다.
 *    만약 z는 1만큼 밀면 a가 되니 -> 그 조건을 삽입하고 빼준다.
 * 문제
 *
 *  어떤 문장의 각 알파벳을 일정한 거리만큼 밀어서 다른 알파벳으로 바꾸는 암호화 방식을 시저 암호라고 합니다.
 *  예를 들어 "AB"는 1만큼 밀면 "BC"가 되고, 3만큼 밀면 "DE"가 됩니다.
 *  '"z"는 1만큼 밀면 "a"가 됩니다.
 *  문자열 s와 거리 n을 입력받아 s를 n만큼 민 암호문을 만드는 함수, solution을 완성해 보세요.
 *
 * 제한조건
 * - 공백은 아무리 밀어도 공백입니다.
 * - s는 알파벳 소문자, 대문자로 이루어져있습니다.
 * - s의 길이는 8000이하입니다.
 * - n은 1이상, 25이하인 자연수입니다.
 *
 */