import java.util.*;
import java.io.*;
public class Main
{
	static int N;

	static int b = 5;
	static int m = 1;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			for(int j=0; j< b * N; j++) {
				sb.append("@");
			}
			sb.append("\n");
		}

		for(int i=0; i<N * 3; i++ ) {
			for(int j=0; j< m * N; j++) {
				sb.append("@");
			}
			sb.append("\n");
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j< b * N; j++) {
				sb.append("@");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
