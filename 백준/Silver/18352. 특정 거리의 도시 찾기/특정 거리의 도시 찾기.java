import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int K;
	static int X;
    
    static int[] visited;
	static ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		for(int i=0; i<= N ; i++) {
			lists.add(new ArrayList<Integer>());
		}
		
		visited= new int[N+1];
        
       for(int i=0; i<N+1; i++){
           visited[i] = 10000001;
       }
        
		for(int i=0; i<M; i++) {
			st =new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			lists.get(s).add(e);
		}

		PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        visited[X] = 0;
        for(int i=0; i< lists.get(X).size(); i++){
            q.offer(new int[]{lists.get(X).get(i), 1});
            visited[lists.get(X).get(i)] = 1;
        }
        
        
        while(!q.isEmpty()){
            int[] n = q.poll();
            
            for(int i=0; i< lists.get(n[0]).size(); i++){
                int next = lists.get(n[0]).get(i);
                
                if(visited[next] > n[1]  +1 ) {
                   
                    visited[next] = n[1] + 1;
                    q.offer(new int[]{next, n[1] + 1});
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i=1; i<=N; i++){
            if(visited[i] == K) {
                sb.append(i).append("\n");
                flag= true;
            }
        }
        
        if(flag) {
            System.out.println(sb);
        }else{
            System.out.println(-1);
        }

	}
}
