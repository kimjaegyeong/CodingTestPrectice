import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int M;
    static final long MOD = 1000000007L;

    static long simul(int start) {
        long[][] dp = new long[M][26];
        dp[0][start] = 1L;

        for (int i = 0; i < M - 1; i++) {
            for (int j = 0; j < 26; j++) {
                if (dp[i][j] == 0) continue;
                long cur = dp[i][j];
                for (int k = 0; k < 26; k++) {
                    if (Math.abs(k - j) >= N) {
                        dp[i + 1][k] = (dp[i + 1][k] + cur) % MOD;
                    }
                }
            }
        }

        long sum = 0L;
        for (int i = 0; i < 26; i++) {
            sum = (sum + dp[M - 1][i]) % MOD;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        long ans = 0L;
        for (int s = 0; s < 26; s++) {
            ans = (ans + simul(s)) % MOD;
        }

        System.out.println(ans);
    }
}
