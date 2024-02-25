
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;
public class Main {
	static int N,L;
	static int[] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i]= Integer.parseInt(st.nextToken());
		}
		Arrays.sort(map);		
		for(int i=0; i<N; i++) {
			if(map[i] <= L) {
				L++;
			}else {
				break;
			}
		}
		System.out.println(L);
	}

}
