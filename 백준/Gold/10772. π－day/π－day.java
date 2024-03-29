import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int N;
    static int K;
    static int dp[][][];
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        dp= new int[N+1][N+1][N+1];
        System.out.println(dfs(N,K,1));
    }

    static int dfs(int n, int k, int limit){
        if(dp[n][k][limit]==0){
            if(n==k){ //8개 조각을 8명한테 나눠주는
                dp[n][k][limit] =1;
            }else if(k==1){ //n개 조각을 1명한테 나눠주는
                dp[n][k][limit]= 1;
            }else{
                int res =0;
                for(int i=limit; i<=n/k; i++){
                    res += dfs(n-i,k-1,i);
                }
                dp[n][k][limit] = res;
            }
        }
        return dp[n][k][limit];
    }
}
