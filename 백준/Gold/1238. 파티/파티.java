import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable{
    int node;
    int cost;

    public Node(int node, int cost){
        this.node = node;
        this.cost =cost;
    }

    @Override
    public int compareTo(Object o) {
        Node n = (Node) o;
        if(this.cost < n.cost){
            return -1;
        }
        return 1;
    }
}
public class Main {
    static int N,M,X;
    // N개 노드, M개 간선, X 도착지
    static ArrayList<ArrayList<Node>> nodes ;
    //최장비용
    static int max = Integer.MIN_VALUE;
    static int[] d;
    static int[] town;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();
        StringTokenizer st = new StringTokenizer(str);
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        d = new int[N+1];
        town = new int[N+1];
        nodes = new ArrayList<ArrayList<Node>>();
        for(int i=0; i<=N; i++){
            nodes.add(new ArrayList<Node>());
        }

        // a->b c 간선비용
        for(int i=0; i<M; i++){
            str =br.readLine();
            st = new StringTokenizer(str);
            nodes.get(Integer.parseInt(st.nextToken())).add(new Node(Integer.parseInt(st.nextToken()) ,Integer.parseInt(st.nextToken())));
        }

        // 다익스트라 n번 해서, n 마을에 대한 x 까지의 최단 루트 구하기
        for(int i=1; i<=N; i++){
            Arrays.fill(d, Integer.MAX_VALUE);
            dijkstra(i);
            town[i]+= d[X];
        }
//        System.out.println(Arrays.toString(town));

        Arrays.fill(d,Integer.MAX_VALUE);
        dijkstra(X);
//        System.out.println(Arrays.toString(d));
        for(int i=1; i<=N; i++){
            max = Math.max(town[i] + d[i] , max);
        }

        System.out.println(max);
    }

    static void dijkstra(int start){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        d[start] = 0;

        while(!pq.isEmpty()){
            Node node = pq.poll();
            int dist = node.cost;
            int now = node.node;

            if(d[now] < dist) continue;

            for(int i=0; i<nodes.get(now).size(); i++){
                int cost = d[now] + nodes.get(now).get(i).cost;

                if(cost<d[nodes.get(now).get(i).node]){
                    d[nodes.get(now).get(i).node] = cost;
                    pq.offer(new Node(nodes.get(now).get(i).node,cost));
                }
            }
        }


    }
}
