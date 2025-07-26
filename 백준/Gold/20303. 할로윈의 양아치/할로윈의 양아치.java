import java.util.*;
import java.io.*;

class KidGroup {

	int candy;
	int num;

	public String toString() {
		return "c = , n = " + candy + " " + num;
	}
}

public class Main
{
	static int N;
	static int M;
	static int K;

	static int p[];

	static int candy[];

	static long dp[];

	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[K+1];
		p = new int[N+1];
		candy = new int[N+1];
		for(int i=0; i<N+1; i++) {
			nodes.add(new ArrayList<Integer>());
			p[i] = i;
		}

		st = new StringTokenizer(br.readLine());

		for(int i=1; i<=N; i++) {
			candy[i] = Integer.parseInt(st.nextToken());
		}

		for(int i=0; i<M; i++) {
			st= new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes.get(a).add(b);
			nodes.get(b).add(a);
		}

		for(int i=0; i<nodes.size(); i++) {
			for(int j=0; j<nodes.get(i).size(); j++) {
				union(i,nodes.get(i).get(j));
			}
		}

		HashMap<Integer, KidGroup> kidsMap = new HashMap<Integer,KidGroup>();

		for(int i=1; i<p.length; i++) {
			int parent = find(i);
			if (kidsMap.containsKey(parent)) {
				KidGroup group = kidsMap.get(parent);
				group.candy += candy[i];
				group.num++;
			} else {
				KidGroup group = new KidGroup();
				group.candy = candy[i];
				group.num = 1;
				kidsMap.put(parent, group);
			}
		}


		Set keys = kidsMap.keySet();

		Iterator it = keys.iterator();

		while(it.hasNext()) {
			KidGroup group = kidsMap.get(it.next());
			for(int j = K; j>=0; j--) {
				if(j - group.num <0) continue;
				if(dp[j - group.num] + group.candy  > dp[j]) {
					dp[j] = dp[j - group.num] + group.candy;
				}

			}

		}

		long ans = 0L;
		for(int i=0; i<dp.length-1; i++) {
			ans = Math.max(ans, dp[i]);
		}

		System.out.println(ans);
	}

	public static boolean union(int a, int b) {

		int pa = find(p[a]);
		int pb = find(p[b]);

		if(pa==pb) return false;

		if(pa>pb) {

			p[pa] = pb;

		} else {
			p[pb] = pa;
		}

		return true;

	}

	public static int find(int a) {
		if(p[a] == a) return a;

		return p[a] = find(p[a]);
	}
}
