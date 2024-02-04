

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
	int x, y, cnt;
	boolean broken;

	public Node(int y, int x, int cnt, boolean broken) {
		this.y = y;
		this.x = x;
		this.cnt = cnt;
		this.broken = broken;
	}
}

public class Main {
	static int N, M;
	static int[][] map = new int[1001][1001];
	static int[][][] visit= new int[1001][1001][2];
	static int crush = 0;
	static int min = Integer.MAX_VALUE;
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		

		for (int i = 0; i < N; i++) {
			char input[] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				map[i][j] = input[j]-'0';
			}
		}
		// input process end

		// logic start
		System.out.println(check());

	}

	public static int check() {
		Deque<Node> q = new ArrayDeque<>();
		q.offer(new Node(0, 0, 0, false));

		while (!q.isEmpty()) {
			Node node = q.poll();
			if (node.y == N - 1 && node.x == M - 1) {
				return node.cnt + 1;	
			}
			for (int i = 0; i < dy.length; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				
				//벽이 부순 경우인데, 벽을 부수지 않고도 도착할 수 있는 경로라면 continue
				if(node.broken && visit[ny][nx][0]==1) {
					continue;
				}
				
				// 벽을 부수지 않았고, map이 0인 경우
				if (map[ny][nx] == 0 && visit[ny][nx][0] == 0 && !node.broken) {
					q.offer(new Node(ny, nx, node.cnt + 1, false));
					visit[ny][nx][0] = 1;
				}
				// 벽을 부쉈고, map이 0인 경우
				else if (map[ny][nx] == 0 && visit[ny][nx][1] == 0) {
					q.offer(new Node(ny, nx, node.cnt + 1, true));
					visit[ny][nx][1] = 1;
				}
				// 벽을 부수지 않았고, map이 1인 경우
				else if (map[ny][nx] == 1 && !node.broken) {
					q.offer(new Node(ny, nx, node.cnt + 1, true));
					visit[ny][nx][1] = 1;
				} 

			}

		}

		return -1;
	}
}
