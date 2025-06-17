import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int K ;
    static int[] map;
    static int[] distance;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		K = Integer.parseInt(br.readLine());
		map = new int[N];
		distance = new int[N-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    map[i] = Integer.parseInt(st.nextToken());
		}
		
		if(K >= N ) {
		    System.out.println(0);
		    return;
		    
		}
		Arrays.sort(map);
		
		for(int i=0; i<N-1; i++){
		    distance[i] = Math.abs(map[i+1] - map[i]);
		}
		
		Arrays.sort(distance);
        
        for(int i = N-2 ; i >= (N - 1) -(K - 1) ; i--) {
            distance[i] = 0;
        }
		
		int ans = 0;
		for(int i=0; i<N-1; i++){
		    ans+= distance[i];
		}
		
		System.out.println(ans);
		
		
		
	}
}
