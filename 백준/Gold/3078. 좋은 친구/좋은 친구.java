/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.io.*;
import java.util.*;
public class Main
{
    static int N,K;
    static int[] temp;
    static int total;
    static Deque<Integer>[] queue;
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String inputs[] = br.readLine().split(" ");
	    N = Integer.parseInt(inputs[0]);
	    K = Integer.parseInt(inputs[1]);
	    temp = new int[N+1];    
	    for(int i=1; i<=N; i++){
	        temp[i] = br.readLine().length();
	    }
	    
	    queue= new ArrayDeque[21];
	    for(int i=0; i<21; i++){
	        queue[i] = new ArrayDeque<Integer>();
	    }
	    
	    int len = 1;
	    long answer =0 ;
	    for(int i=1; i<=N; i++){
	        int sz = temp[i];
	        while(len - i <= K){
	            if(len>N) break;
	            queue[temp[len]].offer(len);
	            len++;
	        }
	        answer += queue[sz].size() - 1;
	        queue[sz].poll();
	    }
	    System.out.println(answer);
    }
}