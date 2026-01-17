import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		for(int i=0; i< input.length()/2; i++){
		    if(input.charAt(i) != input.charAt( input.length() - i-1) ) {
		        System.out.println(0);
		        return;
		    }
		}
		
		System.out.println(1);
	}
}
