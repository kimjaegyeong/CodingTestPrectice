import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int visited[][];
	static int map[][];
	static int[] dy= {0,1};
	static int[] dx= {1,0};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited= new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		ArrayDeque<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] {0,0});
		visited[0][0] = 1;
        
        if(N==1 && M==1){
            System.out.println("Yes");
            return;
        }

		while(!q.isEmpty()) {
			int[] node = q.poll();

			for(int i=0; i<2; i++) {
				int ny = node[0] + dy[i];
				int nx = node[1] + dx[i];

				if(!check(ny,nx)) continue;

				if(goal(ny,nx)) {

					System.out.println("Yes");
					return ;
				}

				q.offer(new int[] {ny,nx});
				visited[ny][nx] = 1;


			}

		}

		System.out.println("No");
		return;

	}

	public static boolean goal(int y, int x) {
		if(y == N-1 && x == M-1) return true;
		return false;
	}

	public static boolean check(int y,int x) {
		if(y >= N || x >=M || y< 0 || x< 0 || visited[y][x] ==1 || map[y][x] == 0 ) return false;
		return true;
	}
}
