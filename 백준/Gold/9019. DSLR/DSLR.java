import java.util.*;
import java.io.*;

class Node {
	int num;
	int cnt;
	ArrayList<Character> route = new ArrayList<Character>();

	public Node(int num, int cnt) {
		this.num = num;
		this.cnt = cnt;
	}

	public Node(int num, int cnt, ArrayList<Character> c) {
		this.num = num;
		this.cnt= cnt;
		this.route = c;

	}
}

public class Main
{
	static int T;
	static int A;
	static int B;
	static StringBuilder sb= new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());

			String ans = bfs(A,B);

            sb.append(ans);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static String bfs(int a, int b) {
		boolean[] visited = new boolean[10000];
		Queue<Node> q = new ArrayDeque<>();
		q.offer(new Node(a, 0));
		visited[a] = true;

		while (!q.isEmpty()) {
			Node n = q.poll();
			if (n.num == b) {
				StringBuilder sb = new StringBuilder();
				for (char dir : n.route) sb.append(dir);
				return sb.toString();
			}

			// D
			int d = (n.num * 2) % 10000;
			if (!visited[d]) {
				visited[d] = true;
				Node newD = new Node(d, n.cnt+1, new ArrayList<>(n.route));
				newD.route.add('D');
				q.offer(newD);
			}

			// S
			int s = (n.num == 0) ? 9999 : n.num - 1;
			if (!visited[s]) {
				visited[s] = true;
				Node newS = new Node(s, n.cnt+1, new ArrayList<>(n.route));
				newS.route.add('S');
				q.offer(newS);
			}

			// L
			int l = (n.num % 1000) * 10 + n.num / 1000;
			if (!visited[l]) {
				visited[l] = true;
				Node newL = new Node(l, n.cnt+1, new ArrayList<>(n.route));
				newL.route.add('L');
				q.offer(newL);
			}

			// R
			int r = (n.num % 10) * 1000 + n.num / 10;
			if (!visited[r]) {
				visited[r] = true;
				Node newR = new Node(r, n.cnt+1, new ArrayList<>(n.route));
				newR.route.add('R');
				q.offer(newR);
			}
		}
		return "";
	}

}
