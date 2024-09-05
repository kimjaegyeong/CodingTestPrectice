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
    static   int count =0 ;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int origin = Integer.parseInt(br.readLine());
        int real = origin;
        while(true){
        if(origin == real && count >0){ 
            break;}

        if(origin < 10) {
            origin = origin * 10 + origin; 
         
            count++;
            continue;
        }
        int first = origin/10;
        int second = origin%10;
        int new_val = first+ second;

        origin = second*10 + (new_val%10);    

        count++;
        }
        
        System.out.println(count);
	}
}
