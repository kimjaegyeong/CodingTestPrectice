import java.util.*;
import java.io.*;

public class Main {
	static int N, M, H;
	static int mod = 10007;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		int[] dp = new int[H + 1];
		dp[0] = 1;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> blocks = new ArrayList<>();

			while (st.hasMoreTokens()) {
				int block = Integer.parseInt(st.nextToken());
				if (block <= H) {
					blocks.add(block);
				}
			}

			for (int j = H; j >= 0; j--) {
				for (int block : blocks) {
					if (j >= block) {
						dp[j] = (dp[j] + dp[j - block]) % mod;
					}
				}
			}
		}

		System.out.println(dp[H]);
	}
}