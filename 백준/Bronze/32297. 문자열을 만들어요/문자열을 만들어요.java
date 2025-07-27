import java.util.*;
import java.io.*;
public class Main
{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String input = br.readLine();
		if(input.contains("gori")) {
		    System.out.println("YES");
		}else{
		    System.out.println("NO");
		}
	}
}
