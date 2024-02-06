
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

    static int TC;

    public static void main(String[] args) throws NumberFormatException, IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TC = Integer.parseInt(br.readLine());

        for (int t = 1; t <= TC; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] map = new int[N];
            int max = Integer.MIN_VALUE;
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                map[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(map);
            for(int i=N-1; i>0; i--){

                for(int j=i-1; j>=0; j--){

                    if(map[i] + map[j] <= M){
                        max = Math.max(map[i]+map[j] , max);
                    }
                }
            }
            if(max==Integer.MIN_VALUE) {
                System.out.println("#"+t +" " + -1);
                continue;
            }
            System.out.println("#"+t+" " + max);
        }


    }
}
