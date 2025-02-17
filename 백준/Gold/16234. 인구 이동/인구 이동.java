import java.util.*;
import java.io.*;

class Node{
    int y;
    int x;
    
    public Node(int y, int x){
        this.y =y;
        this.x= x;

    }
}

class Union{
    int cnt;
    int sum;
    
    public Union(int cnt, int sum){
        this.cnt = cnt;
        this.sum = sum;
    }
}

public class Main
{
    static int N;
    static int L;
    static int R;
    static int cnt ;
    static int sum ; 
    static int[][] map;
    static int[][] visited;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static int result = 0;
    static boolean flag = false;
    static ArrayList<Union> union;
    static int zone = 1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++){
		     st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		while(true){
		    flag = false;
		    cnt = 0;
		    sum = 0;
		    zone =1;
		    
		    initVisited();

		    union = new ArrayList<Union>();
		    union.add(new Union(0,0)); //dummy 
    		for(int i=0; i<N; i++){
    		    for(int j=0; j<N; j++){
    		        Node n = bfs(i,j);
    		        if(n ==null){
    		            continue;
    		        }
    		        union.add(new Union(cnt ,sum));
    		        zone++;
    		        
    		    }
    		}
    		
    		move();
    	
		    if(!flag){
		        System.out.println(result);
		        return ; 
		    }    		
    		result++;

		}
	}
	
	public static void move(){
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            if(visited[i][j] <0){
	                continue;
	            }
	            int idx = visited[i][j] ;

	            map[i][j] = union.get(idx).sum / union.get(idx).cnt ;
	        }
	    }
	}
	
	public static void printMap(int[][] v){
	    System.out.println("=========");
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N; j++){
	            System.out.print(v[i][j]+ " " );
	        }
	        System.out.println();
	    }
	}
	
	public static Node bfs(int y, int x){
	    if(!check(y,x)){
	        return null;
	    }
	    Queue<Node> q = new ArrayDeque<Node>();
	    q.offer(new Node(y,x));
	    Node n = null;
        cnt = 0;
        sum = 0;

	    visited[y][x] =zone; 
	    while(!q.isEmpty()){
	        n = q.poll();
    	    cnt ++;
    	    sum += map[n.y][n.x];	        
	        for(int i=0; i<4; i++){
	            int ny = n.y + dy[i];
	            int nx = n.x + dx[i];
	            
	            if(!check(ny, nx)){
	                continue;
	            }
	            
	            if(!checkDiff(n.y, n.x, ny , nx)){
	                continue;
	            }
	            q.offer(new Node(ny,nx));
	            visited[ny][nx] = zone;
	            flag = true ;
	            
	        }
	    }
	    return n;
	    
	}
	
	public static boolean checkDiff(int y, int x , int ny, int nx){
	    int diff = Math.abs(map[y][x] - map[ny][nx]);
	    if( diff>= L && diff <= R ){
	        return true;
	    }
	    return false;
	}
	public static boolean check(int y, int x){
	    if(y >= N || x >= N || y< 0 || x <0 || visited[y][x] > -1 ){
	        return false;
	    }   
	    return true; 
	}
	
	public static void initVisited(){
	    for(int i=0; i<N; i++){
	        for(int j=0; j<N;j ++){
	            visited[i][j]  = -1;
	        }
	    }
	}
	
}
