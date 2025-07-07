import java.util.*;
import java.io.*;

class Node {
	int right = -1;
	int left = -1;

	public String toString() {
		return "left = " + (left + 1) + " right = " + (right + 1);
	}
}

public class Main {
	static int T;
	static int N;
	static int[] pre;
	static int[] in;
	static int idx;
	static Node[] graph;
    static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			N = Integer.parseInt(br.readLine());
			pre = new int[N];
			in = new int[N];
			idx = 0;
			graph = new Node[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				pre[i] = Integer.parseInt(st.nextToken()) - 1;
				graph[pre[i]] = new Node();
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				in[i] = Integer.parseInt(st.nextToken()) - 1;
			}

			int rootIdx = -1;
			for (int i = 0; i < N; i++) {
				if (in[i] == pre[0]) {
					rootIdx = i;
					break;
				}
			}

			int[] left = Arrays.copyOfRange(in, 0, rootIdx);
			int[] right = Arrays.copyOfRange(in, rootIdx + 1, N);

			dfs(left, right, pre[0]);

			postorder(pre[0]);
            sb.append("\n");
		}
		System.out.println(sb);
	}

	public static void dfs(int[] left, int[] right, int rootVal) {
		if (left.length == 0 && right.length == 0) return;

		if (idx + 1 >= N) return;

		int next = pre[idx + 1];

		// 왼쪽 자식 찾기
		boolean leftFound = false;
		for (int i = 0; i < left.length; i++) {
			if (left[i] == next) {
				graph[rootVal].left = next;
				idx++;
				int[] nextLeft = Arrays.copyOfRange(left, 0, i);
				int[] nextRight = Arrays.copyOfRange(left, i + 1, left.length);
				dfs(nextLeft, nextRight, next);
				leftFound = true;
				break;
			}
		}

		if (idx + 1 >= N) return;

		next = pre[idx + 1];

		// 오른쪽 자식 찾기
		for (int i = 0; i < right.length; i++) {
			if (right[i] == next) {
				graph[rootVal].right = next;
				idx++;
				int[] nextLeft = Arrays.copyOfRange(right, 0, i);
				int[] nextRight = Arrays.copyOfRange(right, i + 1, right.length);
				dfs(nextLeft, nextRight, next);
				break;
			}
		}
	}

	public static void postorder(int node) {
		if (node == -1) return;
		postorder(graph[node].left);
		postorder(graph[node].right);
		sb.append((node + 1) + " ");
	}
}
