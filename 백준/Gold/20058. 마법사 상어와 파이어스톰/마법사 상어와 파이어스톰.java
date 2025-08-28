import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int Q;
    static int dy[] = {1,-1,0,0};
    static int dx[] = {0,0,1,-1};
    static int size;
    static int map[][];
    static int[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        size = (int) Math.pow(2.0,(double) N);

        map = new int[size][size];
        visited = new int[size][size];
        for(int i=0; i<size; i++) {
            st= new StringTokenizer(br.readLine());
            for(int j=0; j<size; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<Q; i++) {
            int q = Integer.parseInt(st.nextToken());
            execute(q);
            removeIce();
        }
        System.out.println(allIce());
        System.out.println(maxIce());
    }

    public static void execute(int l) {
        int b = 1 << l;
        for(int i=0; i<size; i+=b) {
            for(int j=0; j<size; j+=b) {
                rotate(i, j, b);
            }
        }
    }

    public static void rotate(int sy, int sx, int b) {
        int[][] tmp = new int[b][b];
        for(int i=0; i<b; i++) {
            for(int j=0; j<b; j++) {
                tmp[j][b - 1 - i] = map[sy + i][sx + j];
            }
        }
        for(int i=0; i<b; i++) {
            for(int j=0; j<b; j++) {
                map[sy + i][sx + j] = tmp[i][j];
            }
        }
    }

    public static int maxIce() {
        visited = new int[size][size];
        int num = 1;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(visited[i][j] != 0 || map[i][j] == 0) continue;
                visited[i][j] = num;
                bfs(i,j, num);
                num++;
            }
        }
        int v[] = new int[size*size +1];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                v[visited[i][j]]++;
            }
        }
        int max =0;
        for(int i=1; i<v.length; i++){
            max = Math.max(max, v[i]);
        }
        return max;
    }

    public static void bfs(int y, int x, int num) {
        ArrayDeque<int[]> q= new ArrayDeque<int[]>();
        q.offer(new int[] {y,x});
        while(!q.isEmpty()) {
            int[] n = q.poll();
            for(int i=0; i<4; i++) {
                int ny = n[0] + dy[i];
                int nx= n[1] + dx[i];
                if(!check(ny,nx) || visited[ny][nx] != 0 || map[ny][nx] ==0) continue;
                q.offer(new int[] {ny,nx});
                visited[ny][nx] = num;
            }
        }
    }

    public static int allIce() {
        int cnt=0;
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                cnt+= map[i][j];
            }
        }
        return cnt;
    }

    public static void removeIce() {
        boolean[][] melt = new boolean[size][size];
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(map[i][j] == 0) continue;
                int cnt=0;
                for(int d=0; d<4; d++) {
                    int ny = i + dy[d];
                    int nx = j + dx[d];
                    if(!check(ny,nx)) continue;
                    if(map[ny][nx] > 0) cnt++;
                }
                if(cnt < 3) {
                    melt[i][j] = true;
                }
            }
        }
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(melt[i][j]) map[i][j]--;
            }
        }
    }

    public static boolean check(int y, int x) {
        return y<size && x<size && y>=0 && x>=0;
    }
}
