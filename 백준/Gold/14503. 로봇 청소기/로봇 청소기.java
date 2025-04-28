import java.util.*;
import java.io.*;


class Robot {
	int y;
	int x;
	int d;
	int num;
	int N;
	int M;
	int[][] dDir = { {-1,0}, {0,1}, {1,0}, {0,-1} };
	int[][] map;
	int[][] visited;
	public Robot(int y,int x,int d, int[][] map) {
		this.y = y;
		this.x = x;
		this.d = d;
		this.map = map;
		N = map.length;
		M = map[0].length;
		visited = new int[N][M];
	}

	public void rotate() {
		d=(d+3)%4;

	}

	public boolean goStraight() {

		int dy =  y + dDir[d][0];
		int dx = x + dDir[d][1];

		//k2ll24m,
		if(check(dy,dx)) {
			this.y = dy;
			this.x = dx;
			return true;
		}
		return false;
	}

public boolean backup() {
    int backDir = (d + 2) % 4; // 현재 방향의 반대 방향
    int dy = y + dDir[backDir][0];
    int dx = x + dDir[backDir][1];

    if (check(dy, dx)) {
        y = dy;
        x = dx;
        return true;
    }
    return false;
}

	public void cleanUp() {
		if(map[y][x] ==0 && visited[y][x] ==0 ) num++;
		visited[y][x] = 1;

	}

	public boolean check(int y, int x) {
		if(map[y][x] == 1) {
			return false;
		}
		return true;
	}

	public boolean dirtyCheck() {
		int dy = y+ dDir[d][0];
		int dx = x + dDir[d][1];
		if(check( dy, dx )) {
			if(visited[dy][dx] == 0 ) return true;
		}
		return false;

	}

	public boolean isDirty() {
		int[] dy = {0,0,-1,1};
		int[] dx = {1,-1,0,0};
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(visited[ny][nx] == 0 && map[ny][nx] == 0 ) {
				return true;
			}
		}

		return false;
	}


}


public class Main
{
	static int N;
	static int M;
	static int map[][];
	static int num;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());

		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j]  = Integer.parseInt(st.nextToken());
			}
		}
		Robot robot = new Robot(y,x,d, map);
		while(true) {
			robot.cleanUp();
			if(robot.isDirty()) {
				for(int i=0; i<4; i++) {
					robot.rotate();
					if(robot.dirtyCheck()) {
						robot.goStraight();
						break;
					}

				}
			} else {
				// if check all rooms, don't search dirty room

				if(!robot.backup()) {
					System.out.println(robot.num);
					return;
				}

			}


		}

	}
}
