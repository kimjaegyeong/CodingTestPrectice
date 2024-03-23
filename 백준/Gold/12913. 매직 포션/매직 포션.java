import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static class Node  implements Comparable<Node>{
        int idx;
        double cost;
        int k ;
        public Node(int idx, double cost, int k  ){
            this.idx= idx;
            this.cost =cost;
            this.k = k;
        }
        public int compareTo(Node n ) {
            return (int) (this.cost  - n.cost);
        }
    }

    static int N;
    static int K;
    static int[][] map;
    static double[][] v;

    static int[][] visit;
    static int INF= 1000011;
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        v = new double[K+1][N];
        visit = new int[K+1][N];
        for(int i=0; i<=K; i++){
            for(int j=0; j<N; j++){
                v[i][j] = INF;
            }
        }
        for (int i = 0; i < N; i++) {
            String input[] = br.readLine().split("");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        //input process end
        dijkstra(0);

        double result = INF;
        for(int i=0; i<=K; i++){
            result = Math.min(result, v[i][1]);
        }

        System.out.println(result);
    }

    static void dijkstra(int n){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(n,0,0));
        v[0][n] = 0;

        while(!pq.isEmpty()){
                Node now = pq.poll();
                if(visit[now.k][now.idx]==1) continue;

                visit[now.k][now.idx]= 1;

                for(int i=0; i<N; i++){
                    if(now.idx==i) continue;
                    //아직 매직 포션을 사용할 수 있다면
                    if(now.k < K){
                        double newDist = v[now.k][now.idx] + ((double)map[now.idx][i])/2.0;
                        if(newDist < v[now.k+1][i] ) {
                            pq.offer(new Node(i,newDist, now.k+1));
                            v[now.k+1][i] = newDist;

                        }
                    }
                    double newDist = v[now.k][now.idx] + map[now.idx][i];
                    if(newDist < v[now.k][i] ) {

                        pq.offer(new Node(i,newDist, now.k));
                        v[now.k][i] = newDist;
                    }
                }
        }
    }
}
