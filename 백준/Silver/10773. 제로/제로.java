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
    static int N;
	public static void main(String[] args) throws Exception{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        N = Integer.parseInt(br.readLine());
	        ArrayDeque<Integer> stack = new ArrayDeque<Integer>();
	        for(int i=0; i<N; i++){
	            int n = Integer.parseInt(br.readLine());
	            if(n == 0 ){
	                if(stack.isEmpty()){
	                    continue;
	                }
	                stack.pollLast();
	                
	            }else{
	             stack.offerLast(n);
	           
	            }
	            
	             }
	    long sum =0 ;
	    while(!stack.isEmpty()){
	        long d = stack.pollLast();
	        sum = sum + d;
	        
	    }
	    
	    System.out.println(sum);
	    
	}
}
