import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int max = 1001;
    static int dp[][];
    static int answer = 0;

    public static void main(String[] args) throws Exception {
        dp = new int[max][max];
        char[] stringA;
        char[] stringB;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        stringA = br.readLine().toCharArray();
        stringB = br.readLine().toCharArray();
        for (int i = 0; i <stringB.length; i++) {
            for (int j = 0; j < stringA.length; j++) {
                //같은 알파벳을 만났을 때
                if(stringB[i] == stringA[j]){
                    dp[i+1][j+1] = dp[i][j] +1;
                }else{ //아닐 때는 만들어진 증가 수열 중 최장인 것을 선택
                    dp[i+1][j+1] = Math.max(dp[i+1][j] , dp[i][j+1]);
                }

            }
        }
            System.out.println(dp[stringB.length][stringA.length]);

    }
}
