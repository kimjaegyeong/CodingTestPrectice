import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static char[] exp;
    static long[][] maxDp, minDp;
    static int n;
    static long[] nums;
    static char[] opers;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        exp = br.readLine().toCharArray();

        n = (N + 1) / 2; 
        nums = new long[n];
        opers = new char[n - 1];

        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) nums[i / 2] = exp[i] - '0';
            else opers[i / 2] = exp[i];
        }

        maxDp = new long[n][n];
        minDp = new long[n][n];

        for (int i = 0; i < n; i++) {
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }

        for (int len = 1; len < n; len++) {
            for (int i = 0; i + len < n; i++) {
                int j = i + len;
                maxDp[i][j] = Long.MIN_VALUE;
                minDp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    char op = opers[k];

                    long[] res = combine(minDp[i][k], maxDp[i][k], minDp[k + 1][j], maxDp[k + 1][j], op);

                    minDp[i][j] = Math.min(minDp[i][j], res[0]);
                    maxDp[i][j] = Math.max(maxDp[i][j], res[1]);
                }
            }
        }

        System.out.println(maxDp[0][n - 1]);
    }

    public static long[] combine(long aMin, long aMax, long bMin, long bMax, char op) {
        long[] res = new long[]{
            calc(aMin, bMin, op),
            calc(aMin, bMax, op),
            calc(aMax, bMin, op),
            calc(aMax, bMax, op)
        };

        long min = res[0];
        long max = res[0];
        for (int i = 1; i < 4; i++) {
            min = Math.min(min , res[i]);
            max = Math.max(max, res[i]);
        }

        return new long[]{min, max};
    }

    public static long calc(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return  -1;
    }
}
