package day0830;

import java.util.Scanner;

public class BinaryCountingTest {
 
	static int N; 
	static int [] numbers; 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//asdasdsa
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
        numbers = new int[N];

		for (int i = 0; i < N; i++) {
			numbers[i] = sc.nextInt();
		}
		int caseCount = 1<<N; 
		getnerateSubset(caseCount);
	}
	private static void getnerateSubset(int caseCount) {
	 
		for(int flag= 0; flag<caseCount; flag++) {
			//flag�쓽 媛� 鍮꾪듃�옄湲곕�� �솗�씤�븯�뿬 �썝�냼 �꽑�깮 �쑀/臾대�� �뙋�떒 
			for (int j = 0; j < N; j++) {
				if((flag &(1<<j))!=0) {
					System.out.print(numbers[j]+" ");
				}
			}
			System.out.println();
		}
		
	}

}
