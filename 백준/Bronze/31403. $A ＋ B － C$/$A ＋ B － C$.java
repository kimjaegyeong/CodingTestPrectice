import java.util.*;
import java.io.*;
public class Main
{
    static String A;
    static String B;
    static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		A = br.readLine();
		B = br.readLine();
		
		int temp = Integer.valueOf( (A + B) );
		
		int C = Integer.parseInt(br.readLine());
		
		System.out.println( Integer.parseInt(A)  + Integer.parseInt(B) - C);
		System.out.print(temp - C);
		
	}
}
