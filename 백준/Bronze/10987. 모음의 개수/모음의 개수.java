import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		int cnt=0;
		char v[] = {'a','e','i','o','u'};
		for(int i=0; i<input.length(); i++){
		    for(int j=0;j<5; j++){
		        if(input.charAt(i) == v[j]) {
		            cnt++; 
		            break;
		        }    
		    }
		    
		}
		
		System.out.println(cnt);
	}
}
