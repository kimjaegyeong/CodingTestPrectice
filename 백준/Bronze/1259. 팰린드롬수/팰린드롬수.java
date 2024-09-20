/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.io.*;
public class Main
{

	public static void main(String[] args) throws Exception{
		    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true){
            boolean flag = true;
		    String inputs[] = br.readLine().split("");
		    if(Integer.parseInt(inputs[0])==0 && inputs.length ==1 ){
		       break;
		    }
		    
		    for(int i=0; i<inputs.length/2; i++){
		        if(!(inputs[i].equals(inputs[inputs.length-i-1]))){
		            System.out.println("no");
		            flag = false;
		            break;
		        }
		    }
		    if(flag){
		       System.out.println("yes");
		    }
		     
		}
	}
}
