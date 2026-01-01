import java.util.*;
import java.io.*;

public class Main
{
	public static void main(String[] args) throws Exception{
		int v[] = new int[3];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<3; i++){
		    v[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(v);
		
		System.out.println(v[0] + " " + v[1] + " " + v[2]);
	}
}
