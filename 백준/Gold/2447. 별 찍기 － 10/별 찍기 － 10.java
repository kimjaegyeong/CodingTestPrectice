import java.util.*;
import java.io.*;

public class Main
{
    static int WH;
    static char map[][];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		WH = Integer.parseInt(br.readLine());
		map = new char[WH+1][WH+1];
		for(int i=0; i<WH+1; i++){
		    for(int j=0; j<WH+1; j++){
		        map[i][j]='.';
		    }
		}
		dfs(WH, 0,0);
		
		for(int i=0; i<WH; i++){
		    for(int j=0; j<WH; j++){
		        sb.append(map[i][j]);
		    }
		    sb.append("\n");
		}
		System.out.println(sb);
	}
	
	public static void dfs(int N, int y, int x){
	    if(N==3){
	       star(N,y,x);
	        return;
	    }
	   star(N,y,x);
	    int sy = 0;
	    int sx = 0;
	    int ey =0;
	    int ex= 0;
	    for(int i=0; i<3; i++){
            sy = y + (i * (N/3));

	        for(int j=0; j<3; j++){
	            sx = x+( j * (N/3));

	            
	            dfs(N/3, sy, sx);
	        }
	    }
	    
	    
	    
	    
	}
	
	public static void star(int N,int y, int x){
	    for(int i=y; i< N; i++){
	        for(int j=x; j<N; j++){
	            if(map[i][j]!=' '){
	                map[i][j] = '*';    
	            }
	            
	        }
	    }
	    
        for(int i=0; i<N/3; i++){
            for(int j=0; j<N/3; j++){
                map[y + (N/3) + i][x + (N/3) + j] = ' ';
            }
        }
	}
}
