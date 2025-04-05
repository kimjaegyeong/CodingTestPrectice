import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int M;
    static int route[];
    static int parents[];
    static ArrayList<ArrayList<Integer>> nodes = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M= Integer.parseInt(br.readLine());
        route = new int[1001];
        parents = new int[N+1];
        
        for(int i=0; i<N+1; i++){
            nodes.add(new ArrayList<Integer>());
            parents[i] = i;
            
        }
        
        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++){
                int flag= Integer.parseInt(st.nextToken());
                if(flag==1) {
                    nodes.get(i).add(j);
                    nodes.get(j).add(i);
                }
            }
        }
        
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while(st.hasMoreTokens()){
            route[idx] = Integer.parseInt(st.nextToken());
            idx++;
        }
        
        for(int i=1; i<=N; i++){
            for(int j=0; j<nodes.get(i).size(); j++){
                union(i, nodes.get(i).get(j));
            }
        }
        
        int root = parents[route[1]];

        for(int i=1; i<idx; i++){
            if(parents[route[i]] != root ) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
	}
	
    
    public static int root(int a){
        if(parents[a] == a) return a;
        return parents[a] = root(parents[a]);
    }

	public static boolean union(int a, int b){
	    int pa = root(a);
	    int pb = root(b);
	    
	    if(pa > pb) {
	        parents[pa] = pb;
 	    }else if(pa < pb){
 	        parents[pb] = pa;
 	    }else {
 	        return true;
 	    }
 	    
 	    return false;
	}
}
