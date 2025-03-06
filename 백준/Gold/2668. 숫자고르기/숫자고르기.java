import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
	static HashSet<Integer> set = new HashSet<Integer>();
	static int MAX = 100;
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];

		for(int i=0; i<N+1; i++) {
			nodes.add(new ArrayList<Integer>()) ;
		}

		for(int i=1; i<N+1; i++) {
			int n = Integer.parseInt(br.readLine());

			if(i==n) {
				set.add(n);
			} else {
				nodes.get(i).add(n);
			}

		}

		for(int i=1; i<N+1; i++) {
			dfs(i);
		}

        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        
        sb.append(list.size()).append("\n");
        for(int e : list){
            sb.append(e).append("\n");
        }
        
        System.out.println(sb);
        
	}

	public static boolean dfs(int n) {

		for(int i=0; i<nodes.get(n).size(); i++) {
			int node = nodes.get(n).get(i);
			if(visited[node]) {
				return true;
			}
			visited[node] = true;
			boolean result =dfs(node);
			visited[node] = false;
			if(result) {
				set.add(n);
			}
		}
		return false;
	}
}
