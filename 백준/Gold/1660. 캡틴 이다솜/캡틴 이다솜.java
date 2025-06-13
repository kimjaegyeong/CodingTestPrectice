import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int[] dp;
	static  ArrayList<Integer> triangle= new ArrayList<Integer>();
	static  ArrayList<Integer> tetrahedron = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        dp = new int[N+1];
		int sum = 1;
		int ad = 2;
		while(sum <= N) {
			triangle.add(sum);
			sum = sum +ad;
			ad ++;
		}

		sum = 0;
		for( int i : triangle) {
			sum += i;
			tetrahedron.add(sum);
		}

        
        for(int i=0; i<=N; i++){
            dp[i] = i; 
        }

    
		for(int i = 1 ; i < tetrahedron.size(); i++) {
			int tetra = tetrahedron.get(i);
			for(int j=tetra; j<=N; j++) {
                dp[j] = Math.min(dp[j - tetra] + 1,dp[j]); 
			}
		}
	
		System.out.println(dp[N]);

	}
}
