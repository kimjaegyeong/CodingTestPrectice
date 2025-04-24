import java.util.*;
import java.io.*;

public class Main
{
    static int T;

	static String input = null;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
	    T = Integer.parseInt(br.readLine());
	    for(int t=0; t<T; t++){
	        input = br.readLine();
	        N = input.length();
	        if(input.length() == 1) {
	            sb.append("YES").append("\n");
	            continue;
	        }
	        boolean result =div(0, N-1);
	        
	        if(result) {
	            sb.append("YES").append("\n");
	        }else{
	            sb.append("NO").append("\n");
	        }
	       
	    }
	    
	    System.out.println(sb);
	}
	

    private static boolean div(int start, int end) {
        if (start == end) {
            return true;
        }
        int mid = (start + end) / 2;
        for (int i = start; i < mid; i++) {
            if (input.charAt(i) == input.charAt(end - i)) {
                return false;
            }
        }
        return div(start, mid - 1) && div(mid + 1, end);
    }
}
