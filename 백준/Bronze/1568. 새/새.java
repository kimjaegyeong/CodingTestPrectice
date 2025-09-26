import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int s = 1;
    static int sum = 0;
    static int cnt =0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		while(true){
		    if(sum == N) break;
		    
		    if(s + sum > N){
		        s = 1;
		        
		    }else{
		        sum+=s;
		        s++;
		        cnt++;
		    }
		}
		
		System.out.println(cnt);
	}
}
