

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int T;
	static int n;
	static int[] map;
	static int[] parents;
	static int[] sum;
	static StringBuilder sb = new StringBuilder();
	static int contains ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n + 1];
			parents = new int[n + 1];
			sum = new int[n + 1];
			contains =0;
			for (int i = 1; i <= n; i++) {
				parents[i] = i;
			}
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= n; i++) {
				int target = Integer.parseInt(st.nextToken());
				map[i] = target;
				if (target == i) {
					parents[i] = -1;
					contains++;
				}
			}
			for (int i = 1; i <= n; i++) {
				if (find(i) == -1 || find(map[i]) == -1)
					continue;
				boolean un = union(i, map[i]);
				if (!un) {
					exceptCycle(i,i,0);
				}
			}
			//System.out.println(contains);
			sb.append(n-contains).append("\n");
		}

		System.out.println(sb);
	}
	
	static void exceptCycle(int a, int root, int cnt) {

		if(a==root && cnt!=0) {
			return ;
		}
		contains++;
		exceptCycle(map[a], root, cnt+1);
	}
	static int find(int a) {
		if (parents[a] == -1 || parents[a] == a) {
			return parents[a];
		}
		return parents[a] = find(parents[a]);
	}

	static boolean union(int a, int b) {
		int pa = find(a);
		int pb = find(b);
		if (pa == -1 && pb == -1) {
			return true;
		}
		if (pa == pb) {// cycle
			return false;
		}

		
		if(pa> pb) {
			parents[pb] = pa;	
		}else {
			parents[pa] = pb;
		}
		return true;
	}
}
