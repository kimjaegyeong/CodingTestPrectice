import java.util.*;
import java.io.*;

public class Main
{
	static int H,W;
	static int X,Y;
	static int[][] B;
	static int[][] A;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		B = new int[H+Y][W+X];
		A = new int[H][W];
		for(int i=0; i<H+Y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<W+X; j++) {
				B[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<H; i++){
		    for(int j=0; j<W; j++){
		        if(i - Y < 0 || j - X < 0) {
		            A[i][j] = B[i][j];
		        }
		        else {
		            A[i][j] = B[i][j] - A[i-Y][j-X];
		        }
		    }
		}
		
		for(int i=0; i<H; i++){
		    for(int j=0; j<W; j++){
		        sb.append(A[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
