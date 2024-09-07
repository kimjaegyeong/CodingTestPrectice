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
	public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int ans = 0;
        for(int i=1; i<=N; i++){
            if(i<10 ){
                ans++;
            }
            else if((i>=10) && (i<100)){
                String num = String.valueOf(i);
                if((Math.abs(num.charAt(0) - num.charAt(1))) >= 0 ){
                
                    ans++;
                }


            }else if(i>=100){
                String num = String.valueOf(i);
               if((num.charAt(0) - num.charAt(1)) == (num.charAt(1) - num.charAt(2)) ){
                                       
                   ans++;
               }
            }
        }
        System.out.println(ans);
	}
}
