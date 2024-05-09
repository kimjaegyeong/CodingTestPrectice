
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main  {

	static class Node implements Comparable<Node> {
		int b, cost;

		public Node(int b, int cost) {
			this.b = b;
			this.cost = cost;
		}
		
		public int compareTo(Node n) {
			return this.cost - n .cost;
		}
	}

	static int N, M;
	static int v1, v2;
	static int dp[];
	static int max = 200000010;
	static ArrayList<ArrayList<Node>> list = new ArrayList<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		dp = new int[N+1];
		Arrays.fill(dp, max);
		for(int i=0; i<=N; i++) {
			list.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<M; i++) {
			st=  new StringTokenizer(br.readLine());
			int a =Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c =Integer.parseInt(st.nextToken());
			
			list.get(a).add(new Node(b,c));
			list.get(b).add(new Node(a,c));
		}
		
		st= new StringTokenizer(br.readLine());
		v1 = Integer.parseInt(st.nextToken());
		v2 = Integer.parseInt(st.nextToken());
		Arrays.fill(dp, max);
		int root1 = 0;
		dijkstra(1);
		root1+=dp[v1];
		dijkstra(v1);
		root1+=dp[v2];
		
		dijkstra(v2);
		root1+=dp[N];
	
		Arrays.fill(dp, max);
		int root2= 0;
		dijkstra(1);
		root2+=dp[v2];
		dijkstra(v2);
		root2+=dp[v1];
		dijkstra(v1);
		root2+=dp[N];
		if(root1>=max && root2>= max ) {
			System.out.println(-1);
		}else {
			System.out.println(Math.min(root1, root2));
	
		}
			
	}
	/*
	 */
	static void dijkstra(int n) {
		Arrays.fill(dp, max);
		PriorityQueue<Integer> q = new PriorityQueue<>();
		q.offer(n);
		dp[n] = 0;
		while(!q.isEmpty()) {
			int node = q.poll();
			for(int i=0; i<list.get(node).size(); i++) {
				Node next = list.get(node).get(i);
				if(dp[node] + next.cost < dp[next.b]) {
					dp[next.b]  = dp[node] + next.cost;
					q.offer(next.b);
				}
			}
		}
	}
}
