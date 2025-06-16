import java.util.*;
import java.io.*;

class Coord {
	int y;
	int x;

	public Coord(int y, int x) {
		this.y=y;
		this.x=x;
	}

	public String toString() {
		return "y: " + y + ",x: " + x ;
	}
}

class Island {
	ArrayList<Coord> coord = new ArrayList<Coord>();

	public Island(ArrayList<Coord> coord) {
		this.coord = coord;
	}
}

class Node implements Comparable<Node> {
	int n;
	int c;

	public Node(int n, int c) {
		this.n = n;
		this.c= c;

	}

	public int compareTo(Node node) {
		return this.c - node.c;
	}

	public String toString() {

		return "{" + n + " " + c + " }";
	}
}

public class Main
{

	static int N;
	static int M;
	static int map[][];
	static int dp[];
	static int ans = 10000001;
	static int visited[][];
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};

	static ArrayList<Island> island = new ArrayList<Island>();
	static ArrayList<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[N][M];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		island.add(null); // add dummy  for 1-base idx
		createIsland(); // island start num is 1 , but arrayList based 0-idx. so, island size is many 1 then actually size .

		for(int i=0; i<island.size(); i++) {
			nodes.add(new ArrayList<Node>());
		}

		for(int i=1; i<=island.size()-1; i++) {
			createConnect(i);
		}
        
        ans = getMSTCost();
        
        System.out.println(ans);
	}

	public static int getMSTCost() {
		int islandCount = island.size() - 1;
		boolean[] visitedIsland = new boolean[islandCount + 1];
		PriorityQueue<Node> pq = new PriorityQueue<>();

		visitedIsland[1] = true;
		pq.addAll(nodes.get(1));

		int totalCost = 0;
		int connected = 1;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();

			if (visitedIsland[cur.n]) continue;

			visitedIsland[cur.n] = true;
			totalCost += cur.c;
			connected++;

			for (Node next : nodes.get(cur.n)) {
				if (!visitedIsland[next.n]) {
					pq.offer(next);
				}
			}
		}


		if (connected == islandCount) {
			return totalCost;
		} else {
			return -1;
		}
	}


	public static void createConnect(int idx) {
		PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> Integer.compare(a[1], b[1]));
		int[] v=  new int[island.size()];
		Arrays.fill(v,10000001);
		int[][] dp = new int[island.size()][island.size()];
		for(int i=0; i<island.size(); i++) {
			Arrays.fill(dp[i], 10000001);
		}
		for(int i=0; i<island.get(idx).coord.size(); i++) {
			Coord c = island.get(idx).coord.get(i);

			for(int d=0; d<4; d++) {
				int ny = c.y+dy[d];
				int nx = c.x+dx[d];
				int cnt =0;
				while(!(ny >= N || nx >= M || ny< 0 || nx <0 || visited[ny][nx] == idx )) { // if next position is same island, can't go ahead.
					if(visited[ny][nx] != 0 && visited[ny][nx] != idx ) {
						if(cnt < 2) break;
						if(dp[idx][visited[ny][nx]] > cnt) {
							pq.offer(new int[] {visited[ny][nx], cnt});
							dp[idx][visited[ny][nx]] = cnt;
						}

						break;
					}
					ny+= dy[d];
					nx+=dx[d];
					cnt++;
				}
			}
		}
		if(pq.isEmpty()) return ;

		while(!pq.isEmpty()) {
			int[] node = pq.poll();
			v[node[0]] = Math.min(v[node[0]], node[1]);
		}

		for(int i=1; i<v.length; i++) {
			if(v[i] == 10000001) continue;
			nodes.get(idx).add(new Node(i,v[i]));
		}

		return ;


	}

	public static void createIsland() {
		int cnt =1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					ArrayList<Coord> list = bfs(i,j, cnt); //search Island
					island.add(new Island(list)); // add Island
					cnt++;
				}
			}
		}
	}

	public static ArrayList<Coord> bfs(int y, int x, int cnt) {
		ArrayDeque<int[]> q=  new ArrayDeque<int[]>();
		q.offer(new int[] {y,x});
		ArrayList<Coord> list = new ArrayList<Coord>();
		visited[y][x] = cnt;

		while(!q.isEmpty()) {
			int[] yx= q.poll();
			saveOutline(yx[0],yx[1], list);

			for(int i=0; i<4; i++) {
				int ny = yx[0] + dy[i];
				int nx = yx[1] + dx[i];

				if(!check(ny,nx)) continue;
				if(map[ny][nx] == 0) continue;
				q.offer(new int[] {ny,nx});
				visited[ny][nx] = cnt;
			}
		}

		return list;

	}

	public static void saveOutline(int y, int x, ArrayList<Coord> list) {
		if(isOutline(y,x)) {
			Coord c = new Coord(y,x);
			list.add(c);
		}
	}

	public static boolean isOutline(int y, int x) {
		for(int i=0; i<4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(check(ny, nx) && map[ny][nx] == 0) {
				return true;
			}
		}

		return false;
	}


	public static boolean check(int y, int x) {
		if(y >= N || x >= M || y< 0 || x <0 || visited[y][x] != 0) return false;
		return true;
	}

	public static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
	}

}
