import java.util.*;
import java.io.*;

class Node {
	int d;
	int p;

	public Node(int d, int p) {
		this.d=d;
		this.p=p;
	}
}

public class Main
{
	final static int MAX = 100000001;
	static int T;
	static int N;
	static int M;
	static int W;
	static int dist[];

	static ArrayList<ArrayList<Node>> graph;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			graph = new ArrayList<ArrayList<Node>>();

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());

			dist =new int[N+1];
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<Node>());
			}

			for(int i=0; i<M; i++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				graph.get(s).add(new Node(e,p));
				graph.get(e).add(new Node(s,p));

			}

			for(int i=0; i<W; i++) {

				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());

				graph.get(s).add(new Node(e,0 - p));
			}

			//input process end
            
            boolean result =isCycle();
            // System.out.println(Arrays.toString(dist));
            System.out.println(result ? "YES" : "NO");
		}

	}

	public static boolean isCycle() {
		for(int idx = 1; idx<=N; idx++) {
			for(int i=1; i<=N; i++) {
				ArrayList<Node> list = graph.get(i);
				for(Node n : list) {
					int p = n.p;
					int e = n.d;

					if(dist[e] > dist[i] + p) {
						dist[e] = dist[i] + p;
						if(idx==N) return true;
					}
				}
			}
		}


		return false;
	}
}
