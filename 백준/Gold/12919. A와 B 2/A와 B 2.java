import java.io.*;
import java.util.*;

public class Main
{
    static String S;
    static String T;
    static boolean result = false;
	public static void main(String[] args) throws Exception{
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    S = br.readLine();
	    T = br.readLine();
        
        checkString(T);	    
        System.out.println(result ? 1: 0);
	    
	}
	
	public static void checkString(String input){
	    if(input.length() == S.length()){
	        if(input.equals(S)){
	            result = true;
	        }
	        return; 
	    }
	    
	    if(input.charAt(0) == 'B'){
	       StringBuffer sb = new StringBuffer(input);
	       String reverseInput = sb.reverse().deleteCharAt(input.length()-1).toString();
	       checkString(reverseInput);
	    }
	    
	    if(input.charAt(input.length()-1)=='A'){
	        checkString(input.substring(0,input.length()-1));
	    }
	}

}

