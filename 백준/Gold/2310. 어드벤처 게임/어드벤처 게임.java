import java.util.*;
import java.io.*;

class Node {
	int n;
	int p;

	public Node(int n, int p) {
		this.n = n;
		this.p = p;
	}
}

public class Main
{
	static int N;
	static int[] price;
	static boolean[] visited;
	static boolean flag ;
	static ArrayList<ArrayList<Integer>> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			N = Integer.parseInt(br.readLine());
			list = new ArrayList<ArrayList<Integer>>();
			if(N == 0) break ;
			price = new int[N+1];
			visited = new boolean[N+1];
			flag = false;
			for(int i=0; i<=N; i++) {
				list.add(new ArrayList<Integer>());
			}

			for(int i=1; i<=N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				String type = st.nextToken();
				int p = Integer.parseInt(st.nextToken());
				if(type.equals("T")) {
					price[i] = 0 - p;
				} else if(type.equals("L")) {
					price[i] = p;
				}

				while(true) {
					int room = Integer.parseInt(st.nextToken());
					if(room == 0 ) break;
					list.get(i).add(room);
				}
			}
			//input process end

			Queue<Node> q= new ArrayDeque<Node>();

			if(price[1] < 0 ) {
				sb.append("No").append("\n");
				continue;
			}

			q.offer(new Node(1,price[1]));

			while(!q.isEmpty()) {
				Node node = q.poll();
				visited[node.n] = true;

				if(node.n == N ) {
					if(check(node)) {
					    flag = true;
					}
					else{
					    flag = false;
					}
					break;
				}

				for(int i=0; i<list.get(node.n).size(); i++) {
					int nn = list.get(node.n).get(i);
					if(visited[nn]) {
						continue;
					}

					//case 1 : L
					if(price[nn] >0) {
						if(node.p < price[nn]) {
							q.offer(new Node(nn, price[nn]));
						} else {
							q.offer(new Node(nn, node.p));
						}
					}
					//case 2 : troll
					else if(price[nn] < 0) {
						if(node.p + price[nn] >= 0) {
							q.offer(new Node(nn, node.p + price[nn]));
						}
					}
                    //case 3 : empty
					else {
						q.offer(new Node(nn, node.p));
					}
				}
			}
			
			if(flag) {
			    sb.append("Yes").append("\n");
			}else{
			    sb.append("No").append("\n");
			}

		}
			System.out.println(sb);	
	}

	public static boolean check(Node node) {
		for(int i=0; i<list.get(node.n).size(); i++) {
			int np = price[list.get(node.n).get(i)] + node.p;
			if(np >= 0) {
				return true;
			}
		}
		return false;
	}
}
