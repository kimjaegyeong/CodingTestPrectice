
import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int M;
	static int nodes[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		nodes = new int[N+1][N+1];

		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			nodes[a][b] = 1;
			nodes[b][a] = -1;
		}

		for(int k=1; k<N+1; k++) {
			for(int i=1; i<N+1; i++) {
				for(int j=1; j<N+1; j++) {
					if(nodes[k][j] ==1 &&  nodes[i][k]==1) {
						nodes[i][j] = 1;
					}
					if(nodes[k][j]==-1 && nodes[i][k] ==-1){
					    nodes[i][j] = -1;
					}
				}
			}
		}


		for(int i=1; i<N+1; i++) {
			int result = 0;
			for(int j=1; j<N+1; j++) {

				if(nodes[i][j] != 0 ) {
					result ++;
				}
			}

// 			System.out.println((N - result - 1));
            sb.append((N - result - 1)).append("\n");
		}
    System.out.println(sb);
	}

}
