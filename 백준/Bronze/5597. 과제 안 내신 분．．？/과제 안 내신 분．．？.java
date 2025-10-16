import java.util.*;
import java.io.*;
public class Main
{
    static int[] v;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		v = new int[31];
		
		for(int i=0; i<28; i++){
		    int num  = Integer.parseInt(br.readLine());
		    
		    v[num] = 1;
		}
		
		for(int i=1; i<=30; i++){
		    if(v[i] == 0 ){
		        System.out.println(i);
		    }
		}
	}
}
