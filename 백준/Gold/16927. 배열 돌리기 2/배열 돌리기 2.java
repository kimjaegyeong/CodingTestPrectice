import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static long R;
	static int v[][];
	static int temp = 0;
	static int sy,sx;
	static int[] shells;
	static int idx =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Long.parseLong(st.nextToken());

		v = new int[N][M];
		shells = new int[100000];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				v[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		getShells();
        
		sy =0 ;
		sx = 0 ;
		for(int i=0; i< idx ; i++) {
				for(int j=0; j< R % shells[i] ; j++){
				    rotate();				    
				}

				sy++;
				sx++;
			}

		

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				sb.append(v[i][j]).append(" ");
			}
			sb.append("\n");
		}


		System.out.println(sb);


	}

	public static void rotate() {
		temp = v[sy][sx] ;
		//top
		for(int i=sx+1; i<M - sx; i++) {
			v[sy][i-1] = v[sy][i];
		}
		//right
		for(int i = sy+1; i<N - sy ; i++) {
			v[i-1][M - sx - 1] = v[i][M - sx- 1];
		}
		//botton

		for(int i= M - sx -1 ; i > sx; i--) {
			v[N - sy- 1][i] = v[N - sy - 1][i-1];
		}
		//left
		for(int i= N -sy - 1 ; i > sy; i--) {
			v[i][sx] = v[i-1][sx];
		}

		v[sy+1][sx] = temp;

	}

	public static void getShells() {
		int y = N;
		int x = M;
		while(true) {
			if(y <=0 || x<=0 ) break;
			shells[idx] = x * 2 + (y-2) * 2 ;
			idx++;
			y = y-2;
			x= x-2;
		}
	}

}

