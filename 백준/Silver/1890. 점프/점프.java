import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] map;
    static long[][] dp; 

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new long[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int v = map[i][j];
                if (v == 0) continue;

                if (j + v < N) dp[i][j + v] += dp[i][j];
                if (i + v < N) dp[i + v][j] += dp[i][j];
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
