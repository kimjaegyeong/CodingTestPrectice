import java.util.*;
import java.io.*;
public class Main
{
    static int N = 20;
    static double cnt = 0.0;
    static double total = 0.0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i=0; i<N; i++){
		    StringTokenizer st  = new StringTokenizer(br.readLine());
		    String input= st.nextToken();
		    double rating = Double.parseDouble(st.nextToken());
		    String gradeStr = st.nextToken();
		    if(gradeStr.equals("P")){
		        continue;
		    }
		    cnt+=rating;
		    
		    if(gradeStr.equals("A+")){
		        total += 4.5 * rating;
		    }else if(gradeStr.equals("A0")){
		        total+=4.0  * rating;
		    }else if(gradeStr.equals("B+")){
		        total+=3.5  * rating;
		    }else if(gradeStr.equals("B0")){
		        total+=3.0  * rating;
		    }else if(gradeStr.equals("C+")){
		        total+=2.5 * rating;
		    }else if(gradeStr.equals("C0")){
		        total+=2.0 * rating;
		    }else if(gradeStr.equals("D+")){
		        total+=1.5 * rating;
		    }else if(gradeStr.equals("D0")){
		        total+=1.0 * rating;
		    }
		}
		
		System.out.printf("%.6f",(total/cnt));
	}
}
