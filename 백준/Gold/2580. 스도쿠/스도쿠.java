import java.util.*;
import java.io.*;
public class Main
{
	static int N = 9;
	static boolean flag = false;
	static int cnt =0;
	static int[][] map = new int[N][N];
	static int[][][] available = new int[N+1][N][N]; // 1-> already , 0 -> available
	static ArrayList<int[]> zero = new ArrayList<int[]>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==0) {
					zero.add(new int[] {i,j});
				}

			}
		}

		dfs(0);

		System.out.println(sb);

	}

	public static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(map[i][j]).append(" ");
			}
			sb.append("\n");
		}
	}

	public static void dfs(int depth) {
		if(depth == zero.size() || flag) {
			printMap();
			flag = true;
			return;
		}


		int[] now = zero.get(depth);
		int y=  now[0];
		int x = now[1];
		
		for(int i=1; i<N+1; i++){
		    available[i][y][x] = 0;
		}
		
		check(y,x);
// 		System.out.println("available = " );
// 		for(int i=1; i<N+1; i++){
// 		    System.out.print( available[i][y][x] + " ");
// 		}
        
        
		for(int i=1; i<N+1; i++) {
			if(available[i][y][x] ==0 && !flag) {
				map[y][x] = i;
				dfs(depth+1);

			}
			map[y][x] = 0;
		}


	}


	public static void check(int y, int x) {

		for(int i=0; i< N; i++) {

			if(map[y][i] != 0) {
				available[map[y][i]][y][x] = 1;

			}
		}

		for(int i=0; i<N; i++) {
			if(map[i][x] != 0) {
				available[map[i][x]][y][x] = 1;
			}
		}


		int sy =  3 * (y/3);
		int sx = 3 * (x/3);
		for(int i= sy; i < sy + 3 ; i++) {
			for(int j= sx; j< sx + 3; j++) {
				if(map[i][j] != 0) {
					available[map[i][j]][y][x] = 1;
				}
			}
		}

// 		for(int i=1; i<N+1; i++) {
// 			sb.append(available[i][y][x] + " ");
// 		}
// 		sb.append("\n");


	}
}
