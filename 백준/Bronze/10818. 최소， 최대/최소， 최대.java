import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int[] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    map[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(map);
		
		System.out.println(map[0] + " " + map[N-1]);
	}
}
