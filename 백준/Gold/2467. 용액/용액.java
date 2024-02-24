import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long map[];
    static long min;
    static long liquidA ;
    static long liquidB ;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new long[N];
        min = Long.MAX_VALUE;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N ;i++){
            map[i] = Integer.parseInt(st.nextToken());
        }

        int s =0;
        int e = N-1;

        while(s<e){
            if(Math.abs(map[e] + map[s]) < min) {
                min =  Math.abs(map[e] + map[s]);
                liquidA = map[e];
                liquidB = map[s];
            }
            if(map[e] + map[s] < 0 ) {
                s++;
            }else if(map[e] + map[s] > 0){
                e--;
            }else if(map[e]+map[s] ==0 ){
                min = 0;
                liquidA = map[e];
                liquidB = map[s];
                System.out.println(liquidB + " " + liquidA);
                return ;
            }
        }
        System.out.println(liquidB + " " + liquidA);
    }
}
