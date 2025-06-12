import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int[] dp;
	static ArrayList<Integer> prime = new ArrayList<Integer>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		dp  = new int[N+1];
		for(int i=2; i<=N; i++) {
			if(isPrime(i)) prime.add(i);
		}
        

        dp[0] = 1;
        
		for(int i=0; i<prime.size(); i++) {
			int p = prime.get(i);
			for(int j=p; j<=N; j++) {
				dp[j] = (dp[j] + dp[j - p] ) % 123456789;
			}
		}

		System.out.println(dp[N] % 123456789);


	}

	public static boolean check(int n) {
		if( n < 0 || n > N) return false;
		return true;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
}
