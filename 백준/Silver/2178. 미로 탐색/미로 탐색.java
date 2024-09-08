
import java.util.*;
import java.io.*;
public class Main
{
    static int N,M; 
    static int[][] map;
    static int[][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String inputs[] = br.readLine().split(" ");
	    N = Integer.parseInt(inputs[0]);
	    M = Integer.parseInt(inputs[1]);
	    map = new int[N][M];
	    visited = new int[N][M];
	    Queue<int[]> queue = new ArrayDeque<int[]>();
	    for(int i=0; i<N; i++){
	        inputs = br.readLine().split("");
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(inputs[j]);
	        }
	    }
	    
	    queue.add(new int[]{0,0});
	    visited[0][0] = 1;
	    while(!queue.isEmpty()){
	        int[] node = queue.poll();
	        for(int i=0; i<4; i++){
	            int ny = dy[i] + node[0];
	            int nx= dx[i] + node[1];
	            
	            if(ny < 0 || nx < 0 || ny>=N|| nx>=M || visited[ny][nx] > 0 || map[ny][nx] ==0){
	                continue; 
	            }
	            queue.offer(new int[]{ny,nx});
	            visited[ny][nx] = visited[node[0]][node[1]] + 1; 
	        }
	    }
	    
	    System.out.println(visited[N-1][M-1]);
	}
}
