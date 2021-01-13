import java.util.Scanner;

public class Main_20055_컨베이어벨트위의로봇 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in );
		int N = sc.nextInt(); 
		int K = sc.nextInt();
       
		int [] arr = new int [2*N]; 
		for (int i = 0; i < 2*N; i++) {
			arr[i] =  sc.nextInt();
		}
	}

} // end of class
/*
 * 길이가 N인 컨베이어 벨트가 있고 길이가 2N인 벨트가 이 컨베이어 벨트를 위아래로 감싸며 돌고 있따. 
 * 벨트는 길이 1 간격으로 2N개의 칸으로 나뉘어져 있으며, 각 칸에는 아래 그림과 같이 1 부터 2N까지의 번호가 매겨져 있다. 
 * 
 * 벨트가 한 칸 회전하면 1번부터 2N-1까지의 칸은 다음 번호의 칸이 위치로 이동하고, 
 * ~
 *  
 */
