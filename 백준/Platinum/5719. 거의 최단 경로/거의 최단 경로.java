
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static class Node implements Comparable<Node> {
		int idx, cost;

		public Node(int idx, int cost) {
			this.idx = idx;
			this.cost = cost;
		}

		public int compareTo(Node n) {
			return this.cost - n.cost;
		}

		@Override
		public String toString() {
			return "Node [idx=" + idx + ", cost=" + cost + "]";
		}
	}

	static boolean endPoint = false;
	static BufferedReader br;
	static StringBuilder sb;
	static StringTokenizer st;
	static int n;
	static int m;
	static int s;
	static int d;
	static int short_cost;
	static int max = 1000 * 500 + 1;
	static int[] dist;
	static ArrayList<ArrayList<Node>> nodes ;
	static ArrayList<ArrayList<Integer>> route_list ;
	static ArrayList<boolean[]> delete_route;
	static boolean[] visit;
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		while (true) { // 테스트케이스
			short_cost = 1000 * 500 + 1;
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			if (n == 0 && m == 0) {
				break;
			}
			st = new StringTokenizer(br.readLine());
			s = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			dist = new int[n];
			nodes = new ArrayList<>();
			route_list= new ArrayList<>();
			delete_route = new ArrayList<>();
			visit = new boolean[n];
			for (int i = 0; i < n; i++) {
				nodes.add(new ArrayList<Node>());
				delete_route.add(new boolean[n]);
			}

			for (int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				nodes.get(a).add(new Node(b, c));
			} //input process and
			
			dijkstra(s);
			cut_short_route(d);
			dijkstra(s);
			result();
		}
	}

	static void result() {
		if(dist[d]==max) {
			System.out.println(-1);
			return;
		}else {
			System.out.println(dist[d]);
		}
	}
	static void cut_short_route(int nxt) {
		visit[nxt] = true;
		if(nxt==s) return;
		for(int i=0; i<route_list.get(nxt).size(); i++) {
			int now = route_list.get(nxt).get(i);
			if(visit[now]) {
				delete_route.get(now)[nxt] = true;
				continue;
			} 
			//	System.out.println("cut_route" + now + " -> " + nxt);
			delete_route.get(now)[nxt] = true;
			cut_short_route(now);
		}	
	}

	static int count_route() {
		return 0;
	}
	
	static void dijkstra(int s) {
		Arrays.fill(dist, max);
		for(int i=0; i<n; i++) {
			route_list.add(new ArrayList<Integer>());
		}
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(s, 0));
		dist[s] = 0;
		
		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if(now.cost > dist[now.idx]) continue;
			
			for(int i=0; i<nodes.get(now.idx).size(); i++) {
				Node nxt = nodes.get(now.idx).get(i);
				if(delete_route.get(now.idx)[nxt.idx]) continue;
				// 현재까지의 dist + 현재->다음 노드의 dist vs 기존의 다음 노드까지의 dist 
				if(nxt.cost + dist[now.idx] < dist[nxt.idx]) {
					dist[nxt.idx] = nxt.cost + dist[now.idx];
					pq.offer(new Node(nxt.idx, dist[nxt.idx]));
					route_list.get(nxt.idx).clear();
					route_list.get(nxt.idx).add(now.idx);
				}else if(nxt.cost + dist[now.idx] == dist[nxt.idx]) {
					route_list.get(nxt.idx).add(now.idx);
				}
			}
		}
	}
}
