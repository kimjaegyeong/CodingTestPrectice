import java.util.*;
import java.io.*;
public class Main

{
    static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    
	    String input = br.readLine();
	    
	    int sum =0;
	    
	    for(int i=0; i<input.length(); i++){
	        sum +=input.charAt(i) - 48;
	    }
	    
	    System.out.println(sum);
	    
	}
}
