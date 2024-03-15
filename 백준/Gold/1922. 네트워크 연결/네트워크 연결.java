import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
   static class Node implements Comparable<Node>{
        int idx;
        int cost;

    public Node(int idx, int cost){
            this.idx= idx;
            this.cost= cost;
        }

        public int compareTo(Node n){
            return this.cost - n.cost;
        }

    }

    static int N;
    static int M;
    static int min;
    static ArrayList<ArrayList<Node>> nodes = new ArrayList<>();
    static boolean visited[] ;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];
        visited[0]= true;
        for(int i=0; i<=N; i++){
            nodes.add(new ArrayList<Node>());
        }
        for(int i=0; i<M; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            nodes.get(a).add(new Node(b,c));
            nodes.get(b).add(new Node(a,c));

        }
        //input process end
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1,0));

        while(!pq.isEmpty()){
            Node now = pq.poll();
            if(visited[now.idx])continue;

            visited[now.idx] = true;
            min+= now.cost;

            ArrayList<Node> list = nodes.get(now.idx);
            for(int i=0; i<list.size(); i++){
                if(visited[list.get(i).idx]) continue;
                pq.offer(new Node(list.get(i).idx, list.get(i).cost));

            }
        }
        System.out.println(min);
    }
}
