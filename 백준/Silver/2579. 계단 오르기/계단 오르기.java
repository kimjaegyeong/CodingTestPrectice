import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[] map;
    static int[] dp;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        map = new int[N+1];
        dp= new int[N+1];
        
        for(int i=1; i<=N; i++){
            map[i] = Integer.parseInt(br.readLine());
            
        }
        
        if(N<=1){
            System.out.println(map[N]);
        }else if(N == 2){
            System.out.println(map[1] + map[2]);
        }else{
            dp[1] = map[1];
            dp[2] = map[1] + map[2];
            
            for(int i=3; i<=N; i++){
                dp[i] = Math.max(dp[i-3] + map[i-1] + map[i] , dp[i-2] + map[i]); 
            }
            
        System.out.println(dp[N]);
        }
        
	}
}
