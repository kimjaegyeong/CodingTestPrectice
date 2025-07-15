import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int[][] map;
	static int[][] visited;
	static int num = 1;
	static int max;
	static int sumMax;
	static int[] dy = {1,0,-1,0};
	static int[] dx=  {0,1,0,-1};

	static ArrayList<Integer> areaList = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];

		areaList.add(-1); // dummy, area num is 1-based

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] != 0 ) continue;
				visited[i][j] = num;
				bfs(i,j);
				num++;
			}
		}

		sumArea();

		System.out.println(num-1);
		System.out.println(max);
		System.out.println(sumMax);

	}

	public static void sumArea() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				String dir = Integer.toBinaryString(map[i][j]);

				int len = dir.length();
				for(int c=0; c< 4- len; c++) {
					dir = "0" + dir;
				}

				for(int d=0; d<dir.length(); d++) {
					if(dir.charAt(d) - 48 == 0) continue;
					int ny = i + dy[d];
					int nx = j + dx[d];

					if(ny >= N ||nx>=M || ny<0 || nx<0) continue;
                    if(visited[i][j] == visited[ny][nx]) continue;
					int sum = areaList.get(visited[i][j]) + areaList.get(visited[ny][nx]);

					sumMax = Math.max(sum, sumMax);
				}
			}
		}
	}

	public static void printMap() {
		System.out.println("-------------------");
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j]+ " " );
			}
			System.out.println();
		}
	}

	public static void bfs(int y, int x) {
		int cnt =1;

		ArrayDeque<int[]> q = new ArrayDeque<int[]>();
		q.offer(new int[] {y,x});

		while(!q.isEmpty()) {
			int[] now = q.poll();

			String dir = Integer.toBinaryString(map[now[0]][now[1]]);

			int len = dir.length();
			for(int i=0; i< 4- len; i++) {

				dir = "0" + dir;
			}

			for(int i=0; i<dir.length(); i++) {

				if(dir.charAt(i) - 48 == 1) continue;

				int ny = now[0] + dy[i];
				int nx = now[1] + dx[i];

				if(!check(ny,nx)) continue;

				q.offer(new int[] {ny,nx});
				visited[ny][nx] = num;
				cnt++;
			}
		}
		max = Math.max(cnt, max);
		areaList.add(cnt);
	}

	public static boolean check(int y, int x) {
		if(y >= N || x>=M || y<0 || x<0 || visited[y][x] != 0) return false;
		return true;
	}
}
