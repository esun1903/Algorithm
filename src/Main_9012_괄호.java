import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_9012_괄호 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

	BufferedReader br=  new BufferedReader(new InputStreamReader(System.in)); 
	StringTokenizer st = new StringTokenizer(br.readLine());
	StringBuilder sb= new StringBuilder();
	
	
	int T = Integer.parseInt(st.nextToken());
	
	for (int i = 0; i <T; i++) {
	String str = br.readLine();
	String awser= solve(str); 
	System.out.println(awser);
	}// T만큼 입력을 받기 
		

	}// end of main

	private static String solve(String str) {
		int linear = str.length(); // str의 길이 
	   int count =0; 
		for (char c : str.toCharArray()) {
			 
			if(c == '(')
				count++;  // 안에 ( 원소가 있다. 
			else {
				if(count ==0)
				    return "NO";
				else
					count--; 
			}
		}
			
			if(count ==0) 
				return "YES";
			else 
				return "NO";
				   
	
	}
}

/*
 * 괄호 문자열은 두 개의 괄호 기호인 ( 와 ) 만으로 구성되어 있는 문자열이다. 그 중 에서 괄호의 모양이 바르게 구성된 무자열을 올바른
 * 괄호 문자열이라고 부른다. 한 쌍의 괄호 기호로 된 " (  ) " 문자열은 기본 VPS이라고 부른다. 만일 x가 VPS라면 이것을 하나의
 * 괄호에 넣은 새로운 문자열 "(X") 도 VPS가 된다. 그리고 두 VPS x와 y를 접합시킨 새로운 문자열 xy도 VPS가 된다
 * 
 * 예를 들어 "(()()"와 "(((())))" 여러분은 입력으로 주어진 괄호 문자열이 VPS인지 아닌지를 판단해서 그 결과를 YES와
 * NO로 나타내어야 한다
 * 
 * 입력) 입력데이터는 표준 입력을 사용한다. 입력은 T개의 테스트 데이터로 주어진다 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수
 * T가 주어진다 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다. 하나의 괄호 문자열의 길이는 2이상 50이하이다.
 * 
 * 출력) 출력은 표준 출력을 사용한다. 만일 입력 괄호 문자열이 올바를 괄호문자열이면 "YES", 아니면 "NO"를 한 줄에 하나씩 차례대로
 * 출력해야 한다
 * 
 */
