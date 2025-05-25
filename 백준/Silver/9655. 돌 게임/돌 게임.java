import java.util.*;
import java.io.*;
public class Main
{
    static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		int turn = N / 3;
		
		//turn 홀수면 SK 짝수면 CY
		if(N%3 ==0 || N%3 == 2){
		    if(turn % 2==0){
		        System.out.println("CY");		        
		    }else{
		        System.out.println("SK");

		    }
		}else{
		    if(turn % 2== 0) {
		        System.out.println("SK");
		    }else{
		        
		        System.out.println("CY");
	
		    }
		}
		
	}
}
