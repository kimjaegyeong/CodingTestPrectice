import java.util.*;
import java.io.*;
public class Main
{
    
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		int score= 1;
		int sum = 1;
		
		for(int i=1; i<input.length(); i++){
		    int pre = input.charAt(i-1) - 48;
		    int now = input.charAt(i) - 48;
		    
		    if(pre < now) {
		        score++;
		    }else{
		        score=1;
		    }
		    sum+=score;
		}
		
		System.out.println(sum);
		
	}
}
