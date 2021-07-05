package Programmers;
import java.util.*;
public class Main_입국심사_ver1 {

    public static void main(String ... args){

      int times [] = {7,10};
      solution(6,times);

    }//end of main

    public static long solution(int n, int[] times) {
        long answer = 0;
        PriorityQueue queue = new PriorityQueue();
        int [] arr = new int [times.length];
        int [] index;


        long now = 0;

        Arrays.sort(times);
        arr = times;

        //만약, times.length의 길이보다 같거나 작은 경우에는
        //n이 0보다 크고 times.length에 맞춰 나가기
        if(n <= times.length){
          for(int i = 0; n!=0 && i<times.length; i++){
              n--;
              answer = times[i]; //가장 마지막인 심사관이 가장 큰 값이므로 시간이 answer가 된다.
              now  = arr[i];
          }
        } //2번
        else {
            for(int i = 0; n!=0 && i<times.length; i++){
                n--;
                answer = times[0]; //가장 마지막인 심사관이 가장 큰 값이므로 시간이 answer가 된다.
                arr[i]+=arr[i]; //끝나는 시간을 넣어둔 arr
                now = times[0];
            }
            for(int i= times.length; i<=n; i++){ // 2-2)
                // 가장 빨리 시작할 수 있는 것 : times[i]의 값이 현 시간(now) 보다 적은 것들을 index에 담아 넣자.  (사람이 없어요~) &&
                // 가장 빨리 끝나는 것 : 이건 times에 가서 하나씩 계산을 해봐야 알 수 있을 것 같다.
                index = new int [times.length];
                long num = Integer.MAX_VALUE;
                long num2 = 0;
                for(int j = 0; j<times.length; j++){ //가장 빨리 끝나는 것!
                        if(num > times[i]+ times[i]){
                             num = times[i]+ times[i];
                             num2 = i;
                       }//end of if
                }//end of for


                num++;
            }//end of for
        }//end of if 문

        return answer;
    }//end of main

}//end of class

/*
흐름

가장 먼저 times에 있는 배열을 모두 정렬한다.
 1. 만약, n이 times 배열의 갯수와 같거나 적으면
   1-1. times 배열의 값의 최솟값부터 하나씩 한다.
 2. n > times.length-1에 속한다면
   2-1. 그렇다면 일단은 length 만큼가기
   2-2. 그다음 length에서 index가 시작되고
   2-3. index는 times에서 가장 빨리 시작할 수 있는 심사관과 가장 빨리 끝낼 수 있는 심사관을 구한 뒤,
   2-4. 그 다음 만약, 두 심사관이 다르다면 가장 빨리 끝낼 수 있는 심사관으로! :)
   이걸 반복하였다.
   그 다음 index가 n까지 이른다면 -> answer 하기


문제

n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다.

1. 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다.
2. 하지만 더 빨리 끝나는 심사대가 있으면 기다려싿가 그곳으로 가서 심사를 받을 수도 있습니다.
3. 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.

입국 심사를 기다리는 사람 수 n,각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 떄, 모든 사람이 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution함수를 작성해주세요.

*/