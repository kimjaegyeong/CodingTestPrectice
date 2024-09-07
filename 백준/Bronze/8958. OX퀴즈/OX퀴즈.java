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
        static int T;
            
    
        
	public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for(int i=0; i<T; i++){
            String inputs[] = br.readLine().split("");
            int total =0;
            int sum =0;
            for(int j=0; j<inputs.length; j++){
                if(inputs[j].equals("O")){
                    sum++;
                    total +=sum;
                }else{

                    sum = 0;
                }
            }
            
            System.out.println(total);
        }
    }
    
}
