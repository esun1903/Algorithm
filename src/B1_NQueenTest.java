package day0830;

import java.util.Scanner;

public class B1_NQueenTest {

	static int N;
	static int[] col; // 각 행의 퀸의 위치를 저장
	static int answer;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N + 1];
        setQueens(1); //1행부터 놓기 
        System.out.println(answer);
	}

	// 퀸을 현재(rowNo) 행에 놓기
	public static void setQueens(int rowNo) {

		if (rowNo > N) {
			// 유망한 경우만 계속해서 따라 왔으므로 해가 됨 . 
             answer++;
			return;
		}
		
//		1행 : 2 
//		2행 : 4
//		3행 : 1
//      4행 : 3		
		// 가능한 선택지(1열부터 N열)
		
		//col[2] = 3 d은 2번째 행에 3번째열에 퀸이 있다. 
		for (int j = 1; j <= N; j++) {
			col[rowNo] = j;
			if (checking(rowNo)) { //현재 퀸의 열위치가 가능하다면 다음 퀸으로 
				setQueens(rowNo + 1);
			}
		    //1차원 배열로 퀸의 위치를 관리하므로 시도했던 선택지 열 값을 되돌리 필요가 없다. 	

		}
	}
//       1,1          1,5    
//          2,2   2,4 
//             3,3
//          4,2   4,4   
//       5,1          5,5

	// rowNo 행의 퀸을 놓는게 가능한지 체크 : 놓을 수 있다면 true, 놓을 수 없다면 false
	private static boolean checking(int rowNo) {

		for (int i = 1; i < rowNo; i++) {
			// col[rowNo] == col[i] : 같은 열 체크
			// Math.abs(col[rowNo] - col[i]) == rowNo - i : 대각선 체크
			if ((col[rowNo] == col[i]) || Math.abs(col[rowNo] - col[i]) == rowNo - i)
				return false;
		}
		return true;
	}

}
