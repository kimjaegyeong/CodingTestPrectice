import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int K;
    static int store;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		while(true){
		  int kc = bottle_merge(N);
		  if(kc <= K) break;
		  
		  N++;
		  store++;
		    
		}
		System.out.println(store);
	}
	
	public static int bottle_merge(int n){
	    int not_merge=0;
	    while(n > 0) {
	        if(n%2 != 0) not_merge++;
	        n = n/2;
	    }
	    
	    return not_merge;
	}
}
