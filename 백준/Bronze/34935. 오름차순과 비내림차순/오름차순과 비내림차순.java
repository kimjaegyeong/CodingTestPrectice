import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		boolean flag = true;
		
		StringTokenizer st= new StringTokenizer(br.readLine());
		long pre = Long.parseLong(st.nextToken()); 
		for(int i=1; i<N; i++){
		    long n = Long.parseLong(st.nextToken());
		    if(n <= pre) {
		        System.out.println(0);
		        return;
		    }
		    pre = n;
		}
		
		System.out.println(1);
	}
}
