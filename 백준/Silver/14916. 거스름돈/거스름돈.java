import java.util.*;
import java.io.*;

public class Main
{
    static int ans = Integer.MAX_VALUE ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		int n = N;
		int a = 0;
        while(true){
             if(n <5) {
                break;
            }
            n-=5;
            a++;
            
            if(n%2 == 0 ){
                ans = Math.min(a + n/2 , ans );
            }
        }
        
        if(N % 2 == 0 ){
            ans = Math.min(N/2,ans);
        }
        
        if(ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
		
	}
}
