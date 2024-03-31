import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int K, N;
    static long v[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        v = new long[K];
        for (int i = 0; i < K; i++) {
            v[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(v);
        long start = 0;
        long end = v[K-1];

        while (end>=start) {
            long mid = (start + end) / 2;
            if(mid ==0) break;
            long sum = 0;
            for (int i = 0; i < K; i++) {
                sum += v[i] / mid;
            }

            // 만들 수 있는 랜선의 개수가 N개 이상이라면
            if (sum >=N) { // N개 이상을 만들 수 있다면, 랜선 길이 를 계속 늘려본다.
                start = mid+1;

            } else { // 만들 수 있는 랜선의 개수가 N개보다 적다면
                // 더 작은 범위로 잘라내야 함
                end = mid-1;
            }
        }

        System.out.println(end);
    }
}
