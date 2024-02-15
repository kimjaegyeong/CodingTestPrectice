import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel{
    int m;
    int v;

    @Override
    public String toString() {
        return "Jewel{" +
                "m=" + m +
                ", v=" + v +
                '}';
    }

    public Jewel(int m, int v) {

        this.m = m;
        this.v = v;
    }

}

public class Main {

    static int N,K;
    static int M,V;
    static int C;
    static PriorityQueue<Jewel> queue = new PriorityQueue<>((o1,o2) -> o1.m - o2.m);
    static PriorityQueue<Jewel> ans = new PriorityQueue<>((o1,o2) -> o2.v - o1.v);
    static int[] bag;
    static long answer;
    static int cnt =0;
    static Jewel[] store;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bag = new int[K];
        store = new Jewel[K];
        for(int i=0; i<N; i++) {
            st= new StringTokenizer(br.readLine());
          queue.offer( new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        for(int i=0; i<K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bag);

        for(int i=0; i<bag.length; i++){
            int mass = bag[i];
            while(!queue.isEmpty()){
                Jewel j = queue.peek();
                if(j.m > mass){
                    break;
                }
                ans.offer(j);
                queue.poll();
            }
            if(!ans.isEmpty()){
                answer += ans.poll().v;
            }

        }
        System.out.println(answer);

    }

}
