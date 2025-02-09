import java.util.*;
import java.io.*;
public class Main
{
    static double N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		if(N%7 == 2 || N%7 == 0){
		    System.out.println("CY");
		}else{
		    System.out.println("SK");    
		}
		
	}
}
