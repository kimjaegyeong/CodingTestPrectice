import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;

	static int map[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new int[M][M];

		for(int i=0; i<M; i++) {
			map[0][i] ++;
			map[i][0]++;
		}

		map[0][0] --;

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());

			int s = 0 ;
			int e= Integer.parseInt(st.nextToken());

			int cnt =1;
			s = e;
			e += Integer.parseInt(st.nextToken());

			for(int j=s; j<e; j++) {

				if(j >= M) {
					map[0][j - M +1] +=  cnt;
				} else {
					map[M -1 - j][0] += cnt;
				}


			}

			cnt++;
			s = e;
			e += Integer.parseInt(st.nextToken());

			for(int j=s; j<e; j++) {

				if(j >= M) {
					map[0][j - M +1] +=  cnt;
				} else {
					map[M -1 - j][0] += cnt;
				}
			}

		}
		//Execution for N days is now complete
		
		for(int i=1; i<M; i++){
		
		    for(int j=i; j<M; j++){
		        //->  
		        map[i][j] = Math.max(map[i][j-1], map[i-1][j]);
		    }
		    
		    for(int j=i; j<M; j++){
		        //↓
		        map[j][i]= Math.max(map[j][i-1], map[j-1][i]);
		    }
		}
		
		for(int i=0; i<M; i++){
		    for(int j=0; j<M; j++){
		        sb.append(map[i][j]).append(" ");
		    }
		    sb.append("\n");
		}
		
		System.out.println(sb);

	}
}
