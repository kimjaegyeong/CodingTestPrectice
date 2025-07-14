import java.util.*;
import java.io.*;
public class Main
{
    
	public static void main(String[] args) throws Exception{
	   	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    int cnt = 0;
	    for(int i=0; i<input.length(); i++){
	        cnt= cnt*10;
	        cnt+= input.charAt(i) - 48;
	    }
	    
	    System.out.println(cnt - 543);
	    
	}
}
