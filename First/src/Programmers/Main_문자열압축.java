package Programmers;

public class Main_문자열압축 {

    public static void main(String... args) {
        System.out.println( solution("a"));
//        System.out.println( solution("ababcdcdababcdcd"));
//        System.out.println( solution("abcabcdede"));
//        System.out.println( solution("abcabcabcabcdededededede"));
//        System.out.println( solution("xababcdcdababcdcd"));
    }// end of main


    public static int solution(String s) {
        int answer = Integer.MAX_VALUE;

        if(s.length() ==1) {
            return 1;
        }
        //i<=s.length()/2
        for(int i = 1; i<=s.length()/2; i++){ //end를 지정한 for반복문
           answer =  Math.min(answer,solution2(s,i));
//            System.out.println("결과 " + solution2(s,i));
        }//end of for

        return answer;
    }//end of solution

    private static int solution2(String s, int j) {
     int count = 0;
     String ans = ""; //자른 것을 저장할 변수 ans
     String str = ""; //매번 자른 것을 저장하는 str
     String str2 = "";  //그 전꺼를 생각하는 str2
    int end =  j;
    int one = 1;
    boolean flag  = false;


     for(int i =0; i<i+j;){
         if(i <=s.length()){
             if(end >=s.length()){
                 end = s.length();
                 flag = true;
             }
             str = s.substring(i,end);
//             System.out.println(str);
             if(count == 0 ){
                 count = 1;
                 str2 = str;
             }else if(str2.equals(str)){  // 2-1. 만약, 둘이 같다면? count++증가시키고
                 count++;
             }else { //2-3. 만약, 다르다면?
                 if(count == 1 ){
                     ans += str2;
                     str2 = str;
                     count = 1;
                 }else {
                     ans += count + str2;
                     str2 = str;
                     count = 1;
                 }
             }//end of else

         }
       if(flag == false) {
           i = end;
           end = j * (one + 1);
           one++;
       }
       else {
           if(i+j >=s.length()){
               if(count == 1 ){
                   ans += str2;
                   str2 = str;
                   count = 1;
               }else {
                   ans += count + str2;
                   str2 = str;
                   count = 1;
               }
           }
//           System.out.println("결과" + ans);
           return ans.length();
       }
     }

//        System.out.println("결과" + ans);
     return ans.length();
    }

}//end of class


/**
 * 흐름
 * <p>
 * 1. 반복문을 돌리기 (for ) - 0부터 n/2까지 반복하기 (Start)
 *
 * 2. 그 다음 잘라서 확인해보기
 *  2-1. 만약, 둘이 같다면? count++증가시키고
 *  2-2. 만약, 처음이라면? 변수에 값 지정하기
 *  2-3. 만약, 다르다면? count = 1로 초기화 and 기존에 있던 것들을 count + string 형태로 String answer에 둔 뒤
 *
 * 3. 2번이 끝나면 answer와 Math.min으로 하기
 *
 *
 * 문제
 * <p>
 * 데이터 처리 전문자가 되고 싶은 "어피치"는 문자열을 압축하는 방법에 대해 공부를 하고 있습니다.
 * 최근에 대량의 데이터 처리를 위한 간단한 비손실 압축 방법에 대해 공부를 하고 있는데,
 * 문자열에서 같은 값이 연속해서 나타나는 것을 그 문자의 개수와 반복되는 값으로 표현하여 더 짧은 문자열로 줄여
 * 표현하는 알고리즘을 공부하고 있습니다.
 * <p>
 * 간단한 예로 "aabbaccc"의 경우 "2a2ba3c"
 * (문자가 반복되지 않아 한번만 나타난 경우 1은 생략)와 같이 표현할 수 있는데,
 * 이러한 방식은 반복되는 문자가 적은 경우 압축률이 낮다는 단점이 있습니다.
 * 예를 들면, "abcabcdede"와 같은 문자열은 전혀 압축되지 않습니다.
 * "어피치"는 이러한 단점을 해결하기 위해 문자열을 1개 이상의 단위로 잘라서 압축하여
 * 더 짧은 문자열로 표현할 수 있는지 방법을 찾아보려고 합니다.
 * <p>
 * 예를 들어, "ababcdbdababcdcd"의 경우 문자를 1개 단위로 자르면 전혀 압축되지 않지만,
 * 2개 단위로 잘라서 압축한다면 "2ab2cd2ab2cd 로 표현할 수 있습니다. 다른 방법으로 8개 단위로 잘라서 압축한다면
 * "2ababcdcd"로 표현할 수 있습니다.
 * 다른 방법으로 8개 단위로 잘라서 압축한다면 표현할 수 있으면
 * <p>
 * 압축할 문자열 s가 매개변수로 주어질 때, 위에 설명한 방법으로 1개 이상 단위로 문자열을 잘라 압축하여
 * 표현한 문자열 중 가장 짧은 것의 길이를 return 하도록 solution 함수를 완성해주세요
 */