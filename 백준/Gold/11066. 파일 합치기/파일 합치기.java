import java.util.*;
import java.io.*;
public class Main
{
    static int T;
    static int N;
    static int dp[][];
    static int sum[];
    static int novel[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception{

		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
	        N = Integer.parseInt(br.readLine());
		    answer();
		}
	}
	
	public static void answer() throws Exception{

	    dp = new int[N+1][N+1];
	    sum = new int[N+1];
	    novel = new int[N+1];
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    for(int i=1; i<=N; i++){

	        novel[i] = Integer.parseInt(st.nextToken());
	        
	        sum[i] = sum[i-1] + novel[i]; 
	    }
	     
	    for(int i=1; i<=N; i++){ 
	        for(int j=1; j+i<=N; j++){  
	            int end = j+i;
	            dp[j][end] = Integer.MAX_VALUE;
	            for(int k=j ; k < end ; k++){
	                dp[j][end] = Math.min(dp[j][end], dp[j][k] + dp[k+1][end] + (sum[end] - sum[j-1])); 
	            }
	            
	        }
	    }
	    
	    System.out.println(dp[1][N]);
	}
}
