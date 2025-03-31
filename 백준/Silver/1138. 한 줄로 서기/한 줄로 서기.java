import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int map[];
    static int result[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		result= new int[N+1];
		for(int i=1; i<=N; i++){
		    int v = Integer.parseInt(st.nextToken());
		    
            int cnt =0;
            int pos = 0;
            for(int j=1; j<=N; j++){
                if(result[j] ==0 || result[j] > i) {
                    cnt++;
              
                }
                
                if(cnt > v)  {
                    pos = j;
                    break;}
               
            }
            
            result[pos] = i;
        
		}
		
		for(int i=1; i<=N; i++){
		    System.out.print(result[i] + " ");
		}
	}
}
