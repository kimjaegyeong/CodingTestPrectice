import java.util.*;
import java.io.*;

public class Main {
	static int N, M, H;
	static boolean[][][] dp;
	static int ans = 4;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());

		dp = new boolean[H][N][N];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			dp[a][b][b + 1] = true;
			dp[a][b + 1][b] = true;
		}

		comb(0, 0);

		System.out.println(ans > 3 ? -1 : ans);
	}

	public static void comb(int depth, int start) {
		if (depth >= ans) return;
		if (climbing()) { 
			ans = depth;
			return;
		}

		if (depth == 3) return;

		for (int i = start; i < H; i++) {
			for (int j = 0; j < N - 1; j++) {

				if (dp[i][j][j + 1]) continue; // if [h][pos][pos+1] = true, already have a ladder
				if (j > 0 && dp[i][j - 1][j]) continue; // if [h][pos-1][pos] = true , we do not need to set a ladder at [pos][pos+1].
				// because, ladder exists at the same height, it is not allowed to use this ladder
				if (j < N - 2 && dp[i][j + 1][j + 2]) continue; // same [pos-1][pos] ..

				dp[i][j][j + 1] = true;
				dp[i][j + 1][j] = true;
				comb(depth + 1, i);
				dp[i][j][j + 1] = false;
				dp[i][j + 1][j] = false;
			}
		}
	}

	public static boolean climbing() {
		for (int i = 0; i < N; i++) {
			if (!move(i)) return false;
		}
		return true;
	}

	public static boolean move(int origin) {
		int pos = origin;
		for(int i=0; i<H; i++) {
			if (pos < N - 1 && dp[i][pos][pos + 1]) {
			    pos++;
			}
			else if (pos > 0 && dp[i][pos][pos - 1]) {
				pos--;
			}
		}
		
		if(origin == pos) return true;
		return false;
	}
}
