import java.util.*;
import java.io.*;

class People implements Comparable<People>{
    String name;
    long v;
    
    public People(String name, long v){
        this.name= name;
        this.v = v;
    }
    
    public String toString(){
        return name + " " + v;
    }
    public int compareTo(People p){
        if(this.v > p.v) {
            return -1;
        }if(this.v < p.v) {
            return 1;
        }else{
            return this.name.compareTo(p.name);
        }
    }
}
public class Main
{
    static int N;
    
    static People p[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		p = new People[N];
		for(int i=0; i<N; i++){
		    
		StringTokenizer st =new StringTokenizer(br.readLine());
		    String n = st.nextToken();
		    long v = Long.parseLong(st.nextToken());
		    
		    p[i] = new People(n,v);
		    
		}
		
		Arrays.sort(p);
	    System.out.println(p[0].name);
	    
	    
	    
	}
}
