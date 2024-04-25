
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int K;
	static int[] map;
	static int[] dir= {-1,1,2};
	static int max = 100000;
	static int min = Integer.MAX_VALUE;
	static int cnt=0;
	static int[][] visit ;
	static Queue<int[]> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st  = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		map = new int[100001];
		visit = new int[100001][3];
		queue.offer(new int[] {N,0}); 
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			//가장 빠른 시간을 처음 찾았을 때 
			if(now[0] == K && min >= now[1] && min==Integer.MAX_VALUE) { 
				min = now[1];
				cnt++;
				continue;
			}else if(now[0] == K && min == now[1]) { //이미 가장 빠른 시간이 고정되어있을 때
				cnt++;
				continue;
			}
			for(int i=0; i<3; i++) {
				int nxt = 0;
				switch(i) {
				 case 0: nxt = now[0] + dir[i]; break;
				 case 1: nxt = now[0] + dir[i]; break;
				 case 2: nxt = now[0] * dir[i]; break;
				}
				if(nxt > max|| nxt <0 || (visit[nxt][i]!=0 && visit[nxt][i] < now[1]+1)) {
					continue;
				}

				visit[nxt][i] = now[1]+1;
				
				queue.offer(new int[] {nxt, now[1]+1});
				
			}
		}
		System.out.println(min);
		System.out.println(cnt);
		
		
	}

}
