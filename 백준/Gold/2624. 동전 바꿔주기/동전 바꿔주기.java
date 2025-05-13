import java.util.*;
import java.io.*;

class Coin{
    
    int v;
    int c;
    
    public Coin(int v, int c){
        this.v= v;
        this.c =c;
    }
}

public class Main
{
    static int T;
    static int K;
    static Coin coins[];
    static int dp[][];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    K = Integer.parseInt(br.readLine());
	    
	    coins = new Coin[K+1];
	    dp = new int[K+1][T+1];
	    
	    coins[0] = new Coin(0,0);
	    

	    for(int i=1; i<=K; i++){
	        StringTokenizer st = new StringTokenizer(br.readLine());
	        int v =Integer.parseInt(st.nextToken());
	        int c = Integer.parseInt(st.nextToken());
            
            coins[i] = new Coin(v,c);
	        
	    }
	    
	    dp[0][0] = 1;

	    for(int i=1; i<=K; i++){
	        for(int j=0; j<=coins[i].c; j++){
	            for(int k=0; k<=T; k++){
	                int v = k + coins[i].v * j ;
	                if(v > T) break;
	                dp[i][v] += dp[i-1][k];
	            }
	        }
	    }
	    
	    
	    System.out.println(dp[K][T]);
	    
	}
}
