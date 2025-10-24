import java.util.*;
import java.io.*;
public class Main
{
    static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int res =1 ;
		while(true){
		    if(N == 1) break;
		    res++;
		    if(N%2 ==0){
		        N= N/2;
		    }else{
		        N = N*3 + 1;
		    }
		}
		
		System.out.println(res);
	}
}
