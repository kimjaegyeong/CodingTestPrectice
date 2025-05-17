import java.util.*;
import java.io.*;
public class Main
{
    /*
    3 310
    50 40
    100 70
    200 150
    */
    static int N;
    static int T;
    static int value[];
    static int time[];
    static int dp[];
    
    static int ans =0 ;
	public static void main(String[] args) throws Exception{
		// dp[j] = Math.max(dp[j],value[i] + dp[j - time[i]);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    T = Integer.parseInt(st.nextToken());
	    dp = new int[T+1];
	    value = new int[N+1];
	    time = new int[N+1];
	    for(int i=1; i<=N; i++){
	       st = new StringTokenizer(br.readLine());
	       time[i] = Integer.parseInt(st.nextToken());
	       value[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    for(int i=1; i<=N; i++){
	        for(int j=T; j>=time[i]; j--){
	            dp[j] = Math.max(dp[j] , value[i] + dp[j-time[i]]);
	        }
	        	   
	    }
	   
	   ans = dp[T];

	   
	    System.out.println(ans);
    }
}
