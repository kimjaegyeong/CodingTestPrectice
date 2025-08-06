import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[][] origin;
    static final int MAX_COUNT = 5;
    static int[] dirY = {1,-1,0,0};
    static int[] dirX = {0,0,1,-1};
    
    static int MAX = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		origin = new int[N][N];
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int j=0; j<N; j++){
		        origin[i][j] = Integer.parseInt(st.nextToken());
		    }
		}
		
		dfs(0 , copyMap(origin));
        
        System.out.println(MAX);
	}
	
	public static void dfs(int depth, int[][] map){
        if(depth >= MAX_COUNT) {
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    MAX = Math.max(map[i][j], MAX);
                }
            }
            return ; 
        }
        
        for(int i=0; i<dirY.length; i++){
            int[][] nextMap = copyMap(map);
            moveMap(dirY[i], dirX[i], nextMap);
            dfs(depth+1, nextMap);
        }
	}
	
	public static void printMap(int[][] map){
	    for(int i=0; i<N; i++){
	        System.out.println(Arrays.toString(map[i]));
	    }
	}
	
	public static int[][] copyMap(int[][] origin){
	  int[][] map = new int[origin.length][origin[0].length];
	  
	  for(int i=0; i<origin.length; i++){
	      for(int j=0; j<origin[0].length; j++){
	          map[i][j] = origin[i][j];
	      }
	  }
	  return map;
	}
	
	public static void moveMap(int dy, int dx, int[][] map){
	    
	    if(dy==0) {
	        for(int i=0; i<N; i++){
	            move(i, 0, dy,dx , map);
	        }    
	    }else{
	        for(int i=0; i<N; i++){
	            move(0,i, dy,dx, map);	            
	        }
	    }
	}
	
	public static void move(int y, int x, int dy, int dx , int[][] map){
	    if(dy ==0 ){
	        int p = dx == 1 ? 0 : N-1;
	        int idx  = p;
	        while(check(p)) {
	            if(map[y][p]==0) { p+=dx; continue;}
	            
	            int nextP = p + dx;
	            while(check(nextP) && map[y][nextP] == 0){
	                nextP += dx;
	            }
	            
	            if(check(nextP) && map[y][nextP] == map[y][p]) {
	                map[y][p] *= 2;  // 현재 블록을 2배로
	                map[y][nextP] = 0;  // 합쳐질 블록 제거
	            }
	            
	            //자리 결정 
	            map[y][idx] = map[y][p];
	            if(idx != p) {
	                map[y][p] = 0;
	            }
	            idx += dx;
	            p += dx;
	        }
	    }
	    else if( dx ==0){
	        int p = dy == 1 ? 0 : N-1;
	        int idx  = p;
	        while(check(p)) {
	            if(map[p][x]==0) { p+=dy; continue;}
	            
	            int nextP = p + dy;
	            while(check(nextP) && map[nextP][x] == 0){
	                nextP += dy;
	            }
	            
	            if(check(nextP) && map[nextP][x] == map[p][x]) {
	                map[p][x] *= 2;  // 현재 블록을 2배로
	                map[nextP][x] = 0;  // 합쳐질 블록 제거
	            }
	            
	            //자리 결정 
	            map[idx][x] = map[p][x];
	            if(idx != p) {
	                map[p][x] = 0;
	            }
	            idx += dy;
	            p += dy;
	        }
	    }
	}
	
	public static boolean check(int p){
	    if(p >= N || p<0 ) return false;
	    return true;
	}
}