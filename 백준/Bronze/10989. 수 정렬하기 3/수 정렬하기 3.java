import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[] map;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		for(int i=0; i<N; i++){
		    map[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(map);
		
		for(int i=0; i<N; i++){
		    sb.append(map[i]).append("\n");
		}
		
		System.out.println(sb);
	}
}
