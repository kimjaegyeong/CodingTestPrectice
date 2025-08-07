import java.util.*;
import java.io.*;

public class Main {
    static class Shark {
        int y, x, s, d, z;
        public Shark(int y, int x, int s, int d, int z) {
            this.y = y;
            this.x = x;
            this.s = s;
            this.d = d;
            this.z = z;
        }
        public String toString() {
            return "" + z;
        }
    }

    static int N, M, S;
    static int[] dy = {-1, 1, 0, 0}; // 상하우좌
    static int[] dx = {0, 0, 1, -1};
    static Shark[][] ug;
    static int ans = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        ug = new Shark[N][M];

        for (int i = 0; i < S; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            ug[y][x] = new Shark(y, x, s, d, z);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (ug[j][i] != null) {
                    ans += ug[j][i].z;
                    ug[j][i] = null;
                    break;
                }
            }
            
            Shark[][] newUg = new Shark[N][M];

            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (ug[y][x] != null) {
                        Shark shark = ug[y][x];
                        int dir = shark.d;
                        int speed = shark.s;
                        int ny = shark.y;
                        int nx = shark.x;

                        int move = (dir < 2) ? speed % (2 * (N - 1)) : speed % (2 * (M - 1));

                        for (int m = 0; m < move; m++) {
                            ny += dy[dir];
                            nx += dx[dir];
                            if (!check(ny, nx)) {
                                dir = changeDir(dir);
                                ny += dy[dir] * 2;
                                nx += dx[dir] * 2;
                            }
                        }

                        if (newUg[ny][nx] == null || newUg[ny][nx].z < shark.z) {
                            newUg[ny][nx] = new Shark(ny, nx, speed, dir, shark.z);
                        }
                    }
                }
            }

            ug = newUg;
        }

        System.out.println(ans);
    }

    public static boolean check(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }

    public static int changeDir(int dir) {
        if (dir == 0 || dir == 1) return 1 - dir;
        return 5 - dir;
    }
}
