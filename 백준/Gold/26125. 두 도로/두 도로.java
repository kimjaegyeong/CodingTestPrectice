import java.util.*;
import java.io.*;

public class Main
{
    static long MAX = (long)1e15;
    static int N;
    static int M;
    static int S;
    static int T;
    static int Q;
    static long[][] dp;
    
    static StringBuilder sb=  new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		dp = new long[N+1][N+1];
		
		for(int i=0; i<N+1; i++){
		    Arrays.fill(dp[i], MAX);
		}
		
		for(int i=1; i<=N; i++){
		    dp[i][i] = 0L;
		}
		
		for(int i=0; i<M; i++){
		    
	        st = new StringTokenizer(br.readLine());
		    int s = Integer.parseInt(st.nextToken());
		    int e = Integer.parseInt(st.nextToken());
		    long w = Long.parseLong(st.nextToken());
		    
		    dp[s][e] = Math.min(dp[s][e], w);
		}
		
		for (int m = 1; m <= N; m++) {
            for (int s = 1; s <= N; s++) {
                if (dp[s][m] == MAX) continue;   
                for (int e = 1; e <= N; e++) {
                    if (dp[m][e] == MAX) continue; 
                    dp[s][e] = Math.min(dp[s][e], dp[s][m] + dp[m][e]);
                }
            }
}
		
// 		for(int i=1; i<=N; i++){
// 		    System.out.println(Arrays.toString(dp[i]));
// 		}
		
		st = new StringTokenizer(br.readLine());
		Q = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<Q; i++){
		    
	        st = new StringTokenizer(br.readLine());
		    int a1= Integer.parseInt(st.nextToken()); 
		    int b1= Integer.parseInt(st.nextToken());
		    long c1= Long.parseLong(st.nextToken());
		    
		    int a2= Integer.parseInt(st.nextToken());
		    int b2= Integer.parseInt(st.nextToken());
		    long c2= Long.parseLong(st.nextToken());
		    
		    long res  = simul(a1,b1,c1,a2,b2,c2);
		    
		    if(res >= MAX) {
		        sb.append("-1").append("\n");
		    }else{
		        sb.append(res).append("\n");  
		    }
		    
		}
		
		System.out.println(sb);
		
	}
	
	public static long simul(int a1,int b1, long c1, int a2, int b2, long c2){
	    
	    long ans = dp[S][T];
	    
	    // 1 s->도로1->e 
	    long res1 = dp[S][a1] + Math.min(dp[a1][b1] , c1) + dp[b1][T];
	    
	    ans = Math.min(ans, res1);
	    //2 s->도로2->e 
	    long res2 = dp[S][a2] + Math.min(dp[a2][b2] , c2) + dp[b2][T];
	    ans = Math.min(ans, res2);
	    //3 s-> 도로1->도로2-> e
	    long res3 = dp[S][a1] + Math.min(dp[a1][b1], c1) + dp[b1][a2] +Math.min(dp[a2][b2] , c2) + dp[b2][T];
	    ans = Math.min(ans, res3);
	    //4 s->도로2 ->도로1 -> e 
	    long res4 = dp[S][a2] + Math.min(dp[a2][b2], c2) + dp[b2][a1] +Math.min(dp[a1][b1], c1) + dp[b1][T]  ;
	    ans = Math.min(ans, res4);
	   
	    return ans;
	}
}
