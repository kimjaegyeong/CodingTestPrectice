import java.util.*;
import java.io.*;

class Node implements Comparable<Node>{
    
    int idx;
    int g;
    int s;
    int c;
    
    public Node(int idx, int g, int s, int c){
        this.idx = idx;
        this.g= g;
        this.s= s;
        this.c=c;
    }
    
    public int compareTo(Node n){
        
        return n.g - this.g == 0 ? n.s - this.s == 0 ? n.c - this.c : n.s - this.s : n.g- this.g;
    }
    
    public String toString(){
        
        return this.idx + " " +this.g + " " + this.s + " " + this.c;
    }
    
    
}

public class Main
{
    static int N;
    static int M;
    static Node[] v;
    static int[] rank;
 	public static void main(String[] args) throws Exception{
 	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 	    StringTokenizer st = new StringTokenizer(br.readLine());
 	    N = Integer.parseInt(st.nextToken());
 	    M = Integer.parseInt(st.nextToken());
 	    v = new Node[N];
 	    rank = new int[N+1];
 	    
 	    for(int i=0; i<N; i++){
 	        st = new StringTokenizer(br.readLine());
 	        int idx = Integer.parseInt(st.nextToken());
 	        int g = Integer.parseInt(st.nextToken());
 	        int s = Integer.parseInt(st.nextToken());
 	        int c = Integer.parseInt(st.nextToken());
 	        
 	        Node n = new Node(idx, g, s, c);
 	        
 	        v[i] = n;
 	    }
 	    
 	    Arrays.sort(v);
 	    
 	    int ranking = 1;
 	    rank[1] = 1;
 	    
 	    for(int i=1; i<N; i++){
 	        if(v[i-1].g == v[i].g && v[i-1].s == v[i].s && v[i-1].c == v[i].c) {
 	            rank[v[i].idx] = ranking;
 	            continue;
 	        }
 	        ranking=i +1;
 	        rank[v[i].idx] = ranking;
 	    }
 	    
//  	    System.out.println(Arrays.toString(v));
// 		System.out.println(Arrays.toString(rank));

        System.out.println(rank[M]);
	}
}
