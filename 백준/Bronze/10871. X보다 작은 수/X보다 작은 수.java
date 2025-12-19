import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int X;
    
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    X = Integer.parseInt(st.nextToken());
	    
	    st=  new StringTokenizer(br.readLine());
	    
	    for(int i=0; i<N; i++){
	        int x = Integer.parseInt(st.nextToken());
	        
	        if(x < X) {
	            sb.append(x).append(" ");
	        }
	    }
	    
	    System.out.println(sb);
	    
		
	}
}
