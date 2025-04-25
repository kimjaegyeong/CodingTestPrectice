import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static long MAX = 1000000000L;
	static long dp[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		dp = new long[M][N+1];
		
		for(int i=0; i<=N; i++){
		    dp[0][i] = 1;
		}
		
		for(int i=1; i<M; i++){
		    for(int j=0; j<=N; j++){
		        long sum = 0;
		        for(int k=0; k<=j; k++){
		            sum += dp[i-1][k];
		        }
		        dp[i][j] = sum % MAX;
		    }
		    
		}
        
        System.out.println(dp[M-1][N]);

	}
}
