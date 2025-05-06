import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dy = {0, 1}; // 오른쪽, 아래
    static int[] dx = {1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(bfs() ? "Yes" : "No");
    }

    static boolean bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        if (map[0][0] == 1) {
            queue.offer(new int[]{0, 0});
            visited[0][0] = true;
        }

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int y = current[0];
            int x = current[1];

            if (y == M - 1 && x == N - 1) {
                return true;
            }

            for (int i = 0; i < 2; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny >= 0 && ny < M && nx >= 0 && nx < N) {
                    if (!visited[ny][nx] && map[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        queue.offer(new int[]{ny, nx});
                    }
                }
            }
        }

        return false;
    }
}