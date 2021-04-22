import java.util.*;

public class Main_프로그래머스_단어변환 {

	public static void main(String[] args) {

		String begin = "hit";
		String target = "cog";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };
		System.out.println(solution(begin, target, words));
	}

	public static int answer = Integer.MAX_VALUE;

	public static int solution(String begin, String target, String[] words) {

		boolean visited[] = new boolean[words.length];
         visited[0] = true; 
		dfs(0, begin, target, words, 0, visited);

//		변환할 수 없는 경우에는 0를 return 합니다.
//		if (answer == Integer.MAX_VALUE)
//			answer = 0;

		return answer;
	}
 
	private static int dfs(int i, String begin, String target, String[] words, int step, boolean[] visited) {
		// 만약, 1개도 겹치지 않는다면 return 하기 / 2개 이상 겹친다면? -> return 하기
		// 오,, 이거 단어 계산하는 방법 뭐지
		if (begin.equals(target)) {
			if (answer > step)
				answer = step;
			System.out.println(step);
			return step;
		}

		//이렇게 자르고 !! 
		String[] str = begin.split(""); // 1
		String[] str2 = words[i].split(""); // 2

		int yes = 0;
		int no = 0;
		for (int j = 0; j < str.length; j++) {
			if (str[j].equals(str2[j])) { // 겹치지 않는다면
				yes++;
			} else {
				no++;
			}
		}
		
		if (no == 0) {
			return Integer.MAX_VALUE;
		}
		
		if (no == 1) {
			String s = words[i];
			for (int j = 0; j < words.length; j++) {
				if (visited[j] == false) {
					visited[j] = true;
					dfs(i + 1, s, target, words, step + 1, visited);
					visited[j] = false;
				}
			}
		}  
      System.out.println(step );
		return step;
	}
}

/*
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로
 * 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있다 2. words에 있는 단어로만 변환할 수 있습니다.
 * 
 */
