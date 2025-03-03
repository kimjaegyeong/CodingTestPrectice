import java.util.*;
import java.io.*;

class Node {
	long d;
	int target;

	public Node(int target, long d) {
		this.target = target;
		this.d= d;
	}
}

public class Main
{
	static int N, Q;
	static ArrayList<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();;
	static int visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		Q = Integer.parseInt(st.nextToken());

		for(int i=0; i<N+1; i++) {
			nodes.add(new ArrayList<Node>());
		}

		for(int i=0; i<N-1; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long d = Long.parseLong(st.nextToken());

			nodes.get(a).add(new Node(b,d));
			nodes.get(b).add(new Node(a,d));
		}

		for(int q=0; q<Q; q++) {
			st = new StringTokenizer(br.readLine());
			long k = Long.parseLong(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int result = 0;

			ArrayDeque<Node> queue = new ArrayDeque<Node>();

			int visited[] = new int[N+1];
			visited[n] = 1;

			for(int i=0; i<nodes.get(n).size(); i++) {
				queue.offer(nodes.get(n).get(i));
				visited[nodes.get(n).get(i).target] = 1;
			}


			while(!queue.isEmpty()) {
				Node node = queue.poll();
				if(node.d >= k) {
					result++;
					
					for(int i=0; i<nodes.get(node.target).size(); i++) {
						Node target = nodes.get(node.target).get(i);
						if(visited[target.target] > 0 ) continue;
						long min_d = Math.min(node.d, target.d);
						queue.offer(new Node(target.target, min_d));
						visited[target.target] = 1;
					}
				}
			}

			sb.append(result).append("\n");
		}

		System.out.println(sb);

	}
}
