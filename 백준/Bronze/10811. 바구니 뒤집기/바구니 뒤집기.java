import java.util.*;
import java.io.*;

public class Main
{
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] basket = new int[N+1];
        for(int i=1; i<=N; i++){
            basket[i] = i;
        }
        
        for(int i=0; i<M; i++){
            st=  new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            
            int cnt =0 ;
            for(int j=s; j<=e; j++){
                if(cnt >= ((e-s)+1)/2) break;
                int temp = basket[j];
                basket[j] = basket[e- cnt];
                basket[e-cnt] = temp;
                cnt++;
            }
            
            
        
        }
        
        for(int i=1; i<basket.length; i++){
            sb.append(basket[i]).append(" ");
        }
        
        System.out.println(sb);
        
	}
}
