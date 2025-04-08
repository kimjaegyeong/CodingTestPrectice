import java.util.*;
import java.io.*;
public class Main
{   
    static int T;
    static int N;
    static long result;
    static int map[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int t=0; t<T; t++){
		    N = Integer.parseInt(br.readLine());
		    map = new int[N];
		    int max = 0;
		    result = 0;
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    for(int i=0; i<N; i++){
		        map[i] = Integer.parseInt(st.nextToken());
		    }
		    
            
            for(int i=N-1; i>=0; i--){
                max= Math.max(max, map[i]);
                result+= max - map[i];
            }
            
            System.out.println(result);
		    
		}
	}
}
