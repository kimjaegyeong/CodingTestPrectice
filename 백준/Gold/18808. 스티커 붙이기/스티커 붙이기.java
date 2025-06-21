import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static int M;
	public static int K;
	public static int ans;
	public static int[][] map;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new int[N][M];

		for(int k = 0; k < K; k++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int[][] sticker = new int[y][x];

			for(int i = 0; i < y; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < x; j++) {
					sticker[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			stick(sticker);
		}

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(map[i][j] == 1) ans++;
			}
		}

		System.out.println(ans);
	}

	public static int[][] spin(int y, int x, int[][] s) {
		int[][] copy = new int[x][y];

		for(int i = 0; i < y; i++) {
			for(int j = 0; j < x; j++) {
				copy[j][(y-1)-i] = s[i][j];
			}
		}

		return copy;
	}


	public static void stick(int[][] s) {
		for(int r = 0; r < 4; r++) {
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < M; j++) {

					if(!check(i, j, s)) continue;

					int maxX = j + (s[0].length);
					int maxY = i + (s.length);

					for(int y = i; y < maxY; y++) {
						for(int x = j; x < maxX; x++) {
							if(s[y-i][x-j] == 1) map[y][x] = s[y-i][x-j];
						}
					}

					return;
				}
			}
			s = spin(s.length, s[0].length, s);
		}
	}


	public static boolean check(int y, int x, int[][] s) {

		int maxX = x + (s[0].length);
		int maxY = y + (s.length);

		if(maxX > M || maxY > N) return false;

		for(int i = y; i < maxY; i++) {
			for(int j = x; j < maxX; j++) {
				if(map[i][j] != 0 && s[i-y][j-x] == 1) return false;
			}
		}

		return true;
	}

}