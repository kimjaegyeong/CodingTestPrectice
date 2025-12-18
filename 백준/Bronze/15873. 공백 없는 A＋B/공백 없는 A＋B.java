import java.util.*;
import java.io.*;
public class Main
{
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String input = br.readLine();
		int A = 0;
		int B = 0;
		if(input.length() ==3 ){
		    if(input.charAt(1) == '0') {
		        A = 10;
		        B = input.charAt(2) - 48;
		    }else if(input.charAt(2) == '0'){
		        A = input.charAt(0) - 48;
		        B = 10;
		    }
		}else if(input.length() == 4) {
		    A = 10;
		    B = 10;
		}else{
		    A = input.charAt(0)- 48;
		    B = input.charAt(1) - 48;
		}
		
		System.out.println(A+B);
	}   
}
