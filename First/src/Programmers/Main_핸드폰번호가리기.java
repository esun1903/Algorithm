package Programmers;

public class Main_핸드폰번호가리기 {

    public static void main(String ... args){

        String answer = solution("01034");
        System.out.println(answer);

    }// end of main

    public static String solution(String phone_number) {

        String answer = "";
        String str = "";

        for(int i = phone_number.length()-1; i>=0; i--){

            if(i>=phone_number.length()-4)
                str = str + phone_number.charAt(i);
            else
                answer+="*";

        }// end of for


        for(int i= 3; i>=0; i--){
            answer+= str.charAt(i);
        }

        return answer;
    }//end of solution

}// end of class

/*
 흐름

 뒤에서부터 앞으로가면서 4까지는 숫자를 보여주고
 나머지는 *를 한다.

 문제

 프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호 일부를
 가립니다.
 전화번호가 문자열 phon_number로 주어졌을 떄, 전화번호의 뒷 4자리를 제외한
 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, solution을 완성해주세요

 입출력 예
 phone_number return
 01033334444  ******* 4444
 */