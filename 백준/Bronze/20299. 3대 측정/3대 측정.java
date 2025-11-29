import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int K;
	static int L;
	
	static int ans = 0;

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			int n3 = Integer.parseInt(st.nextToken());
		    
		    if(n1 < L || n2 < L || n3 < L) continue;
		    
		    if(n1+n2+n3 < K) continue;
		    ans++;
		    
		    sb.append(n1).append(" ").append(n2).append(" ").append(n3).append(" ");
		    
		    
		}
		
		System.out.println(ans);
		System.out.println(sb);
		
	}
}
