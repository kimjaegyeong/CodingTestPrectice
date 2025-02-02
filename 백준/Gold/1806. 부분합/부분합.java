import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int S;
    static int[] seq;
    static int[] sum;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        N =Integer.parseInt(input[0]);
        S = Integer.parseInt(input[1]);
        seq = new int[N];
        sum = new int[N+1];
        input = br.readLine().split(" ");
        seq[0] = Integer.parseInt(input[0]);
        sum[1] = seq[0];
        for(int i=1; i<N; i++){
            seq[i] = Integer.parseInt(input[i]);
            sum[i+1] = sum[i] + seq[i];
        }
        if(sum[N] < S){
            System.out.println(0);
            return;
        }
        else if(sum[N]==S){
            System.out.println(seq.length);
            return;
        }
        int right =0;
        int left = 0;
        int min = Integer.MAX_VALUE;
        while(right<N+1){
                if(sum[right] >=S){

                    while(sum[right] - sum[left] >=S) {
                        min = Math.min(min, right - left);
                        left++;
                    }
                }
            right++;
            }
        System.out.println(min);

    }
}
