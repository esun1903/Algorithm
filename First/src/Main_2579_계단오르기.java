import java.util.*;

public class Main_2579_계단오르기 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] cost = new int[n + 1];
		int[] dp = new int[n + 1];
		
		// 입력받기
		for (int i = 1; i <= n; i++)
			cost[i] = sc.nextInt();
		
		
		dp[1] = cost[1];
		// dp[2] = cost[2] 로 했던 게 문제였던 것 같다.  -> 계단이 1개일수도 2개일수도 있다는 것 
		
		// n이 2보다
		if (n >= 2)
			dp[2] = dp[1] + cost[2];
	
		for (int i = 3; i <= n; i++) // 3부터 
			dp[i] = Math.max(dp[i - 2] + cost[i], dp[i - 3] + cost[i - 1] + cost[i]);
	
		System.out.print(dp[n]);
	}
}
