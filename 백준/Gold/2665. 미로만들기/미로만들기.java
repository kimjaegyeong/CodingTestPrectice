import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int y;
	int x;
	int room;

	public Node(int y, int x, int room) {
		this.y= y;
		this.x= x;
		this.room = room;
	}

	public int compareTo(Node n) {
		return this.room - n.room ;
	}
}

public class Main
{
	static int N;
	static int[][] map;
	static int[][] visited;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
    static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new int[N][N];
		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = ((int) input.charAt(j)) - 48 ;
                visited[i][j] = 100001;
			}
		}

		int result = bfs();
		System.out.println(result);
	}

	public static int bfs() {

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(0,0,0));
		visited[0][0] = 0;

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			cnt++;
			if(n.y == N-1 && n.x ==N-1 ) {
				return n.room;
			}

			for(int i=0; i<4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];

				if(!check(ny,nx)) {
					continue;
				}

				if(map[ny][nx] == 1) {

					if(visited[ny][nx] == 100001) { //first visited
						pq.offer(new Node(ny,nx, n.room ));
						visited[ny][nx] = n.room;

						continue;
					}

					if(visited[ny][nx] <=visited[n.y][n.x] ) {
						continue;
					}

					pq.offer(new Node(ny,nx, n.room ));
					visited[ny][nx] = n.room;


				} else {
					if(visited[ny][nx] == 100001) { //first visited
						pq.offer(new Node(ny,nx, n.room + 1));
						visited[ny][nx] = n.room + 1;
						continue;
					}

					if(visited[ny][nx]  <=visited[n.y][n.x] + 1 ) {
						continue;
					}
					pq.offer(new Node(ny, nx, n.room + 1));
					visited[ny][nx] = n.room + 1;
				}
			}
		}
		return 0;
	}

	public static boolean check(int y, int x) {
		if(y >= N || x>=N || y<0 || x<0  ) {
			return false;
		}
		return true;
	}
}
