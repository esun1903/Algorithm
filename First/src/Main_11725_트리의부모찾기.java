

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_11725_트리의부모찾기 {
    public static  boolean isVisited[];
    public static int N;
    public static ArrayList<Integer> [] arrayList;
    public static int [] parent;
    public static void main(String ... args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList[N+1];
         isVisited = new boolean[N+1];
         parent = new int[N+1];
        for (int i=1; i<=N; i++){
            arrayList [i] = new ArrayList<>();
            isVisited[i] = false;
        }

        int left =0;
        int right = 0;

        // for문으로 반복하며 -> 입력받고 -> 추가하기
        for (int i = 0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            left = Integer.parseInt(st.nextToken());  //왼쪽
            right = Integer.parseInt(st.nextToken());  // 오른쪽

            arrayList[left].add(right);
            arrayList[right].add(left);
        }

        DFS(1);

        for (int i=2; i<=N; i++){
            System.out.println(parent[i]);
        }



    }

    private static void DFS(int t) {
        isVisited[t] = true;
        for (int i=0;i<arrayList[t].size(); i++){ //N까지
            int count = arrayList[t].get(i);
            if(!isVisited[count]){
               isVisited[count] = true;
               parent[count] = t;
               DFS(count);
            }
        }
    }//end of DFS


    // 원래 이렇게 시도하려고 했었는데 실패,,,! :)
    // 참고한 사이트 : https://soboruya.tistory.com/51
    //Node Class
  public static class Node {
        int left;
        int right;

        public Node() {
            this.left = left;
            this.right = right;
        }

    }


    //Tree Class
    public static class Tree{
        Node root;
        public void add(int left, int right){
          root.left = left;
          root.right = right;
        }
    }


}

/*
* 루트 없는 트리가 주어진다. 이때, 트리의 루트를 1이라고 정했을때,
* 각 노드의 부모를 구하는 프로그램을 작성하시오
*
*
* 입력: 첫째 줄에 노드의 개수 N이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
*
* 출력 : 첫째 줄부터 N-1개의 줄에 각 노드의 부모 노드 번호를 2번 노드부터 순서대로 출력한다.
*
* 7
* 1 6
* 6 3
* 3 5
* 4 1
* 2 4
* 4 7
*
* */