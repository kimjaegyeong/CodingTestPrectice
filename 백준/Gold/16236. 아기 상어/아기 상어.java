import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int y;
    int x;
    int dist;

    public Node(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }

    @Override
    public int compareTo(Node n) {
        if (this.dist != n.dist) {
            return this.dist - n.dist; 
        }
        if (this.y != n.y) {
            return this.y - n.y;  
        }
        return this.x - n.x;  
    }
}
public class Main
{
    static int N;
    static int map[][];
    static boolean visited[][];
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    
    static int size = 2;
    static int eatCnt; 
    static int sy, sx;
    static boolean possibleEat = false;
    static int result; 
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        map[i][j] = Integer.parseInt(st.nextToken());
		        if(map[i][j]==9) {
		            sy = i;
		            sx = j;
		        }
		    }
		}
		//input process end 
		
		while(true){
		    PriorityQueue<Node> pq = new PriorityQueue<Node>();
		    visited = new boolean[N][N];
		    visited[sy][sx] = true;
		    map[sy][sx] = 0;
		    pq.offer(new Node(sy,sx,0));
		    possibleEat = false;
		    while(!pq.isEmpty()){
		        Node node = pq.poll();
		        if(isEat(node.y , node.x)){
		            possibleEat = true;
		            sy = node.y;
		            sx = node.x;
		            result+= node.dist;
		            break;
		        }
		        for(int i=0; i<4; i++){
		            int ny = node.y + dy[i];
		            int nx = node.x + dx[i];
		            
		            if(impossible(ny,nx)){
		                continue;
		            }
		            visited[ny][nx] = true;
//			        Thread.sleep(500);
		            pq.offer(new Node(ny,nx, node.dist + 1));
		        }
		    }
		    
		    if(!possibleEat ){
		        break;
		    }
		}
		
		System.out.println(result);
	}
	
	public static boolean impossible(int y, int x){
	    if(y < 0 || x< 0 || y>=N || x>=N || visited[y][x] || map[y][x] >size){
	        return true;
	    }
	    return false;
	}
	
	public static boolean isEat(int y, int x){
	    if((map[y][x] != 0 ) && map[y][x] < size){
	        map[y][x] = 0;
	        eatCnt ++ ;
	        sizeCheck();
	        return true;
	    }
	    return false;
	}
	
	public static void sizeCheck(){
	    if(size == eatCnt) {
	        eatCnt =0;
	        size++;
	    }
	}
}
