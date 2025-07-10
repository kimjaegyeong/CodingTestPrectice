import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int max = 0;

    // 부메랑의 4가지 방향 (중심은 (0,0))
    static int[][][] boomerang = {
        { {0, 0}, {1, 0}, {0, -1} }, // 아래 + 왼쪽
        { {0, 0}, {-1, 0}, {0, -1} }, // 위 + 왼쪽
        { {0, 0}, {-1, 0}, {0, 1} }, // 위 + 오른쪽
        { {0, 0}, {1, 0}, {0, 1} }, // 아래 + 오른쪽
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(max);
    }

    static void dfs(int index, int sum) {
        if (index == N * M) {
            max = Math.max(max, sum);
            return;
        }

        int y = index / M;
        int x = index % M;

        if (!visited[y][x]) {
            for (int[][] shape : boomerang) {
                boolean canPlace = true;
                int tempSum = 0;
                List<int[]> used = new ArrayList<>();

                for (int[] d : shape) {
                    int ny = y + d[0];
                    int nx = x + d[1];

                    if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) {
                        canPlace = false;
                        break;
                    }

                    used.add(new int[]{ny, nx});
                }

                if (canPlace) {
                    int centerY = y + shape[0][0];
                    int centerX = x + shape[0][1];
                    tempSum += map[centerY][centerX] * 2;

                    for (int i = 1; i < 3; i++) {
                        int ny = y + shape[i][0];
                        int nx = x + shape[i][1];
                        tempSum += map[ny][nx];
                    }

                    for (int[] pos : used) {
                        visited[pos[0]][pos[1]] = true;
                    }

                    dfs(index + 1, sum + tempSum);

                    for (int[] pos : used) {
                        visited[pos[0]][pos[1]] = false;
                    }
                }
            }
        }

        dfs(index + 1, sum);
    }
}
