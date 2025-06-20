import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int[][] map;
	static int[][] dp;

	static int[] dy  = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		dp = new int[N][M];

        for(int i=0; i<N; i++){
            Arrays.fill(dp[i], -1);
        }
        
		for(int i=0; i<N; i++) {
			 st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0,0);
		
        System.out.println(dp[0][0]);
	}
	
	public static int dfs(int y, int x) {
	    if(y == N-1 && x ==  M-1) return 1;
	    
	    if(dp[y][x] != -1) return dp[y][x];
	    
	    dp[y][x] =0;
	    
	    for(int i=0; i<4; i++){
	        int ny = y + dy[i];
	        int nx = x + dx[i];
	        
	        if(!check(ny,nx)) continue;
	        
	        if(map[ny][nx] < map[y][x] ) {
	            dp[y][x] += dfs(ny,nx);
	        }
	    }
	    
	    return dp[y][x];
	}

	public static boolean check(int y, int x ) {
		if(y >= N || x>=M || y< 0 || x < 0) {
			return false;
		}
		return true;
	}
}
