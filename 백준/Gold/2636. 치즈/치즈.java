import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static class Node {
		int y, x, cnt;

		public Node(int y, int x, int cnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
		}
	}

	// 시뮬레이션 + bfs
	// 반복
	// 1. 공기를 모두 탐색하면서 공기 주변의 치즈를 발견하면 치즈의 자료구조에 담는다
	// 2. 치즈의 자료구조를 모두 돌면서 공기로 바꾸고 그걸 다시 공기의 자료구조에 담는다
	// 위 1회 반복이 1시간
	static int R, C;
	static int hour, cheeseSize;
	static int[][] map;
	static int[][] visitAir;
	static int[][] visitCheese;
	static Queue<Node> queueAir = new ArrayDeque<>();
	static Queue<Node> queueCheese = new ArrayDeque<>();
	static int[] dy = { 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0 };
	static boolean flag = false;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visitAir = new int[R][C];
		visitCheese = new int[R][C];

		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		while (true) {
			bfs();
			if (queueCheese.isEmpty())
				break;
			removeCheese();
			hour++;
		}
        System.out.println(hour);
		System.out.println(cheeseSize);

	}

	static void removeCheese() {
		cheeseSize = queueCheese.size();
		while (!queueCheese.isEmpty()) {
			Node n = queueCheese.poll();
			visitAir[n.y][n.x] = 1;
			queueAir.offer(n);
		}
	}

	static void bfs() {
		queueAir.offer(new Node(0, 0, 0));
		while (!queueAir.isEmpty()) {
			Node node = queueAir.poll();
			for (int i = 0; i < 4; i++) {
				int ny = node.y + dy[i];
				int nx = node.x + dx[i];

				if (ny >= R || nx >= C || ny < 0 || nx < 0) {
					continue;
				}
				if (visitAir[ny][nx] > 0)
					continue;
				if (map[ny][nx] == 1) {
					if (visitCheese[ny][nx] == 1)
						continue;
					visitCheese[ny][nx] = 1;
					queueCheese.add(new Node(ny, nx, 0));
					continue;
				}

				visitAir[ny][nx] = 1;
				queueAir.offer(new Node(ny, nx, node.cnt + 1));
			}
		}
	}

	// dfs로 0의 영역 찾기 -> 임의의 좌표부터 dfs하면서 visited한다 (모든 0인 좌표 에 대해서) dfs 종료,
	// for문에서 새로운 0인 영역이라면 visited하면서 벽과 만나는지를 확인한다. (범위 밖 체크와 다름)
	// 새로운 0의 영역에서 범위 밖 체크가 한 번도 없었다면, 해당 범위 (visited[] = n)는 구멍이다.

}

// bfs하며 0과 맞닿은 영역을 모두 queue에 넣음

// queue에 들어가있는 모든 좌표를 0으로 변경
// 위의 행동을 계속 반복, 치즈조각을 계속 min 으로 갱신하며, 0이 아닌 모든 min을 저장한다.
