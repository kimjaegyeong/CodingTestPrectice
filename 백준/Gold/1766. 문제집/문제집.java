import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    /*
        4 2
    4 2
    3 1

     */
    static int N;
    static int M;
    static List<Integer> answer =new ArrayList<>();
    static int[] inDegree;
    static boolean[] visit;
    static List<List<Integer>> nodes = new ArrayList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o1-o2);
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        inDegree = new int[N+1];
        visit = new boolean[N+1];
        for(int i=0; i<=N; i++){
            nodes.add(new ArrayList<Integer>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            nodes.get(a).add(b);
            inDegree[b]++;
        }

        for(int i=1; i<=N; i++){
            if(inDegree[i]==0){
                pq.offer(i);
                visit[i] = true;
            }
        }

        while(!pq.isEmpty()){
            int now = pq.poll();
            answer.add(now);
            List<Integer> nowList = nodes.get(now);
            for(int i=0; i<nowList.size(); i++){
                int nxt = nowList.get(i);
                if(visit[nxt]) continue;
                inDegree[nxt]--;
                if(inDegree[nxt]==0){
                    pq.offer(nxt);
                    visit[nxt]= true;
                }
            }
        }
        for(int i : answer){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
