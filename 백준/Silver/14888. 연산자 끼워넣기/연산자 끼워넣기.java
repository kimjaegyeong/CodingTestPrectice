import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] oper;     
    static int[] value;
    static int[] visited;
    static int MAX = Integer.MIN_VALUE;
    static int MIN = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        value = new int[N];
        oper = new int[N - 1];
        visited = new int[N - 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        int idx = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                oper[idx++] = i; // 연산자 저장: + = 0, - = 1, * = 2, / = 3
            }
        }

        dfs(value[0], 0); 
        System.out.println(MAX);
        System.out.println(MIN);
    }

    public static void dfs(int result, int depth) {
        if (depth == N - 1) {
            MAX = Math.max(MAX, result);
            MIN = Math.min(MIN, result);
            return;
        }

        for (int i = 0; i < N - 1; i++) {
            if (visited[i] == 0) {
                visited[i] = 1;

                int nextResult = calculate(result, value[depth + 1], oper[i]);
                dfs(nextResult, depth + 1);

                visited[i] = 0; // 백트래킹
            }
        }
    }

    public static int calculate(int a, int b, int op) {
        switch (op) {
            case 0: return a + b;
            case 1: return a - b;
            case 2: return a * b;
            case 3:
                if (a < 0) {
                    return -(-a / b);
                } else {
                    return a / b;
                }
        }
        return 0; 
    }
}
