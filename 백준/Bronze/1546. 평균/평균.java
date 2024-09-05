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
    static int[] v;
    static int max = -1;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());
	    v = new int[N];
	    String inputs[] = br.readLine().split(" ");
	    for(int i=0; i<N; i++){
	        v[i] = Integer.parseInt(inputs[i]);
	        max = Math.max(max, v[i]);
	    }
	    double sum =0 ;
	    for(int i=0; i<N; i++){
	        sum += (double)v[i]/max*100;
	    }
	    
	    System.out.println(sum/N);
	}
}
