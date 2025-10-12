import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception {
	    
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    while(true){
    		StringTokenizer st = new StringTokenizer(br.readLine());
            int v[] = new int[3];
    		v[0] =  Integer.parseInt(st.nextToken());
    		v[1] =  Integer.parseInt(st.nextToken());
    		v[2] =  Integer.parseInt(st.nextToken());
    	    
    	    if(v[0] ==0 && v[1] ==0 && v[1] == 0){
    	        break;
    	    }
    	    
    	    Arrays.sort(v);
    	    
    	    if(Math.pow(v[0],2) + Math.pow(v[1],2) == Math.pow(v[2],2) ) {
    	        System.out.println("right");
    	    }else{
    	        System.out.println("wrong");
    	    }    
	    }  
	}
}
