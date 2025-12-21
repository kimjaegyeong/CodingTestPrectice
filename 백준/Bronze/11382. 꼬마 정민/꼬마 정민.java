import java.util.*;
import java.io.*;
public class Main
{
    static long A;
    static long B;
    static long C;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		A= Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
        C = Long.parseLong(st.nextToken());
        
        System.out.println(A+B+C);
	}
}
