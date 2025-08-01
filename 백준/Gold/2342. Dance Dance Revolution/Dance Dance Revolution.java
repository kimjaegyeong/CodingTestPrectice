import java.util.*;
import java.io.*;

public class Main {
    static int[] map;
    static int[][][] dp;
    static int INF = 10000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        List<Integer> input = new ArrayList<>();
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            input.add(num);
        }

        int n = input.size();
        map = new int[n + 1]; // map[0] = 0 (시작 위치)
        for (int i = 0; i < n; i++) {
            map[i + 1] = input.get(i);
        }

        dp = new int[n + 1][5][5];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        dp[0][0][0] = 0; // 시작은 양발이 0

        for (int i = 1; i <= n; i++) {
            int move = map[i];
            for (int l = 0; l < 5; l++) {
                for (int r = 0; r < 5; r++) {
                    if (dp[i - 1][l][r] == INF) continue;
                    if (move != r) { // 왼발로 이동
                        dp[i][move][r] = Math.min(dp[i][move][r], dp[i - 1][l][r] + calCost(l, move));
                    }
                    if (move != l) { // 오른발로 이동
                        dp[i][l][move] = Math.min(dp[i][l][move], dp[i - 1][l][r] + calCost(r, move));
                    }
                }
            }
        }

        int answer = INF;
        for (int l = 0; l < 5; l++) {
            for (int r = 0; r < 5; r++) {
                answer = Math.min(answer, dp[n][l][r]);
            }
        }

        System.out.println(answer);
    }

    public static int calCost(int from, int to) {
        if (from == 0) return 2;
        if (from == to) return 1;
        if (Math.abs(from - to) == 2) return 4;
        return 3;
    }
}
