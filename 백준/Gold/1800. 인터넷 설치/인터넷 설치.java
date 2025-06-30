import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    
    int idx;
    long c;
    
    public Node(int idx, long c){
        this.idx= idx;
        this.c= c;
    }
    
    public int compareTo(Node n ){
        return Long.compare(this.c , n.c);
    }
}

public class Main
{
    static int N;
    static int P;
    static int K;
    static ArrayList<ArrayList<Node>> nodes = new ArrayList<ArrayList<Node>>();
	static long dp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		dp = new long[N+1];

		for(int i=0; i<=N; i++){
		    nodes.add(new ArrayList<Node>());
		}
		
		for(int i=0; i<P; i++){
		    st = new StringTokenizer(br.readLine());
		    int n1 = Integer.parseInt(st.nextToken());
		    int n2 = Integer.parseInt(st.nextToken());
		    long c = Long.parseLong(st.nextToken());
		    
		    nodes.get(n1).add(new Node(n2, c));
		    nodes.get(n2).add(new Node(n1,c));
		    
		}
		
		System.out.println(search());

	}
	
	public static int search(){
	    int s =0;
	    int e = 1000001;
	    int ans = Integer.MAX_VALUE;
	    int mid = (s+e)/2 ;
	    while(s <= e) {
	        mid = (s+e)/2;
	        int flag = dijkstra(mid);
	        if(flag == -1) {

	            return -1;
	        }
	        else if(flag == 1){
	            e =mid - 1;
	            ans = mid;
	        }else{
	            s = mid + 1;
	        }
	        
	    }
	    
	    return ans;
	}
	
	public static int dijkstra(int limit){
		Arrays.fill(dp, 1000000001);
		dp[1] = 0;
		
		PriorityQueue<Node> pq = new PriorityQueue<Node>();
		pq.offer(new Node(1,0));
		
		while(!pq.isEmpty()){
		    Node n = pq.poll();
		    ArrayList<Node> list = nodes.get(n.idx);
		    
		    for(Node next : list){
		        
		        if(next.c > limit){
		            if(dp[next.idx] > dp[n.idx] + 1) {
		                dp[next.idx] = dp[n.idx] + 1;
		                pq.offer(new Node(next.idx, dp[n.idx]+1));
		            }
		        }else {
		            if(dp[next.idx] > dp[n.idx]){
		                dp[next.idx] = dp[n.idx];
		                pq.offer(new Node(next.idx, dp[n.idx]));
		            }
		        }
		    }
		}
		
		if(dp[N] == 1000000001) {
		    return -1;
		}
		if(dp[N] <= K) return 1;
		return 0;
	}
	
	
}
