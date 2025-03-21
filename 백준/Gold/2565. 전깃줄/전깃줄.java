import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int a;
	int b;

	public Node(int a, int  b) {
		this.a = a;
		this.b = b;
	}

	public int compareTo(Node n) {
		return this.a - n.a  ;
	}
}

public class Main
{
	static int N;
	static Node map[];
	static int dp[];
	static int cnt = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new Node[N];
		dp = new int[N+1];
		for(int i= 0 ; i<N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b =Integer.parseInt(st.nextToken());

			map[i] = new Node(a,b);
		}

		for(int i=0; i<N+1; i++) {
			dp[i] = 100001;
		}

		Arrays.sort(map);

		for(int i=0; i<N; i++) {
			for(int j=0; j<dp.length; j++) {
				if(dp[j] < map[i].b) {
					continue;
				}
				if(dp[j]!=100001){
				    cnt ++;
				}
				dp[j] = map[i].b;
				
				break;
			}
		}
		
		System.out.println(cnt);

	}
}
