import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[][] map;
    static boolean[][] visited;
    static int x1,y1,x2,y2;
    static int[] dy = {1,-1,0,0};
    static int[] dx = {0,0,1,-1};

    static class Node{
        int y,x;
        int d;
        public Node(int y, int x, int d){
            this.y= y;
            this.x= x;
            this.d = d;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[501][501];
        visited = new boolean[501][501];
        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            for(int j = Math.min(x2,x1); j<=Math.max(x2,x1); j++){
                for(int k= Math.min(y1,y2); k<=Math.max(y1,y2); k++){
                    map[k][j] = 1;
                }
            }
        }
        M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            //x1,x2 랑 y1,y2 작은 좌표 구분 안 되어 있음

            for(int j = Math.min(x2,x1); j<=Math.max(x2,x1); j++){
                for(int k= Math.min(y1,y2); k<=Math.max(y1,y2); k++){
                    map[k][j] = -1;
                }
            }
        }

        //bfs 하자
        Deque<Node> queue = new ArrayDeque();
        queue.offer(new Node(0,0,0));
        visited[0][0] = true;
        Node n =null;
        while(!queue.isEmpty()){
             n =queue.poll();
             if(n.x ==500 && n.y==500){
                break;
             }
            for(int i=0; i<4; i++){
                int ny = n.y + dy[i];
                int nx= n.x + dx[i];
                if(ny >=501 || nx>=501 || nx<0 || ny<0 || map[ny][nx] == -1 || visited[ny][nx]){
                    continue;
                }

                if(map[ny][nx] == 1){
                    queue.offerLast(new Node(ny,nx,n.d+1));

                }else{
                    queue.offerFirst(new Node(ny,nx,n.d));
                }
                visited[ny][nx] =true;

            }
        }
        if(visited[500][500]!=true){
            System.out.println(-1);
        }else{
            System.out.println(n.d);
        }
    }
}
