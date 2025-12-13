import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int v[];
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		v=  new int[201];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    v[Integer.parseInt(st.nextToken()) + 100]++; 
		}
		
		int n = Integer.parseInt(br.readLine());
		
		System.out.println(v[n+100]);
	}
}
