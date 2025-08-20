import java.util.*;
import java.io.*;

class Node{
    int y;
    int x;
    
    public Node(int y, int x){
        this.y=y;
        this.x=x;
        
    }
}

public class Main
{
    static int N;
    static int M;
    
    static int[][] map;
    static int[][] visited;
    static int[][] cloud; 
    
    static int d;
    static int s;
    
    static int[] dy = {0,-1,-1,-1,0,1,1,1};
    static int[] dx = {-1,-1,0,1,1,1,0,-1};
    
    static ArrayDeque<Node> queue = new ArrayDeque<Node>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new int[N][N];
		cloud = new int[N][N];
		
		for(int i=0; i<N; i++){
		    st= new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		
		queue.offer(new Node(N-1,0));
		queue.offer(new Node(N-1,1));
		queue.offer(new Node(N-2,0));
		queue.offer(new Node(N-2,1));
		for(int i=0; i<M; i++){
		    st= new StringTokenizer(br.readLine());
		    int d = Integer.parseInt(st.nextToken())-1;
		    int s = Integer.parseInt(st.nextToken());
		    
		    simul(d,s);
		}
		
		int ans = 0;
		for(int i=0; i<N; i++){
		    for(int j=0; j<N; j++){
		        ans+= map[i][j];
		    }
		}
		
		System.out.println(ans);
	}
	
	public static void simul(int d, int s){
	    visited = new int[N][N];
	    cloud= new int[N][N];
	    while(!queue.isEmpty()){
	        Node n = queue.poll();

	        int ny = nextXY(dy[d] , s, n.y);
	        int nx = nextXY(dx[d], s, n.x);
	        map[ny][nx]++;
	        visited[ny][nx] = 1;
	    }
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            int cnt = 0;
	            if(visited[i][j] == 1){
	                for(int di=1; di<8; di+=2){
	                    int ny = i + dy[di];
	                    int nx = j + dx[di];
	                    
	                    if(!check(ny,nx)) continue;
	                    if(map[ny][nx] > 0) cnt++; 
	                }
	                
	                map[i][j]+=cnt;
	            }
	        }
	    }
	    
	    
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            if(map[i][j] >= 2 && visited[i][j] == 0){
	                map[i][j]-=2;
	                queue.offer(new Node(i,j));
	                
	            }
	        }
	    }
	    
	}
	
	public static void  printMap(){
	    for(int i=0; i<N; i++){
	        System.out.println(Arrays.toString(map[i]));
	    }
	    System.out.println("===============");
	}
	public static boolean check(int y, int x){
	    return y<N && x<N && y>=0 && x>=0;
	    
	}
	
	public static int nextXY(int d, int s, int coord){
	    if(coord + d * s >= N ) {
	        return (coord+d*s) % N;
	    }
		//System.out.println(5 +( -9 % 5));
	    else if( coord + d * s < 0) {
	        return ((coord + d * s) % N + N) % N;
	    }
	    return coord + d * s;
	}
}
