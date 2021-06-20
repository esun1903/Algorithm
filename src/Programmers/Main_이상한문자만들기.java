package Programmers;

public class Main_이상한문자만들기 {
    public static void main(String... args) {

        String s = "try hello world";
        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";

        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (s.charAt(i) - '0' < 0) { // 공백일 때에는 count  =0;
                count = 0;
            } else {
                //1) 만약, index가 짝수라면 -> 대문자로
                if (count == 0 || count % 2 == 0) {
                    if (s.charAt(i) - '0' < 49) { //대문자라는 이야기
                        count++;
                        continue;
                    } else { // 만약, 소문자라면 ? -> 대문자로 바꾸기
                        int n = c - '0';
                        n -= 32; // 소문자 -> 대문자
                        char d = (char) (n + '0'); // 대문자로 변경
                        //내가 해야할 일 : 대문자로 변경한 것을 -> String으로 변경하기
                        char[] t = s.toCharArray();
                        t[i] = d;
                        s = new String(t);
                        count++;
                    }// end of else

                } else { //2) 만약, index가 홀수라면 -> 소문자로 바꾸기
                    if (s.charAt(i) - '0' >= 49) { //만약, 소문자다? 그럼 넘기기
                        count++;
                        continue;
                    } else {  //만약, 대문자라면?
                        int n = c - '0';
                        n += 32; // 대문자 -> 소문자
                        System.out.println(n);
                        char d = (char) (n + '0'); // 대문자로 변경
                        //내가 해야할 일 : 대문자로 변경한 것을 -> String으로 변경하기
                        char[] t = s.toCharArray();
                        t[i] = d;
                        s = new String(t);
                        count++;
                    }// end of else
                }
            }
        }// end of for
        answer = s;

        return answer;
    }

}

/**
 * 흐름
 * - 잘못생각했던 부분 : 아스키코드별로 짝/홀수를 찾아야하는 줄 알았지만 -> 그게 아니라 각 단어별로의 문제였다.
 * <p>
 * 문제
 * - 문자열 s는 한 개 이상의 단어로 구성되어 있습니다. 각 단어는 하나 이상의 공백문자로
 * - 구분되어 있습니다. 각 단어의 짝수번째 알파벳은 대문자로,
 * - 홀수번쨰 알파벳은 소문자로 바꾼 문자열을 리턴하는 함수, solution을 완성하세요.
 * <p>
 * 제한 사항
 * - 문자열 전체의 짝/홀수 인덱스가 아니라, 단어(공백을 기준)별로 짝/홀수 인덱스를 판단해야합니다.
 * - 첫 번쨰 글자는 0번쨰 인덱스로 보아 짝수번쨰 알파벳으로 처리해야 합니다.
 * <p>
 * 입출력 예
 * <p>
 * s               return
 * try hello world  TrY HeLIO WoRID
 * <p>
 * 입출력 예 설명
 * try hell world는 세 단어 "try", "hello", "world"로 구성되어 있습니다.
 * 각 단어의 짝수번째 문자를 대문자로, 홀수번째 문자를 소문자로 바꾸면 "TrY", "HeLIO", "WoRID"입니다.
 * 따라서 "TrY HeLIO WoRID"를 리턴합니다.
 */