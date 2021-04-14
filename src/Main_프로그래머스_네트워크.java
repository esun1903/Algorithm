

public class Main_프로그래머스_네트워크 {

	public static void main(String[] args) {
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}}; 
		int n = 3; 

		System.out.println(solution(3,computers));
	}

	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] visited = new boolean[n]; // 원래 clone 썼다가 취소
		// dfs 돌리자

		for (int i = 0; i < n; i++) {
			if (visited[i] == false) { // 2라면 방문한걸로 처리해야함
				dfs(i, n, computers, visited);
				answer++;
			}
		}
		return answer;
	}

	private static  void dfs(int i, int n, int[][] computers, boolean[] visited) {
		visited[i] = true; // 방문처리

		for (int j = 0;  j < n; j++) {
			if (visited[j] == false && computers[i][j] == 1 && i!=j) {
				System.out.println(j+" 방문예정 ");
				dfs(j, n, computers, visited);
			}
		}
	}

}

/*
 * 
 * 안됐던 점 : 29번째 줄에서 원래는 j = i 라고 하고 진행했었는데 j == 0부터 하니 됐다 :)  ! 
 * 
 * 생각 1. computers에 가로 한줄당 1인 경우를 -> 위치를 찾아 Node 클래스에 넣기 2. dfs 로 check를 한다. 3.
 * 만약 방문 경험이 없다면 ? (return ) 4. 이 count를 세고 -> return
 * 
 * 
 * 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어 컴퓨터 A와 B가 직접적으로 연결되어 있고
 * 컴퓨터 B와 C가 연결되어있는때 컴퓨터 A와 C도 간접적으로 연결되어 정보를 교환할 수 있따. 따라서 컴퓨터 A와 B와 C는 모두 같은
 * 네트워크 상에 있다고 할 수 있따. 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때,
 * 네트워크의 개수를 return 하도록 solution 함수를 작성하시오
 * 
 * 제한 사항 1. 컴퓨터의 개수 n은 1이상 200 이하인 자연수이다. 2. 각 컴퓨터는 0부터 n-1인 정수로 표현한다. 3. i번
 * 컴퓨터와 j번 컴퓨터가 연결되어 있따면 computers[i][j]를 1로 표현합니다. 4. computer[i][j]는 항상 1입니다.
 * 
 * 입출력 예 n computers return 3 [[1, 1, 0], [1, 1, 0], [0, 0, 1]] 2 3 [[1, 1, 0],
 * [1, 1, 1], [0, 1, 1]]
 * 
 * 
 * 
 */
