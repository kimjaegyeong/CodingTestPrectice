import java.util.*;
import java.io.*;
class Ball {
	int position;
	int direction;

	Ball(int position, int direction) {
		this.position = position;
		this.direction = direction;
	}
}

public class Main {
	static int L;
	static int N;
	static int T;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		Ball[] balls = new Ball[N + 1];

		for (int i = 1; i <= N; i++) {
		    st = new StringTokenizer(br.readLine());
	        int position = Integer.parseInt(st.nextToken());
	        int direction = st.nextToken().equals("R")  ? 1 : -1 ;
	        
			balls[i] = new Ball(position, direction);
		}

		int ans = 0;

		for (int t = 1; t <= T; t++) {
			Map<Integer, List<Integer>> box = new HashMap<>();


			for (int i = 1; i <= N; i++) {
				Ball ball = balls[i];
                
                ball.position = ball.position + ball.direction;
                if(ball.position == 0 || ball.position == L){
                    ball.direction = ball.direction ==1? -1 : 1; 
                }

				box.putIfAbsent(ball.position, new ArrayList<>());
				box.get(ball.position).add(i);
			}

			for (List<Integer> indexes : box.values()) {
				if (indexes.size() == 2) {
					ans++;
					for (int idx : indexes) {
						Ball ball = balls[idx];
						ball.direction = -ball.direction;
					}
				}
			}
		}

		System.out.println(ans);

	}
}
