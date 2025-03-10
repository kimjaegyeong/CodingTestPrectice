import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long v[];
    static long total;
    static long sum;
    static long max;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v = new long[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    v[i] = Long.parseLong(st.nextToken());
		    sum+=v[i];
		}
		total = Long.parseLong(br.readLine());
		
		Arrays.sort(v);
		
		if(sum <= total) {
		    System.out.println(v[N-1]);
		    return;
		}
		long tempSum = 0;
		for(int i=0; i<N; i++){
		    long temp = search(tempSum, i);
		    tempSum+=v[i];
		}
		
		System.out.println(max);
		
	}
	
	public static long search(long min, int i ){
	    long s =1;
	    long e = 1000000000;
	    long mid = (s+e)/2;
	    while(s<e){
	         mid = (s+e)/ 2;
	 
	        if(min + (mid * (N - i) )<= total ){
	            s = mid+1;
	            max = Math.max(mid, max);
	        }else {
	            e = mid;
	        }
	    }
	    
	    return mid;
	}
}
