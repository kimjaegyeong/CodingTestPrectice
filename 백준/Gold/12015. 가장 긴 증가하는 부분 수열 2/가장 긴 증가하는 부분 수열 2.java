import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] map;
    static int[] minMap;
    static int count;

    public static void search_min(int n) {
            int start = 0;
            int mid;
            int end = count;

            while (start < end) {
                 mid = (start + end) / 2;
                if (n > minMap[mid]) {
                    start = mid + 1;
                }else {
                    end = mid; }
            }
            minMap[start] = n;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N];
        minMap = new int[N];

        String[] input = br.readLine().split(" ");
        count = 1;
        map[0] = Integer.parseInt(input[0]);
        minMap[0] = map[0];

        for (int i = 1; i < N; i++) {
            map[i] = Integer.parseInt(input[i]);
            if (minMap[count - 1] < map[i]) {
                count++;
                minMap[count - 1] = map[i];
            } else {
                search_min(map[i]);
            }
        }
        System.out.println(count);
    }
}
