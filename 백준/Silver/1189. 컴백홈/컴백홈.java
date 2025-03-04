import java.util.*;
import java.io.*;
public class Main
{
	static int K;
	static int R,C;
	static char map[][];
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int result = 0;
	static int visited[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new char[R][C];

		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}
		visited = new int[R][C];
		visited[R-1][0] = 1;
		dfs(R-1,0,1);

		System.out.println(result);
	}


	public static void dfs(int y, int x, int cnt) {
		if(y == 0 && x == C-1) {
			if(cnt == K) result++;
            
			return;
		}
		if(cnt > K) return;

		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(ny >=R || nx >=C || ny < 0 || nx < 0)  continue;
			if(visited[ny][nx] > 0 || map[ny][nx] == 'T')  continue;
		    visited[ny][nx] = 1;
			dfs(ny,nx, cnt+1);
			visited[ny][nx] = 0;
		}
	}
}
