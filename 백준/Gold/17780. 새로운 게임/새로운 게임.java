import java.util.*;
import java.io.*;

class Node {
	int idx;
	int d;

	public Node(int idx, int d) {
		this.idx= idx;
		this.d= d;

	}

}

class Area {
	int color;
	ArrayList<Node> nodes = new ArrayList<>();

	public Area(int color) {
		this.color = color;
	}

	public ArrayList<Node> cutFrom(int idx) {
		ArrayList<Node> cut = new ArrayList<>();
		int pos = -1;
		for (int i = 0; i < nodes.size(); i++) {
			if (nodes.get(i).idx == idx) {
				pos = i;
				break;
			}
		}
		if (pos != -1) {
			for (int i = pos; i < nodes.size(); i++) {
				cut.add(nodes.get(i));
			}
			for (int i = nodes.size() - 1; i >= pos; i--) {
				nodes.remove(i);
			}
		}
		return cut;
	}

	public void merge(ArrayList<Node> ns) {
		nodes.addAll(ns);
	}

	public boolean empty() {
		return nodes.size() == 0;
	}

	public Node getBottom() {
		return nodes.get(0);
	}
}


public class Main
{
	static int dy[] = {0,0,-1,1};
	static int dx[] = {1,-1,0,0};
	static int N;
	static int K;
	static Area[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map = new Area[N][N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				int c = Integer.parseInt(st.nextToken());
				map[i][j] = new Area(c);
			}
		}

		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int y = Integer.parseInt(st.nextToken()) -1;
			int x=  Integer.parseInt(st.nextToken()) -1;
			int d= Integer.parseInt(st.nextToken()) - 1;
			map[y][x].nodes.add(new Node(i,d));
		}

		simul();



	}

	public static void simul() {
	for (int t = 1; t <= 1000; t++) {
		for (int i = 0; i < K; i++) {
			int[] coord = search(i);
			if (coord[0] == -1) continue;

			int y = coord[0], x = coord[1];
			Area from = map[y][x];

			if (from.getBottom().idx != i) continue;

			Node bottom = from.getBottom();
			int dir = bottom.d;
			int ny = y + dy[dir];
			int nx = x + dx[dir];

			if (!check(ny, nx) || map[ny][nx].color == 2) {
				changeDir(bottom);
				dir = bottom.d;
				ny = y + dy[dir];
				nx = x + dx[dir];

				if (!check(ny, nx) || map[ny][nx].color == 2) continue;
			}

			ArrayList<Node> moving = from.cutFrom(i);

			if (map[ny][nx].color == 1) {
				Collections.reverse(moving);
			}

			map[ny][nx].merge(moving);

			if (checkEnd(ny, nx)) {
				System.out.println(t);
				return;
			}
		}
	}
	System.out.println(-1);
}

	public static boolean checkEnd(int y, int x) {
		if(map[y][x].nodes.size() >= 4) return true;
		return false;
	}

	public static void changeDir(Node n) {
		if(n.d == 0) {
			n.d = 1;
		} else if(n.d ==1) {
			n.d = 0;
		} else if(n.d == 2) {
			n.d = 3;
		} else if(n.d ==3) {
			n.d =2;
		}

	}

	public static int nextArea(int y, int x, int d) {
		int ny = y + dy[d];
		int nx= x + dx[d];

		if(!check(ny,nx)) return -1;

		return map[ny][nx].color;
	}

	public static int[] search(int idx) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].empty()) continue;
				if(map[i][j].getBottom().idx == idx) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {-1,-1};
	}

	public static boolean check(int y,int x) {
		if(y >= N || x>=N || y<0 || x<0 ) return false;
		return true;
	}
}
