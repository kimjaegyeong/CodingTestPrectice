/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.*;
import java.io.*;


  class Node implements Comparable<Node>{
       public int a;
        public    int b;
        public Node(int a, int b){
            this.a = a;
            this.b = b;
        }
        
        public int compareTo(Node o){
            return this.a -  o.a ==0 ? this.b - o.b : this.a - o.a;
        }
    }

public class Main
{
        static int N;
            
    
        
	public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Node> list = new ArrayList<Node>();
        for(int i=0; i<N; i++ ){
            String inputs[] = br.readLine().split(" ");
            list.add(new Node(Integer.parseInt(inputs[0]),Integer.parseInt(inputs[1])));
        }
        
        Collections.sort(list);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i).a + " " + list.get(i).b);

        }
        
	}

}
