import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Node implements Comparable<Node>{
    int cost;
    int period;

    public Node(int period, int cost)  {
        this.cost=cost;
        this.period=period;
    }

    @Override
    public int compareTo(Node o) {
        return o.cost- cost;
    }
}

public class Main {
    static int N;
    static int max_days=-1;
    static Node[] work;
    static int max_score = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        work= new Node[N];
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            work[i] =new Node(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
            if(max_days<work[i].period){
                max_days= work[i].period;
            }
        }
        Arrays.sort(work);
        for(int i=max_days; i>0; i--){
             cal(i);
        }

        System.out.println(max_score);
    }

    public static void cal(int i){
        for(int j=0; j<N; j++){
            if(work[j].period>=i && work[j].cost>0){
//                System.out.println("i: "+ i + " cost : "+ work[j].cost);
                max_score= max_score + work[j].cost;
                work[j].cost=-1;
                break;
            }
        }
    }


}

