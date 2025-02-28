import java.util.*;
import java.io.*;

public class Main {
    static long N;
    static long[] map;
    static long result = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        map = new long[6];
        long min = 10001L;
        
        for (int i = 0; i < 6; i++) {
            map[i] = Long.parseLong(st.nextToken());
            min = Math.min(min, map[i]);
        }

        long[][] two_map = {
            {1L, 5L}, {2L,6L} ,{1L, 4L}, {1L, 3L}, {1L, 2L}, {2L, 4L}, {2L, 3L},
            {3L, 5L}, {3L, 6L}, {4L, 5L}, {4L, 6L}, {5L, 6L}
        };

        long[][] three_map = {
            {1L, 2L, 3L}, {1L, 3L, 5L}, {1L, 4L, 5L},{1L,2L,4L}, {6L, 4L, 2L},
            {6L,3L,2L},{6L,4L,5L},{6L,5L,3L} };
        

        long two_min = 1000L;
        long three_min = 1000L;

        for (int i = 0; i < two_map.length; i++) {
            two_min = Math.min(two_min,map[(int) (two_map[i][0] - 1L)] + map[(int) (two_map[i][1] - 1L)]);
        }

        for (int i = 0; i < three_map.length; i++) {
            long sum = map[(int) (three_map[i][0] - 1L)] + map[(int) (three_map[i][1] - 1L)] + map[(int) (three_map[i][2] - 1L)];
            three_min = Math.min(three_min, sum);
        }

        if (N == 1L) {
            Arrays.sort(map);
            System.out.println(map[0] + map[1] + map[2] + map[3] + map[4] );
            return;
        }

        if (N == 2L) {
            result = three_min * 4L + two_min * 4L;
            System.out.println(result) ;
            return;
        }
        
        long temp1 = (N - 1L) * two_min * 4L; 
        long temp2 = (N - 1L) * min * (N - 2L) * 4L;
        long temp3 = three_min * 4L + two_min * (N - 2L) * 4L + (N - 2L) * (N - 2L) * min;


        System.out.println(temp1 + temp2 + temp3);

    }
}
