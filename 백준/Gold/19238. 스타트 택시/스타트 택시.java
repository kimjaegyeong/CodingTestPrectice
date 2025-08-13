import java.util.*;
import java.io.*;

class Passenger {
	int sy;
	int sx;
	int ey;
	int ex;

	public Passenger(int sy,int sx, int ey, int ex) {
		this.sy=sy;
		this.sx=sx;
		this.ey=ey;
		this.ex=ex;
	}
}

class Node implements Comparable<Node> {
	int y;
	int x;
	int fuel;

	public Node(int y, int x, int fuel) {
		this.y=y;
		this.x=x;
		this.fuel= fuel;

	}

	public int compareTo(Node n ) {
		return n.fuel - this.fuel == 0 ? this.y - n.y ==0 ? this.x - n.x : this.y- n.y : n.fuel - this.fuel;
	}
}

public class Main
{
	static int N;
	static int M;

	static int[][] map;
	static int fuel;
	static int[] dy= {1,-1,0,0};
	static int[] dx= {0,0,1,-1};

	static boolean visited[][];
	static ArrayList<Passenger> pList = new ArrayList<Passenger>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		fuel = Integer.parseInt(st.nextToken());

		map  =new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int sy =0 ;
		int sx =0;

		st = new StringTokenizer(br.readLine());
		sy= Integer.parseInt(st.nextToken()) -1;
		sx= Integer.parseInt(st.nextToken()) -1;

		int cnt= 2;

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int y1= Integer.parseInt(st.nextToken()) -1;
			int x1= Integer.parseInt(st.nextToken()) -1;
			int y2= Integer.parseInt(st.nextToken()) -1;
			int x2= Integer.parseInt(st.nextToken()) -1;

			Passenger p = new Passenger(y1,x1,y2,x2);
			pList.add(p);
			map[y1][x1] = cnt++;
		}

		//input process end

		while(true) {
			visited = new boolean[N][N];
			Passenger pResult = searchPassenger(sy,sx,fuel);

			if(pResult.sy == -1) break;

			visited = new boolean[N][N];
			Node n = driveTaxi(pResult);
			if(n.y == -1) break;
			sy = n.y;
			sx= n.x;
			int temp = (fuel - n.fuel) * 2;
			fuel = temp + n.fuel;
			map[pResult.sy][pResult.sx] = 0;
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] >= 2) {
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(fuel);
	}

	public static Passenger searchPassenger(int sy, int sx, int fuel) {

		if(map[sy][sx] >= 2) {
			Main.fuel = fuel; 
			return pList.get(map[sy][sx] - 2);
		}

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(sy, sx, fuel));
		visited[sy][sx] = true;

		Passenger bestPassenger = null;
		int bestFuelUsed = Integer.MAX_VALUE;

		while(!pq.isEmpty()) {
			Node n = pq.poll();

			int currentFuelUsed = fuel - n.fuel;
			if (currentFuelUsed > bestFuelUsed) {
				break;
			}

			if(n.fuel == 0) continue;

			for(int i = 0; i < dy.length; i++) {
				int ny = dy[i] + n.y;
				int nx = dx[i] + n.x;
				if(!check(ny, nx) || map[ny][nx] == 1 || visited[ny][nx]) continue;

				if(map[ny][nx] >= 2) {
					int fuelUsedToReach = fuel - (n.fuel - 1);

					if (fuelUsedToReach < bestFuelUsed ||
					        (fuelUsedToReach == bestFuelUsed &&
					         (bestPassenger == null || ny < bestPassenger.sy ||
					          (ny == bestPassenger.sy && nx < bestPassenger.sx)))) {

						bestPassenger = pList.get(map[ny][nx] - 2);
						bestFuelUsed = fuelUsedToReach;
					}
					continue;
				}

				pq.offer(new Node(ny, nx, n.fuel - 1));
				visited[ny][nx] = true;
			}
		}

		if (bestPassenger != null) {
			Main.fuel = fuel - bestFuelUsed;
			return bestPassenger;
		}

		return new Passenger(-1, -1, -1, -1);
	}

	public static Node driveTaxi(Passenger p) {
		int ey = p.ey;
		int ex = p.ex;

		if(p.sy == p.ey && p.sx == p.ex) {
			return new Node(p.sy, p.sx, fuel); 
		}

		Node sn = new Node(p.sy, p.sx, fuel);

		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(sn);
		visited[sn.y][sn.x] = true;

		while(!pq.isEmpty()) {
			Node n = pq.poll();
			if(n.y == ey && n.x == ex) return n;
			if(n.fuel == 0 ) continue;

			for(int i=0; i<dy.length; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];

				if(!check(ny,nx) || map[ny][nx] == 1 || visited[ny][nx])  continue;

				pq.offer(new Node(ny,nx, n.fuel- 1));
				visited[ny][nx] = true;
			}
		}

		return new Node(-1,-1,-1);
	}

	public static boolean check(int y, int x) {
		return y< N && x<N && y>=0 && x>=0;
	}
}
