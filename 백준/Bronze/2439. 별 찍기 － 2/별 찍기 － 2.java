import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		int cnt = N-1;
		
		for(int t=0; t<N; t++){
		    for(int i=0; i<cnt; i++){
		        sb.append(" ");
    		}
    		for(int i=cnt; i<N; i++){
    		    sb.append("*");
    		}
    		cnt--;    
    		sb.append("\n");
		}
		
		System.out.println(sb);
		
	}
}
