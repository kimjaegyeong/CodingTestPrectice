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
	static final int N = 10000;
	static StringBuffer sb = new StringBuffer();
	public static void main(String[] args) throws Exception{
        int v[] = new int[N+1];
        for(int i=1; i<=N; i++){
           int sum = i;
            int n = i;
           while(true){
               sum += n%10;
               n = n/10;
               if(n==0){ break; }
           }
           if(sum >=N) continue;
           v[sum]++;
           }

        for(int i=1; i<N; i++){
            if(v[i]==0){
                sb.append(i).append("\n");
            }
        }
        
        System.out.println(sb);
        
	}
}
