import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Node {
    int y, x, key;
    int cost;

    public Node(int y, int x, int key, int cost) {
        this.y = y;
        this.x = x;
        this.key = key;
        this.cost = cost;
    }
}

public class Main {
    static int N, M;
    static char[][] map;
    static boolean[][][] visit;
    static Deque<Node> queue = new ArrayDeque<>();
    static int[] dy = { 0, 0, 1, -1 };
    static int[] dx = { 1, -1, 0, 0 };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[(1 << 6) + 1][N][M]; // a,b,c,d,e,f

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '0') {
                    queue.offer(new Node(i, j, 0, 0));
                    map[i][j] = '.';
                }
            }
        }
        System.out.println(bfs());

    }

    static public int bfs() {

        while (!queue.isEmpty()) {
            Node now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int ny = now.y + dy[i];
                int nx = now.x + dx[i];
                if (ny >= N || nx >= M || nx < 0 || ny < 0 || visit[now.key][ny][nx]) {
                    continue;
                }
                if (map[ny][nx] == '#') {
                    continue;
                } else if (map[ny][nx] == '.') {
                    queue.offer(new Node(ny, nx, now.key, now.cost + 1));
                    visit[now.key][ny][nx] = true;

                } else if (map[ny][nx] == '1') {
                    return now.cost + 1;

                    // 열쇠인 경우
                } else if (map[ny][nx] - 97 >= 0) {
                    int keyMask = now.key | (1 << (map[ny][nx] - 97));
                    queue.offer(new Node(ny, nx, keyMask, now.cost + 1));
                    visit[now.key][ny][nx] = true;
                    //visit[keyMask][ny][nx] = true;


                } else {
                    // 문짝인 경우
                    // 가지고 있는 열쇠로 문을 열 수 있으면
                    if ((now.key & (1 << map[ny][nx] - 65)) == 1 << (map[ny][nx] - 65)) {
                        queue.offer(new Node(ny, nx, now.key, now.cost + 1));
                        visit[now.key][ny][nx] = true;
                    }
                }

            }
        }
        return -1;
    }

}
