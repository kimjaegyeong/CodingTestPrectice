import java.util.*;
import java.io.*;
public class Main
{
    static int T;
    static int N;
    static int cnt;
    static int ASCII_a = 97;
    static char[] alpha;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;
    static boolean flag = false;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++){
		    alpha = br.readLine().toCharArray();
            N = Integer.parseInt(br.readLine());
            min = Integer.MAX_VALUE;
		    max = Integer.MIN_VALUE;
		    for(int i = ASCII_a; i < ASCII_a + 26 ; i++ ){
		       
		            search((char) i);

		    }
		    if(min == Integer.MAX_VALUE || max == Integer.MIN_VALUE){
		        System.out.println(-1);
		    	continue;
		    }
		    System.out.println(min + " " + max);
		    
		}
	}
	
	public static boolean search(char ch){
	    boolean flag = false;
	    int s = searchSp(ch);
	    int e = s+1;
	    
	    if(s == -1){
	        return flag;
	    }
        cnt= 1;
        
	    while(s < e){
	        if(cnt < N && !(e > alpha.length -1)) {
	            if(alpha[e] == ch) {
	                cnt ++;
	            }
	            e++;
	        }

	        
	        if(cnt == N){
	           min = Math.min(min , (e-s));
	            if(alpha[e-1] == alpha[s]) {
	                max = Math.max(max, (e-s));    
	            }
	            if(alpha[s] == ch) {
	                cnt --;
	            }
            s++;
	        }else if(e > alpha.length - 1){
	            s++;
	        }
	        
	        
	    }
	    return flag;
	}
	
	public static int searchSp(char ch){
	    int cnt = 0;
	    int idx = 1000001;
        for(int i=0 ;i<alpha.length; i++){
            if(ch==alpha[i]){
                idx = Math.min(idx, i);
                cnt++;
            }
        }
        
        if(!checkMin(cnt)) return -1;
        
        return idx;
	}
	
	public static boolean checkMin(int cnt){
	    if(cnt >= N){
	        return true;
	    }
	    return false;
	}
}
