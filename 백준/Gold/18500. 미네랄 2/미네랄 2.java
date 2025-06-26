import java.util.*;
import java.io.*;
public class Main
{
	static int R, C;
	static char map[][];
	static int N;
	static int h[];

	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map= new char[R][C];

		for(int i=0; i<R; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		N = Integer.parseInt(br.readLine());
		h = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			h[i] = Integer.parseInt(st.nextToken());
		}

		//input process end

		for(int i=0; i<N; i++) {
			int height = R - h[i] ;
			int x =  cut(i%2, height);
			if(x == -1) continue;

			for(int d=0; d<4; d++) {
				int ny = height + dy[d];
				int nx = x + dx[d];
				if(!check(ny,nx)) continue;
				if(map[ny][nx] == 'x' && isCluster(ny,nx)) {

					fallCluster(ny,nx);


				}
			}
		}
		
		printMap();





	}

	public static void printMap() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++){
			    sb.append(map[i][j]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	public static boolean check(int y, int x) {
		if(y >= R || x >=C || y<0 || x<0) return false;
		return true;
	}

	public static int cut(int dir, int h) {
		if(dir == 0) {
			for(int i=0; i<C; i++) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					return i;
				}
			}
		} else {
			for(int i=C-1; i>=0; i--) {
				if(map[h][i] == 'x') {
					map[h][i] = '.';
					return i;
				}
			}
		}

		return -1;
	}

	public static boolean isCluster(int y, int x) {
		int[][] visited = new int[R][C];
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {y,x});
		visited[y][x] = 1;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			for(int i=0; i<4; i++) {
				int ny = coord[0] + dy[i];
				int nx = coord[1] + dx[i];
				if(!check(ny,nx) || visited[ny][nx] == 1 || map[ny][nx] != 'x') continue;
				visited[ny][nx] = 1;
				q.offer(new int[] {ny,nx});
			}
		}

		for(int i=0; i<C; i++) {
			if(visited[R-1][i] == 1) return false;
		}

		return true;
	}

	public static void fallCluster(int y, int x) {
		int[][] visited = new int[R][C];
		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		ArrayList<int[]> cluster =  new ArrayList<int[]>();


		q.offer(new int[] {y,x});
		cluster.add(new int[] {y,x});

		visited[y][x] = 1;

		while(!q.isEmpty()) {
			int[] coord = q.poll();
			for(int i=0; i<4; i++) {
				int ny = coord[0] + dy[i];
				int nx = coord[1] + dx[i];
				if(!check(ny,nx) || visited[ny][nx] == 1 || map[ny][nx] != 'x') continue;
				visited[ny][nx] = 1;
				q.offer(new int[] {ny,nx});
				cluster.add(new int[] {ny,nx});
			}
		}

		for(int[] c : cluster) {
			map[c[0]][c[1]] = '.';
		}

		int minFall = R;
		for(int[] c : cluster) {
			int ny = c[0]+1;
			while(ny<R && map[ny][c[1]] == '.') {
			    if(visited[ny][c[1]] == 1) {
			        ny = 1000001;
			        break;
			    }
				ny++;
			}
			minFall = Math.min(minFall, ny - c[0] - 1);
		}
		

		for(int[] c : cluster) {
			map[c[0]+minFall][c[1]] = 'x';
		}



	}
}
