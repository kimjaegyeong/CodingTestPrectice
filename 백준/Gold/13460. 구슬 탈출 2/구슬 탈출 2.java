import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Marble{
    Node red;
    Node blue;
    int cnt;

    public Marble(Node red, Node blue, int cnt){
        this.red = red;
        this.blue = blue;
        this.cnt = cnt;
    }
}

class Node{
    int y;
    int x;

    public Node(int y, int x){
        this.y= y;
        this.x =x;

    }
}
public class Main {
    static int N,M;
    static char[][] map;
    static int visited[][][][];

    //시계방향으로 회전
        static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1,0};
     static  Node red = null;
    static Node blue =null;
     static Deque<Node> q = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N= Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new int[10][10][10][10];

        for(int i=0; i<N; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<M; j++){
                if(map[i][j]=='B')  blue = new Node(i,j);
                if(map[i][j]=='R') red = new Node(i,j);
            }
        }
        //input process end

        System.out.println(escape());
    }

    static int escape(){
        Deque<Marble> q = new ArrayDeque<>();
        q.offer(new Marble(red,blue,1));
        visited[red.y][red.x][blue.y][blue.x] = 1;

        while(!q.isEmpty()){
             Marble marble = q.poll();
             int ry = marble.red.y;
             int rx = marble.red.x;
             int by = marble.blue.y;
             int bx= marble.blue.x;

            if(marble.cnt>10){
                return -1;
            }
           for(int i=0; i<4; i++){
               int rny = ry;
               int rnx = rx ;
               int bny = by ;
               int bnx = bx ;
               boolean bGoal = false;
               boolean rGoal =false;

               while(map[rny+dy[i]][rnx+dx[i]]!= '#'){
                   rny = rny + dy[i];
                   rnx = rnx + dx[i];
                   if(map[rny][rnx]=='O'){
                       rGoal = true;
                   }
               }

               while(map[bny+dy[i]][bnx+dx[i]]!= '#'){
                   bny = bny + dy[i];
                   bnx = bnx + dx[i];
                   if(map[bny][bnx]=='O'){
                       bGoal = true;
                   }
               }
               if(bGoal){
                   continue;
               }

               if(rGoal && !bGoal) return marble.cnt;

               if(rnx == bnx && rny == bny) {
                   if(i == 0) {
                       if(ry > by) rny -= dy[i];
                       else bny -= dy[i];
                   } else if(i == 1) {
                       if(rx < bx) rnx -= dx[i];
                       else bnx -= dx[i];
                   } else if(i == 2) {
                       if(ry < by) rny -= dy[i];
                       else bny -= dy[i];
                   } else {
                       if(rx > bx) rnx -= dx[i];
                       else bnx -= dx[i];
                   }
               }

               if(visited[rny][rnx][bny][bnx]==1){
                   continue;
               }

               visited[rny][rnx][bny][bnx]=  1;
               q.offer(new Marble(new Node(rny,rnx) , new Node(bny,bnx) , marble.cnt+1));
           }
        }
        return -1;
    }


}
