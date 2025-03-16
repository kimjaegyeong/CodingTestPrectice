import java.util.*;
import java.io.*;
public class Main
{
    static int a_cnt;
    static int ans = 10000000;
    static int N;
    static String input;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		N = input.length();
		for(int i=0; i<N; i++){
		   if(input.charAt(i) =='a') {
		       a_cnt ++;
		   }
		}
		
		int s = 0;
		int e = a_cnt;
		while(s < N){
		    int changeCnt = 0;
		    for(int i=s; i<e; i++){
		        if(input.charAt(i % N )=='b'){
		            changeCnt++;
		        }
		    }
		    s++;
		    e++;
		    ans = Math.min(ans, changeCnt);
		}
		
		System.out.println(ans);
	}
}
