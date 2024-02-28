import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int K;
    static int map[][];
    static int[][] jump = { { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 }, { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 } };
    static int[] jump_y = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int[] jump_x = {-1, 1, -2, 2, -2, 2, -1, 1};
    static int[] dy = { 1, -1, 0, 0 };
    static int[] dx = { 0, 0, 1, -1 };
    static boolean visited[][][];
    static int min = 10000;
    static class Node {
        int x, y, k;
        int cnt;

        @Override
        public String toString() {
            return "Node [x=" + x + ", y=" + y + ", k=" + k + ", cnt=" + cnt + "]";
        }

        public Node(int y, int x, int k, int cnt) {
            super();
            this.x = x;
            this.y = y;
            this.k = k;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited= new boolean[N][M][K+1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Deque<Node> q = new ArrayDeque<>();
        q.offer(new Node(0, 0, K, 0));
        visited[0][0][K]  = true;
        while (!q.isEmpty()) {
            Node node = q.poll();
            if(node.y == N-1 && node.x == M-1) {
                min = node.cnt;
                System.out.println(min);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int ny = node.y + dy[i];
                int nx = node.x + dx[i];

                if(nx >= 0 && ny >= 0 && nx < M && ny < N ){
                    if(!visited[ny][nx][node.k] && map[ny][nx] == 0){
                        visited[ny][nx][node.k]=true;
                        q.offer(new Node(ny, nx, node.k, node.cnt + 1));

                    }
                }


            }

            if (node.k > 0) { // 말처럼 움직일 수 있는 기회가 남아있는 경우
                for (int i = 0; i < jump.length; i++) {
                    int ny = node.y + jump[i][0];
                    int nx = node.x + jump[i][1];
                    if(nx >= 0 && ny >= 0 && nx < M && ny < N ){
                        if(!visited[ny][nx][node.k-1] && map[ny][nx] == 0){
                            visited[ny][nx][node.k-1]=true;
                            q.offer(new Node(ny, nx, node.k-1, node.cnt + 1));

                        }
                    }
                }
            }

        }
        System.out.println(-1);

    }

}
