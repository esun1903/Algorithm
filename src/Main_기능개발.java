package Programmers;

import java.util.*;
import java.util.Stack;

public class Main_기능개발  {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        List<Integer> testList = new ArrayList<Integer>();
        int dayMax = 0; //며칠이 가장 큰값인지를 알려주는 것
        int count = 1;  // 몇개의 기능까지 된건지를 체크

        System.out.println(speeds);
        Stack<Integer> stack = new Stack<>();

        //1) 일단, 스택에 progresses의 값들을 모두 넣음
        for(int i  = progresses.length-1; i>=0; i--){
            stack.push(progresses[i]);
        }//end of for

        // 2) 스택에서 하나씩 꺼내면서 하나씩 x>= (100 - progress)/speeds 를 하기
        // 2-1) x를 구해서 int 배열에 모두 넣자
        for(int i  = 0; i<speeds.length; i++){
            int num = stack.pop();
            int x = (int)Math.ceil((double)(100-num)/speeds[i]);
            if(x<=dayMax){ //2-2) 만약, 그 전값이 크다면?
                count++;
                if(i == speeds.length-1){
                    testList.add(count);
                }//end of if
            }
            else {
                if(i == 0){
                    count = 1;
                    dayMax = x;
                    continue;
                }
                testList.add(count);
                count = 1;
                dayMax = x;
                if(i == speeds.length-1){//2-3) 만약, 그 인덱스가 가장 뒤쪽이라면?
                    testList.add(count);
                }//end of if
                continue;
            }
        }//(2) - end of for

        answer = new int [testList.size()];
        for(int i = 0; i<testList.size(); i++){
            answer[i] = testList.get(i);
        }
        return answer;

    }//end of method
}//end of class


/**
 *
 <21-07-01에 푼 문제>

 흐름
 1. progresse에 하나씩 넣은뒤 하나씩 꺼낸다
 2. 그 다음 꺼낸 값을 x 즉, 며칠이 걸리는 지를 계산하기 위한 식 x>= (100 - progress)/speeds 를 구한다.
 3. 이 값이 가장 큰 x보다 크다면 ? 변경한다.
 4. 만약 아니라면 기능를 세는 count변수에 ++를 한다.


 어려웠던 점
 1. 소수값이 존재한다면 무조건 +1를 높이는 것이 필요했는데 나는 반올림을 할 수 있는 round만 알고있어 검색을 통해 ceil을 찾았다.
    - 분명 배웠던 내용인데 까먹음 :)
 2. 흐름 - 2번 과정에서 for문을 돌면서 가장 마지막 배열번째가 왔을 때 arraylist에 추가하는 것,,을 잊음 -> 더 좋은 방법이 있지 않을까 생각된다.

 후기
 1. for문과 if문 그만 쓰고싶다! -> 깔끔한 코드,, 어떻게 하는 걸까아 :)



 문제

 프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다. 각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.
 또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 이쓴ㄴ 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
 이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

 먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때 각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.

 제한사항

 1. 작업의 개수는 100개 이하입니다.
 2. 작업 징도는 100 미만의 자연수입니다.
 3. 작업 속도는 100 이하의 자연수입니다.
 4. 배포는 하루에 한 번만 할 수 있으며, 하루의 끝에 이루어진다고 가정합니다. 예를 들어 진도율이 95%인 작업의 개발 속도가 하루에 4%라면 배포는 2일 뒤에 이루어집니다.

 progresses  speeds return
 [93,30,55] [1,30,5] [2,1]
 [95,90,99,99,80,99] [1,1,1,1,1,1] [1,3,2]

 **/