import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int T;
    static int N;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        long[] map = new long[101];
        map[0] = 1;
        map[1] = 1;
        map[2] = 1;

        for(int i=3; i<=100; i++){
            map[i] = map[i-3] + map[i-2];
        }
        for(int t=0; t<T; t++){
            N = Integer.parseInt(br.readLine());
            //n = n - 3 + n - 2
            System.out.println(map[N-1]);
        }
    }
}
