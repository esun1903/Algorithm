package Programmers;

public class Main_모의고사_ver1 {

    public static void main(String ... args){
        int [] answers = {1,3,2,4,2};
        int [] result = solution(answers);
       for(int i = 0; i<result.length; i++){
           System.out.print(result[i]+" ");

       }
        System.out.println();
    }

    public static int[] solution(int[] answers) {
        int arr[][] = {{1,2,3,4,5,1,2,3,4,5},
                {2,1,2,3,2,4,2,5},
                {3,3,1,1,2,2,4,4,5,5}};
        int count[] = new int [3];

        for(int i= 0; i<arr.length; i++){
            for(int j = 0; j<answers.length; j++){
                if(arr[i][j] == answers[j]){
                    count[i]++;
                }
            }
        }
        int [] answer = new int [3];

        if(count[0]==count[1]&& count[1] == count[2]){
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
        }
        else if(count[0]>count[1] && count[0]>count[2]){
            answer = new int [1];
            answer[0] = 1;
        }
        else if(count[0] ==count[1] && count[0]>count[2]){
            answer = new int [2];
            answer[0] = 1;
            answer[1] = 2;
        }
        else if(count[0] ==count[2] && count[0]>count[1]){
            answer = new int [2];
            answer[0] = 1;
            answer[1] = 3;
        }
        else if(count[1]>count[0] && count[1]>count[2]){
            answer = new int [1];
            answer[0] = 2;
        }
        else if(count[1]==count[2] && count[1]>count[0]){
            answer = new int [2];
            answer[0] = 2;
            answer[1] = 3;
        }
        else if(count[2]>count[0] && count[2]>count[1]){
            answer = new int [1];
            answer[0] = 3;
        }
        return answer;
    }//end of method
}

/**
 123
 1
 12
 13
 2
 23
 3
 **/
/**
 흐름

 1번 수포자가 찍는 방식 : 1 2 3 4 5 1 2 3 4 5
 2번 수포자가 찍는 방식 : 2 1 2 3 2 4 2 5
 3번 수포자가 찍는 방식 : 3 3 1 1 2 2 4 4 5 5

 반복문을 돌며서 맞으면 count++; 를 한다.
 for(1,2,3 수포자인 경우)
 for(문제 정답 )

 수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려호 합니다.
 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

 1번 수포자가 찍는 방식 : 1,2,3,4,5,1,2,3,4,5, ..
 2번 수포자가 찍는 방식 : 2,1,2,3, ~

 1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answer가 주어졌을 떄, 가장 많은 문제를 맞힌 사람이 누군인지 배열에 담아
 return 하도록 solution 함수를 작성해주세요.

 제한 조건
 - 시험은 최대 10,000 문제로 구성되어있습니다.
 - 문제의 정답은 1,2,3,4,5 중 하나입니다.
 - 가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.

 입출력 예
 -  answers       return
 [1,2,3,4,5]      [1]
 [1,3,2,4,2]     [1,2,3]


 **/