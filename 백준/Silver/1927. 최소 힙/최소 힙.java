import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
    static PriorityQueue<Long> pq = new PriorityQueue<Long>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++){
		    Long n = Long.parseLong(br.readLine());
		    if(n == 0 ){
		        if(pq.isEmpty()) {
		            sb.append("0\n");
		            continue;
		        }
		        sb.append(pq.poll()).append("\n");
		    }
		    else{
		    pq.offer(n); }
		}
		
		System.out.println(sb);
	}
}
