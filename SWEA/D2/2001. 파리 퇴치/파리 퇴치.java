import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int tc = 1; tc <= T; tc++) {
            int max = Integer.MIN_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[][] map = new int[N][N];
            int[][] sumMap = new int[N + 1][N + 1];
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < N; i++) {
                String input[] = br.readLine().split(" ");
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(input[j]);
                    sumMap[i+1][j+1] = map[i][j] + sumMap[i+1][j] + sumMap[i][j+1] - sumMap[i][j];
                }

            }

            for(int i=1; i<= N-M +1 ; i++){
                for(int j=1; j<=N-M +1 ; j++){
                    int sum = sumMap[M + i - 1][M + j - 1] - sumMap[M + i - 1][j - 1] - sumMap[i - 1][M + j - 1] + sumMap[i - 1][j - 1];
                    max = Math.max(sum, max);
                }
            }

            System.out.println("#"+tc+" " + max);

        }
    }
}
