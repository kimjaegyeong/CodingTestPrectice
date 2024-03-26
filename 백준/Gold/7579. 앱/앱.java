import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    /*
    5 60
    30 10 20 35 40
    3 0 3 5 4
     */
    //≤ c1, ..., cN ≤ 100
    static int N, M;
    static int[][] dp;
    static int[] m;
    static int[] c;
    static int min =0;
    static  int cSum =0 ;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[101][10001];
        m = new int[N+1];
        c= new int[N+1];
         st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N;i ++){
            m[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N;i ++){
            c[i] = Integer.parseInt(st.nextToken());
            cSum+=c[i];

        }

        for(int i=1; i<=N; i++){
            for(int j=0; j<=cSum; j++){
                if(j - c[i] >=0){
                    dp[i][j] = Math.max(m[i]+dp[i-1][j-c[i]],dp[i][j]);
                }
                dp[i][j] = Math.max( dp[i - 1][j], dp[i][j]);

                }
            }

        for(int i=0; i<=cSum; i++){
            if(dp[N][i]>=M){
                min = i;
                break;
            }
        }
        System.out.println(min);


    }
}
