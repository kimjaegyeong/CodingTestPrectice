import java.util.*;
import java.io.*;

class Point {
	int y;
	int x;

	public Point(int y, int x) {
		this.y = y;
		this.x =x;
	}

	public int manhattanDist(Point p) {
		return Math.abs(this.y - p.y) + Math.abs(this.x - p.x);
	}
}

public class Main
{
	static int N;
	static int K;
	static Point points[];
	static int dp[][];
	static int MAX = 1000000001;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new int[K+1][N+1];
		points = new Point[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int x= Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			points[i] = new Point(y,x);
		}

		for(int i=1; i<K+1; i++) {
			for(int j=0; j<N+1; j++) {
				dp[i][j] = MAX;
			}
		}


		for(int i=1; i<N; i++) {
			dp[0][i] = dp[0][i-1] + points[i].manhattanDist(points[i-1]);
		} //K == 0

		for(int i=0; i<N; i++) {
			for(int j=0; j<=K; j++) {
				if(i - j <= 0 ) continue;

				for(int r=0; r<=j; r++) {
					int next = dp[j-r][i - r - 1] + points[i].manhattanDist(points[i-r-1]);
					dp[j][i] = Math.min(dp[j][i], next);
				}
			}
		}
		
		int result = MAX;
		for(int i=0; i<K+1; i++){
		    result = Math.min(result , dp[i][N-1]);
		}
        
        System.out.println(result);
	}
}