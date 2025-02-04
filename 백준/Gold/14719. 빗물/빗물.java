/*
4 4
3 0 1 4

*/
import java.util.*;
import java.io.*;

public class Main
{
    static int H,W;
    static int[] map;
    static int left, right;
    static int result;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
	    map = new int[W];
	    
		 st = new StringTokenizer(br.readLine());
		for(int i=0; i<W; i++){
		    map[i] = Integer.parseInt(st.nextToken());
		}
		
		
		for(int i=1; i<W-1; i++){
		    // 특정 지점보다 왼쪽 구간에서의 최대 벽 높이 찾기
		    left = 0;
		    right = 0;
		    for(int j= i; j >= 0; j--){
                left = Math.max(left, map[j]);
		    }    
		    
		    //특정 지점보다 오른쪽 구간에서의 최대 벽 높이 찾기 
		    for(int j=(i+1); j<W; j++){
		        right = Math.max(right, map[j]);
		    }
		    
		    int minFloor = Math.min(left,right);
		    
		    if(map[i] <= minFloor){
		        result+= minFloor - map[i] ;		        
		    }
		}
		
		System.out.println(result);
	}
}
