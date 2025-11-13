import java.util.*;
import java.io.*;
public class Main
{
    
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    int h = input.length()/2;
	    
	    int a = 0;
	    int b = 0;
	    for(int i=0; i<h; i++){
	        a+= input.charAt(i) - 48;
	    }
	    
	    for(int j=h; j<input.length(); j++){
	        b+= input.charAt(j) - 48;
	    }
	    
	    if(a==b){
	        System.out.println("LUCKY");
	    }else{
	        System.out.println("READY");	    }
	}
}
