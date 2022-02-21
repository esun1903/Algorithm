package Programmers;

public class Main_문자열내p와y의개수 {

    public static void main(String ... args){

        System.out.println(solution("Pyy"));
    }

    public static boolean solution(String s) {
        boolean answer = true;
        int pPoint = 0;
        int yPoint = 0;

        for(int i= 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == 'P' || c=='p'){
                pPoint++;
            }else if(c == 'Y' || c=='y'){
                yPoint++;
            }
        }

        if(pPoint != yPoint){
           answer = false;
        }
        return answer;
    }
}


/**
 *
 * 흐름
 *
 * 1. for반복문으로 String을 하나하나 탐색하면서 가기
 * 2. 만약, p 거나 P이면 -> p point ++;
 * 3. 만약, y 거나 Y이면 -> y point ++; 되는 것
 * 대문자와 소문자가 섞여 있는 문자열 s가 주어집니다.
 * s에 'p'의 개수와 'y'의 개수를 비교해 같으면 True, 다르면 False
 * 를 return하는 solution를 완성하세요.
 *
 * 'p', 'y' 모두 하나도 없는 경우는 항상 True를 리턴합니다.
 * 단, 개수를 비교할 때 대문자와 소문자는 구별하지 않습니다.
 *
 */