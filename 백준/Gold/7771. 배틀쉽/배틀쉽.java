import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[][] map;
	static int y, x;
	static char[][] answer;
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int[] ship = { 4, 3, 2, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new int[10][10];
		answer = new char[10][10];
		
		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				answer[i][j]='.';
				
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 100) {
					y = i;
					x = j;
				}
			}
		}
		answer[y][x] = '#';
		ship[0]--;
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				int cnt = 0;
				if(answer[i][j]=='#') continue;
				while (true) {
					if(cnt==4) {
						break;
					}
					int ny = i;
					int nx = j + cnt;

					if(nx>=10 || nx<0) {
							break;
					}
					if (check(ny, nx)) { // 해당 좌표 주변 8방향에 전함이 없다면 전함을 놓을 수 있음
						//전함 작은 것 부터 놓기...
						if(ship[cnt]>0) {
							setShip(i,j,cnt);
							ship[cnt]--;
							break;
						}
						cnt++;
					}else {
						//System.out.println(ny+ " " + nx);
						break;
					}
				}
			}
		}
//		System.out.println(Arrays.deepToString(answer).replace("],","]\n"));
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				System.out.print(answer[i][j]);
			}
			System.out.println();
		}
	}
	
	static void setShip(int y, int x, int cnt) {
		for(int d=0; d<=cnt; d++) {
			int nx = x + d;
			answer[y][nx] = '#';
		}
	}

	static boolean check(int y, int x) {
		for (int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if (ny >= 10 || nx >= 10 || nx < 0 || ny < 0) {
				continue;
			}
			if (answer[ny][nx] == '#') {
				return false;
			}
		}
		return true;
	}

}
