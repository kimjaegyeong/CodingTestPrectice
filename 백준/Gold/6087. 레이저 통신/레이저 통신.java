import java.util.*;
import java.io.*;


class Node implements Comparable<Node> {
	int y;
	int x;
	int mirrorCnt;
	int dir ;

	public Node(int y, int x,int mirrorCnt, int dir) {
		this.y=y;
		this.x=x;
		this.mirrorCnt=mirrorCnt;
		this.dir =dir;
	}
	
	public int compareTo(Node n){
	    return this.mirrorCnt - n.mirrorCnt ;
	}
}

public class Main
{
	static int R, C;
	static char map[][];
	static boolean visited[][];
	static int sy, sx;
	static int[] dy = {1,-1,0,0};
	static int[] dx = {0,0,1,-1};
	static int result =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visited = new boolean[R][C];

		for(int i=0; i<R ; i++) {
			String input = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='C') {
					sy = i;
					sx = j;
				}
			}
		}

		result = bfs(sy,sx);
		System.out.println(result);
	}

	public static int bfs(int y, int x ) {
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(y,x,0,-1));
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			visited[n.y][n.x] = true;
			if(map[n.y][n.x] =='C' && n.dir != -1) {
				return n.mirrorCnt;
			}
			for(int i=0; i<4; i++) {
				int ny = n.y + dy[i];
				int nx = n.x + dx[i];
				if(!check(ny,nx)) {
					continue;
				}
                
				if(n.dir == -1 ) {
					pq.offer(new Node(ny,nx,n.mirrorCnt,i));
				} else if(n.dir==i) {
					pq.offer(new Node(ny,nx,n.mirrorCnt,i));
				} else {
					pq.offer(new Node(ny,nx,n.mirrorCnt + 1, i)); //ny, nx l k0)m%l4 j80l!4l nl k0)m%j3< k$k%8 j2=l0
				}

			}
		}
		return -1;
	}

	public static boolean check(int y, int x) {
		if( y < 0 || x < 0 || y>=R || x>=C ) {
			return false;
		}
		if(map[y][x] == '*' || visited[y][x] ) return false;

		return true;
	}
}
