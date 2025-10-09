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
    static int M;
    static int boxes[];
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());
	    boxes = new int[N+1];
	    for(int i=0; i<M; i++){
	        st =new StringTokenizer(br.readLine());
	        int s = Integer.parseInt(st.nextToken());
	        int e = Integer.parseInt(st.nextToken());
	        int boll = Integer.parseInt(st.nextToken());
	        
	        for(int j=s; j<=e; j++){
	            boxes[j] = boll;
	        }
	        
	    }
	    
	    for(int i=1; i<=N; i++){
	        sb.append(boxes[i]).append(" ");
	    }
	    
	    System.out.println(sb);
	}
}
