import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] score;
    static int mapia;
    static int[] board;
    static boolean[] flag; // deadNum 대신 boolean 배열로 생존 여부 관리 (가장 안전)
    static int max = 0; // 최소 0번의 밤은 지나므로 0으로 초기화

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        board = new int[N];
        score = new int[N][N];
        flag = new boolean[N];

        for (int i = 0; i < N; i++) {
            board[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        mapia = Integer.parseInt(br.readLine());

        int currentN = N;
        if (currentN % 2 != 0) {
            int idx = -1;
            int maxScore = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                if (maxScore < board[i]) {
                    maxScore = board[i];
                    idx = i;
                }
            }
            if (idx == mapia) {
                System.out.println(0);
                return;
            }
            flag[idx] = true;
            currentN--;
        }

        dfs(1, currentN);
        System.out.println(max);
    }

    public static void dfs(int cnt, int remain) {
        for (int i = 0; i < N; i++) {
            if (flag[i] || i == mapia) continue;

            flag[i] = true;
            for (int j = 0; j < N; j++) {
                if (!flag[j]) board[j] += score[i][j];
            }

            int mScore = Integer.MIN_VALUE;
            int mDeadPerson = -1;
            for (int j = 0; j < N; j++) {
                if (!flag[j]) {
                    if (mScore < board[j]) {
                        mScore = board[j];
                        mDeadPerson = j;
                    }
                }
            }

            flag[mDeadPerson] = true;

            if (mDeadPerson == mapia) {
                max = Math.max(max, cnt);
            } else if (remain - 2 <= 1) {
                max = Math.max(max, cnt);
            } else {
                dfs(cnt + 1, remain - 2);
            }

        
            recoverMatrix(i, mDeadPerson);
        }
    }

    public static void recoverMatrix(int nDeadPerson, int mDeadPerson) {
        flag[mDeadPerson] = false;

        for (int i = 0; i < N; i++) {
            if (!flag[i]) {
                board[i] -= score[nDeadPerson][i];
            }
        }
        flag[nDeadPerson] = false;
    }
}