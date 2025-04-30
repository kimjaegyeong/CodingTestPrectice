import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int[][] dp;
	static int[] map;
	static int MAX = -100000001;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		dp = new int[2][N+1];
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		dp[0][0] = map[0];
		dp[1][0] = 0;
		MAX = Math.max(MAX,dp[0][0]);

		for(int i=1; i<N; i++) {
			if(dp[0][i-1] + map[i] > map[i] ) {
				dp[0][i] = dp[0][i-1] + map[i];
			} else {
				dp[0][i] = map[i];
			}

			if(dp[1][i-1] + map[i] > dp[0][i-1]) {
				dp[1][i] = dp[1][i-1] + map[i];
			} else {
				dp[1][i] = dp[0][i-1];
			}

			MAX = Math.max(MAX,dp[1][i]);
			MAX = Math.max(MAX,dp[0][i]);

		}

		System.out.println(MAX);

	}
}
