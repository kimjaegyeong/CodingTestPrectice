import java.util.*;
import java.io.*;
public class Main
{
    static int number = 666;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		
		while(true){
		    String str = String.valueOf(number);
		    
		    boolean flag = str.contains("666");
		    if(flag ) {
		        cnt++;
		    }
		    if(cnt == n) {
		        System.out.println(number);
		        return;
		    }
		    		    number++;
		}
	}
	
}
