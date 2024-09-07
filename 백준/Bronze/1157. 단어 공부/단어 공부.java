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

	public static void main(String[] args) throws Exception {
    int alpha[] = new int[26];
    BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    String inputs[] = br.readLine().split("");
	
	for(int i=0; i<inputs.length; i++){
	    int num = (int) inputs[i].charAt(0);
	    if( num> 96){
	        //소문자 
	        alpha[num - 97] ++;
	    }else{
	        //대문자 
	        alpha[num - 65] ++;
	    }
	}
    
    int maxAlpha = 0;
    int maxIdx = 0;
    for(int i=0; i<26; i++){
        if(maxAlpha < alpha[i]){
            maxIdx = i;
            maxAlpha =  alpha[i];
        }
    }
    
    Arrays.sort(alpha);

    if(alpha[25] == alpha[24]){
        System.out.println("?");
    }else{
        System.out.println((char) (maxIdx + 65));
    }

	}
}
