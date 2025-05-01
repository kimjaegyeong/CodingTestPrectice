import java.util.*;
import java.io.*;
public class Main
{
    static int num ; 
    static int num2;
    static int ms ;
	static int[] times = {600,60,30,10};
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String input = br.readLine();
	    ms = (input.charAt(0) - 48) * 10 * 60;
	    ms += (input.charAt(1) - 48) * 60;
	    ms += (input.charAt(3)  - 48) * 10 ;
	    ms += (input.charAt(4) - 48) ;
	    
	    int temp = ms;
	    // must do start 30s
	    temp -= 30;
	    num = 1;
	    while(temp != 0 ){
	        if(ms < 30) {
	            num = Integer.MAX_VALUE;
	            break;
	        }
	        for(int i=0; i<4; i++){
	            if(temp / times[i] != 0) {
	                num += (temp/times[i]);
	                temp -= (temp / times[i]) * times[i] ;
	                break;
	            }
	        }
	    }
	   
	   
	   temp = ms;
	   while(temp != 0){
	   	        for(int i=0; i<4; i++){
	   	            
	            if(temp / times[i] != 0) {
	                num2 += (temp/times[i]);
	                temp -= (temp / times[i]) * times[i] ;
	                break;
	            }
	        }
	   }
	   num2++; //cost : push a start button 
        
	   System.out.println(Math.min(num, num2));
        
	}
}
