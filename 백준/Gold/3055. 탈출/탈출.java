import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int y, x, cnt;

        public Node(int y, int x, int cnt) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
        }
        public int compareTo(Node n){
            return this.cnt - n.cnt;
        }
    }

    static int N, M;
    static char[][] map;
    static int[] dy= {1,-1,0,0};
    static int[] dx = {0,0,1,-1};
    static boolean[][] visit ;
    static boolean[][] visitWater;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visit = new boolean[N][M];
        visitWater = new boolean[N][M];
        PriorityQueue<Node> hedgehog = new PriorityQueue<>();
        PriorityQueue<Node> water = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == 'S') {
                    hedgehog.offer(new Node(i, j, 0));
                }
                if (map[i][j] == '*') {
                    water.offer(new Node(i,j,0));
                }
            }
        }

        int waterCnt =0;
        int hedgehogCnt =0;

        while (!hedgehog.isEmpty()) {

            while(!water.isEmpty()){
                Node nowWater = water.poll();
                if(nowWater.cnt>waterCnt){
                    water.offer(nowWater);
                    break;
                }
                for(int i=0; i<4; i++) {
                    int ny = nowWater.y+ dy[i];
                    int nx= nowWater.x  +dx[i];
                    if(ny>=N || nx>=M || ny<0 || nx<0 || map[ny][nx]=='X' || map[ny][nx]=='D' ) {
                        continue;
                    }
                    if(visitWater[ny][nx]) continue;
                    water.offer(new Node(ny,nx,nowWater.cnt+1));
                    map[ny][nx] = '*';
                    visitWater[ny][nx] = true;
                }
            }
//            System.out.println(Arrays.deepToString(map).replace("],","]\n"));
//            System.out.println(waterCnt+" =====");
            waterCnt++;
            while(!hedgehog.isEmpty()){
//                System.out.println(Arrays.deepToString(map).replace("],","]\n"));
//                System.out.println(waterCnt+" =====");
                Node nowHog = hedgehog.poll();
                if(nowHog.cnt>hedgehogCnt){
                    hedgehog.offer(nowHog);
                    break;
                }
                for(int i=0; i<4; i++) {
                    int ny = nowHog.y + dy[i];
                    int nx = nowHog.x + dx[i];
                    if(ny>=N || nx>=M || ny<0 || nx<0 || map[ny][nx]=='X' || map[ny][nx]=='*' ) {
                        continue;
                    }
                    if(visit[ny][nx] || visitWater[ny][nx]) continue;

                    if(map[ny][nx]=='D') {
                        System.out.println(nowHog.cnt+1);
                       // System.out.println(Arrays.deepToString(map).replace("],","]\n"));
                        return;
                    }
                    hedgehog.offer(new Node(ny,nx,nowHog.cnt+1));
                    map[ny][nx] ='S';
                    visit[ny][nx] = true;
                }
            }
//            System.out.println(Arrays.deepToString(map).replace("],","]\n"));
//            System.out.println(hedgehogCnt +" =============");
            hedgehogCnt++;
        }

        System.out.println("KAKTUS");

    }

}
