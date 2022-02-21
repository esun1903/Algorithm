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

		dfs(begin, target, words, 0, visited);
		
		if (answer == Integer.MAX_VALUE)
			answer = 0;
		return answer;
	}

	private static void dfs(String begin, String target, String[] words, int step, boolean[] visited) {
		if (begin.equals(target)) {
			answer = Math.min(step, answer);
			return;
		}

		for (int j = 0; j < words.length; j++) { 
			if (visited[j] == false) {
				String[] str = begin.split(""); 
				String[] str2 = words[j].split(""); 

				int no = 0;

				for (int k = 0; k < str.length; k++) {
					if (str[k].equals(str2[k])) { // 둘이 겹친다면 ?
					} else {
						no++;
					}
				}
					if (no == 1) {
						visited[j] = true;
						dfs(words[j], target, words, step + 1, visited);
						visited[j] = false;
					}
				}
			}
		}
	}


/*
 * 두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로
 * 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.
 * 
 * 1. 한 번에 한 개의 알파벳만 바꿀 수 있다 2. words에 있는 단어로만 변환할 수 있습니다.
 * 
 * 틀렸던 점 : 1. dfs돌리기 전에 visited[0]  = true를 했던 점  등등 있었다 :) 
 *  
 * 
 */
