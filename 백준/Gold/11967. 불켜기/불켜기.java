import java.util.*;
import java.io.*;

class Node {

	int y;
	int x;

	public Node(int x, int y) {
		this.y = y;
		this.x = x;

	}
	
	public String toString(){
	    return "x = " + x + " y = " + y;
	}

}

public class Main {
	static boolean lightOn[][];
	static int N, M;
	static ArrayList<Node>[][] map;
	static int dy[] = { 1, -1, 0, 0 };
	static int dx[] = { 0, 0, 1, -1 };
	static boolean visited[][];
	static int ans =1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new ArrayList[N][N];
		lightOn = new boolean[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			map[x][y].add(new Node(a, b));
		}

		ArrayDeque<Node> q = new ArrayDeque<>();

		lightOn[0][0] = true;
		visited[0][0] = true;

		q.offer(new Node(0,0));

		while (!q.isEmpty()) {
			Node n = q.poll();
			ArrayList<Node> light = new ArrayList<Node>();
			for(int i=0; i<map[n.x][n.y].size(); i++) {
				Node sth = map[n.x][n.y].get(i);
				if(!lightOn[sth.x][sth.y]) {
					ans++;
					lightOn[sth.x][sth.y] = true;
					light.add(new Node(sth.x, sth.y));
				}
			}

			for(int i=0; i<light.size(); i++) {
				Node node = light.get(i);
				for(int d=0; d<4; d++) {
				    int py = node.x + dy[d];
				    int px =node.y + dx[d];
					if(!check(py,px) ||! visited[py][px] ) continue;
					visited[node.x][node.y] = true;
					q.offer(node);
					break;
				}
			}



			for (int d = 0; d < 4; d++) {
				int nx = n.x + dx[d];
				int ny = n.y + dy[d];

				if (!check(nx, ny)) continue;
				if (!lightOn[nx][ny] || visited[nx][ny]) continue;

				Node next = new Node(nx, ny);
				visited[nx][ny] = true;
				q.offer(next);
			}
		}

		System.out.println(ans);
	}

	public static boolean check(int x, int y) {
		return x >= 0 && y >= 0 && x < N && y < N;
	}
}