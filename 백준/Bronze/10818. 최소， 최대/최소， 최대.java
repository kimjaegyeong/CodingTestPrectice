import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[] map;
    
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    map[i] = Integer.parseInt(st.nextToken());
		    min = Math.min(min, map[i]);
		    max = Math.max(max, map[i]);
		    
		}
		
		System.out.println(min + " " + max);
	}
}
