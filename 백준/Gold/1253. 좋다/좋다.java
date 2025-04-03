import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static long map[];
    static int result ;
    static long MAX = 1000000000;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new long[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
		    map[i] = Long.parseLong(st.nextToken()) ;
		}
		Arrays.sort(map);
        
        for(int i=0; i<N; i++){
            int s =0;
            int e = N-1;
            while(s<e){
                
                if(s==i) s++;
                else if(e==i) e--;
                
                if(s==e) break;
                
                if(map[s] + map[e] == map[i]) {
                    result++;
                    break;
                }
                else if(map[s] + map[e] > map[i]) {
                    e--;
                }else if(map[s] + map[e] < map[i]) {
                    s++;
                }
                
            }
        }
        
        System.out.println(result);
		
	}
}
