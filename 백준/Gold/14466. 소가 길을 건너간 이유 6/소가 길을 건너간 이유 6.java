import java.util.*;
import java.io.*;

class Node {
	int v[] = new int[4];
}

public class Main
{
	static int N;
	static int K;
	static int R;
	static int[][] map;
	static Node path[][];
	static int visited[][];
	
	    // 위 0 오 1 아 2 왼 3 
	    
	static int[] dy = {-1,0,1,0};
	static int[] dx= {0,1,0,-1};

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		map = new int[N][N];
		path = new Node[N][N];
		visited =new int[N][N];
		
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        path[i][j] = new Node();
		    }
		}

		for(int i=0; i<R; i++) {
			st= new StringTokenizer(br.readLine());
			int r1= Integer.parseInt(st.nextToken())-1;
			int c1= Integer.parseInt(st.nextToken())-1;
			int r2= Integer.parseInt(st.nextToken())-1;
			int c2= Integer.parseInt(st.nextToken())-1;
			
			int dir1 = parseDir(r1-r2, c1-c2);
			path[r1][c1].v[dir1] = 1;
			
			int dir2 = parseDir(r2-r1, c2-c1);
			path[r2][c2].v[dir2] = 1;
		}
		
		for(int i=0; i<K; i++){
		    st = new StringTokenizer(br.readLine());
		    int y = Integer.parseInt(st.nextToken())-1;
		    int x = Integer.parseInt(st.nextToken())-1;
		    
		    map[y][x] = 1;
		}
		
		ArrayList<Integer> zone = new ArrayList<Integer>();
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        if(visited[i][j] == 1) continue;
		        
		        int cntCow= bfs(i,j);

		        if(cntCow > 0 ) {
		            zone.add(cntCow);
		        }
		        
		    }
		}
		
//  		zone.stream().forEach((i)->System.out.print(i + " "));
		
        long sum = 0;
        long sumOfSquares = 0;

        for (int num : zone) {
            sum += num;
            sumOfSquares += (long) num * num; 
        }

        long result = (sum * sum - sumOfSquares) / 2;

		System.out.println(result);
	}
	
	public static int bfs(int y, int x){
	    
	    ArrayDeque<int[]> q = new ArrayDeque<int[]>();
	    
	    q.offer(new int[]{y,x});
	    visited[y][x] = 1;
	    int cnt = 0 ;
	    while(!q.isEmpty()){

	        int[] n = q.poll();
	        //System.out.println(n[0] + " " + n[1]);
	        if(map[n[0]][n[1]]==1) cnt++;
	        for(int i=0; i<4; i++){
	           // System.out.print(n[0] + " " + n[1] + " ");
	           // System.out.println(Arrays.toString(path[n[0]][n[1]].v));
	            if(path[n[0]][n[1]].v[i] == 1) {
	                
	                continue;
	            }
                int ny= n[0] + dy[i];
                int nx = n[1] + dx[i];
                
                if(!check(ny,nx) || visited[ny][nx] == 1 ) continue;
                // System.out.println(ny + " " + nx + " " + n[0] + " " + n[1] );
                q.offer(new int[]{ny,nx});
                visited[ny][nx] = 1;
	        }
	    }
	    
	    return cnt;
	    
	}
	
	public static boolean check(int y, int x){
	    return x<N && y<N && x>=0 && y>=0;
	}
    
    // 0 1 -> 왼쪽 0 -1 -> 오른쪽 1 0 -> 위쪽  -1 0 ->아래쪽 
	public static int parseDir(int y, int x) {
        if(y==0) {
            if(x == 1) {
                return 3; 
            }else {
                return 1;
            }
        }else if(x == 0) {
            if(y == 1) return 0;
            else return 2;
        }
        
        return -1;
	}
}
