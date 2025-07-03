import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int M;
	static char[][] map;
	static int visited[][];
	static int[] p;
	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
        visited = new int[N][M];

		for(int i=0; i<N*M; i++) {
			nodes.add(new ArrayList<Integer>());
		}

		for(int i=0; i<N; i++) {
			String input = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = input.charAt(j);
			}
		}

		//input process end
        int cnt =1;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(visited[i][j]> 0 ) continue;
				search(i,j,cnt);
				cnt++;
			}
		}
		
		int len = -1;
		for(int i=0; i<N; i++){
		    for(int j=0; j<M; j++){
		       len = Math.max(len, visited[i][j]);
		    }
		}
		
		p = new int[len+1];
		
		for(int i=1; i<=len; i++){
		    p[i] = i;
		}
		
		for(int i=1; i<=len; i++){
		    ArrayList<Integer> list = nodes.get(i);
		    
		    for(int e : list){
		        union(i, e);
		    }
		}
		
		for(int i=1; i<=len; i++){
		    find(i);
		}
		
	    HashSet<Integer> set = new HashSet<Integer>();
	    
	    int ans = 0;
	    for(int i=1; i<p.length; i++){
	        if(!set.contains(p[i])) {
	            ans++;
	            set.add(p[i]);
	        }
	    }
	    
	    System.out.println(ans);
		
	}
	
	public static void union(int a, int b){
	    int pa = find(a);
	    int pb = find(b);
	    
	    if(pa == pb) return; 
	    
	    if(pa < pb) {
	        p[b] = a ;
	    }else {
	        p[a] = b;
	    }
	}
	
	public static int find(int a){
	    if(p[a] == a) return a;
	    return p[a] = find(p[a]);
	}

	public static void search(int i, int j, int cnt) {
		int dir[] = charToDir(map[i][j]);

		ArrayDeque<int[]> q = new ArrayDeque<int[]>();

		q.offer(new int[] {i,j});
		visited[i][j] = cnt;
		while(!q.isEmpty()) {
			int[] coord = q.poll();
			dir = charToDir(map[coord[0]][coord[1]]);
			int ny = coord[0] + dir[0];
			int nx = coord[1] + dir[1];

			if(ny == i && nx == j) return ;
			if(!check(ny,nx)) continue;

			if(visited[ny][nx] > 0) {
				nodes.get(visited[i][j]).add(visited[ny][nx]);
				return;
			}
			q.offer(new int[] {ny,nx});
			visited[ny][nx] = cnt;
		}
		return ;

	}


	public static boolean check(int y, int x ) {
		if(y >= N || x>=M || y<0 || x<0) return false;
		return true;
	}

	public static int[] charToDir(char c) {
		if(c == 'D') {
			return new int[] {1,0};
		} else if(c=='U') {
			return new int[] {-1,0};
		} else if(c=='R') {
			return new int[] {0,1};
		} 
			return new int[] {0,-1};
		
	}
}
