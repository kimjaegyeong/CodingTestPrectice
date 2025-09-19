import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashSet<Character> set = new HashSet<Character>();
	    set.add('a');
	    set.add('e');
	    set.add('i');
	    set.add('o');
	    set.add('u');
	    set.add('A');
	    set.add('E');
	    set.add('I');
	    set.add('O');
        set.add('U');
	    	    
	    while(true){
	        String input = br.readLine();
	        if(input.equals("#")) break;
	        int cnt = 0;
	        for(int i=0; i<input.length(); i++){
	            char s = input.charAt(i);
	            if(set.contains(s)){
	                cnt++;
	            }
	        }
	        
	        System.out.println(cnt);
	        
	    }
	    
	}
}
