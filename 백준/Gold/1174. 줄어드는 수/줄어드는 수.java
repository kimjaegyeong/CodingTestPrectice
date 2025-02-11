import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int cnt;
    static boolean exist = false;
    static long result = -1;
	static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(long i=0; i<10; i++){
		    pq.offer(i);
		}
		
		while(!pq.isEmpty() ){

		    result = pq.poll();
		    putNum(result);
		    cnt++;
		    
            if(N==cnt) {
                exist = true;
                break;  
                } 
            }
		
		if(exist){
		    System.out.println(result);
		    return;
		    
		}
		
		System.out.println(-1);
        		    

	}
	
	public static void putNum(long n){
	    String st = String.valueOf(n);
	    int backNum = (int)st.charAt(st.length()-1) - 48;
	    long newNum = Long.parseLong(st.substring(0, st.length()));
	    for(int i=backNum - 1; i>=0; i--){
	        pq.offer(newNum * 10 + i);
	    }
	}
}
