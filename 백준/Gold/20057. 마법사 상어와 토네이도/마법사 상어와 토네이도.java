import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int[][] map;

	static int[] dy = {0,1,0,-1};
	static int[] dx = {-1,0,1,0};

	static int ans =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map =new int[N][N];


		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		spin(N/2,N/2);

// 		printMap();
		System.out.println(ans);
	}

	public static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();

		}
		System.out.println("============");

	}

	public static void spin(int y, int x) {
		int moveCnt = 1;
		int ny = y;
		int nx= x;
		while(true) {

			for(int i=0; i<4; i++) {
				for(int j=0; j<moveCnt; j++) {
					ny = ny+ dy[i];
					nx = nx+ dx[i];

					if(!check(ny,nx)) return;
					if(map[ny][nx] != 0 ) {
						spread(ny,nx,i);

				// 		printMap();
					}
				}
				if(i%2 == 1) moveCnt++;
			}
		}
	}

	public static void spread(int y, int x, int d) {
		int sand = map[y][x];
        int scattered = sand * 1/100 * 2 + sand * 7/100 * 2 + sand * 2/100 * 2 + sand * 10/100 * 2 + sand * 5/100;
        int total = sand - scattered; 
		if(d %2 == 1) { // dy
			addSand(y,x, y-dy[d],x-1,1);
			addSand(y,x, y-dy[d],x+1,1);
			addSand(y,x,y,x-1, 7);
			addSand(y,x,y,x+1, 7);
			addSand(y,x,y,x-2, 2);
			addSand(y,x,y,x+2, 2);
			addSand(y,x,y+dy[d],x-1, 10);
			addSand(y,x,y+dy[d],x+1, 10);
			addSand(y,x,y+dy[d]*2,x, 5);
			// alpha
			if(!check(y+dy[d],x)) {
				Main.ans+= total;
			} else {
				map[y+dy[d]][x] +=total;
			}

		} else { //dx
			addSand(y,x,y+1,x-dx[d], 1);
			addSand(y,x,y-1,x-dx[d], 1);
			addSand(y,x,y+1,x, 7);
			addSand(y,x,y-1,x, 7);
			addSand(y,x,y+2,x, 2);
			addSand(y,x,y-2,x, 2);
			addSand(y,x,y-1,x+dx[d], 10);
			addSand(y,x,y+1,x+dx[d], 10);
			addSand(y,x,y,x+dx[d]*2, 5);
			//alpha
			if(!check(y, x+dx[d])) {
				Main.ans+=total;
			} else {
				map[y][x+dx[d]] += total;
			}

		}

		map[y][x] = 0;
	}

	public static void addSand(int y, int x, int ny, int nx, int per) {
		if(!check(ny,nx)) {
			Main.ans+= map[y][x] * per /100;
		} else {

			map[ny][nx] += map[y][x] * per /100;
		}
	}

	public static boolean check(int y, int x) {
		return y<N && x<N && y>=0 && x>=0 ;
	}
}
