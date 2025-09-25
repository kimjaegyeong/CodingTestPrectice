import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int M;
	static int[] dp;
	static int[] nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		nums = new int[N];
		
		for(int i=0; i<N; i++){
		    nums[i] = Integer.parseInt(br.readLine());
		}
		dp = new int[M+1];
		Arrays.sort(nums);
		int MAX = 100000001;
		Arrays.fill(dp,MAX);
 		dp[0] = 0;
		for(int i=0; i<N; i++){
		    for(int j=nums[i]; j<dp.length; j++){
		        dp[j] = Math.min(dp[j - nums[i]] +1, dp[j]);
		    }
		}
		
		if(dp[M]==MAX){
		    System.out.println(-1);
		    return;
		}
		System.out.println(dp[M]);
	}
}