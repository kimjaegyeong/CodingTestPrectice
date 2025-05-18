import java.util.*;
import java.io.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int max = 1; // 최소값은 1 (1x1 정사각형)

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        map = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }
        
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < M; x++) {
                for (int size = 1; y + size < N && x + size < M; size++) {
                    if (map[y][x] == map[y][x + size] &&
                        map[y][x] == map[y + size][x] &&
                        map[y][x] == map[y + size][x + size]) {
                        int area = (size + 1) * (size + 1); 
                        max = Math.max(max, area);
                    }
                }
            }
        }
        
        System.out.println(max);
    }
}
