import java.util.*;
import java.io.*;
public class Main
{
    static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int depth = 1;
		int result = 1;
		if(N == 1) {
		    System.out.println(result);
		    return; 
		} 
		
		while(N > result) {
		    result= result+ 6 * depth ;
		    depth++;
		}
		
		System.out.println(depth);
		
	}
}
