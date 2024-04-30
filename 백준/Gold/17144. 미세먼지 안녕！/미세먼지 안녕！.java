
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	static class Node{
		int y,x,value;
		public Node(int y, int x, int value) {
			this.y=y;
			this.x=x;
			this.value=value;
		}
	}
	static int R,C,T;
	static int[][] map;
	static int[] airCleanerX;
	static int[] airCleanerY;
	static int result;

	static Queue<Node> q = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		airCleanerX = new int[2];
		airCleanerY = new int[2];
		int cleaner_cnt=0;
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) {
					airCleanerX[cleaner_cnt]= j;
					airCleanerY[cleaner_cnt]= i;
					cleaner_cnt++;
				}
			}
		}
		for(int i=0; i<T; i++) {
			add();
			map=spread();
			AC1();
			AC2();

		}
//		for(int i=0; i<R; i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					result+=map[i][j];
				}
			}
		}
		
		System.out.println(result);
	}
	
	static public void add() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j]>0) {
					q.offer(new Node(i,j,map[i][j]));
				}
			}
		}
	}
	static int[][] spread() {
		int tempMap[][] = new int[R][C];
		int[] dy = {1,-1,0,0};
		int[] dx = {0,0,1,-1};
		
		// tempMap 초기화
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				tempMap[i][j] = 0;
			}
		}
		// 먼지확산 (map -> tempMap) <= 먼지확산의 결과가 tempMap
		for (int y = 0; y < R; y++) {
			for (int x = 0; x < C; x++) {
				tempMap[y][x] += map[y][x]; // = 은 이전 단계의 확산의 결과로 y,x 좌표에 값이 있을 수 있는 데 이를 무시
				// 5 미만 확산 X
				if (map[y][x] < 5)
					continue;
				// 확산 양 계산
				int spreadCnt = map[y][x] / 5;

				// 4군데 확산
				for (int d = 0; d < 4; d++) {
					int ny = y + dy[d];
					int nx = x + dx[d];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || map[ny][nx] == -1)
						continue;

					tempMap[y][x] -= spreadCnt;
					tempMap[ny][nx] += spreadCnt;
				}
			}
		}
		return tempMap;
	}
	
	static public void AC1() {
		Queue<Integer> q = new ArrayDeque<>();
		int n = airCleanerY[0];
		int m = C;
		int nxtY = airCleanerY[0];
		int nxtX = 0;
		int dy = 0;
		int dx = 1;
		int cnt = 0;
		q.offer(0);
		while (true) {
			nxtX = nxtX + dx;
			nxtY = nxtY + dy;
			if (nxtX == m-1  && nxtY == n) {
				dx = 0;
				dy = -1;
			} else if (nxtY == 0 && nxtX == m-1) {
				dy = 0;
				dx = -1;
			} else if (nxtX == 0 && nxtY == 0) {
				dy = 1;
				dx = 0;
			}
			q.offer(map[nxtY][nxtX]);
			map[nxtY][nxtX] = q.poll();
			if (nxtX == 0 && nxtY == n && cnt != 0) {
				map[nxtY][nxtX]=-1;
				break;
			}
			cnt++;
		}
	}
	
	static public void AC2() {
		Queue<Integer> q = new ArrayDeque<>();
		int n = airCleanerY[1];
		int m = C;
		int nxtY = airCleanerY[1];
		int nxtX = 0;
		int dy = 0;
		int dx = 1;
		int cnt = 0;
		q.offer(0);
		while (true) {
			nxtX = nxtX + dx;
			nxtY = nxtY + dy;
			if (nxtX == 0  && nxtY == R-1) {
				dx = 0;
				dy = -1;
			} else if (nxtY == R-1 && nxtX == m-1 ) {
				dy = 0;
				dx = -1;
			} else if (nxtX == m-1 && nxtY == n) {
				dy = 1;
				dx = 0;
			}
			q.offer(map[nxtY][nxtX]);
			map[nxtY][nxtX] = q.poll();
			if (nxtX == 0 && nxtY == n && cnt != 0) {
				map[nxtY][nxtX]=-1;
				break;
			}
			cnt++;
		}
	}
}
