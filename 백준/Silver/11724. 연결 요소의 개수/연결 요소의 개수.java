import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N,M;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list=  new ArrayList<>();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new int[N+1];
        for(int i =0 ; i<=N; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        int cnt =0;

        for(int i=1; i<=N; i++){
            if(visited[i]==1) continue;
            bfs(i);
            cnt++;
            if(check()) break;

        }

        System.out.println(cnt);

    }

    static boolean check(){
        for(int i = 1; i<=N ;i++){
            if(visited[i]==0 ) return false;
        }
        return true;
    }

    static void bfs(int n){
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(n);
        while(!q.isEmpty()) {
            int node = q.poll();

            if(visited[node]==1) continue;
            visited[node] =1;
            for (int j = 0; j < list.get(node).size(); j++) {
                if (visited[list.get(node).get(j)] == 1)
                    continue;
                q.offer(list.get(node).get(j));
            }
        }
    }
}
