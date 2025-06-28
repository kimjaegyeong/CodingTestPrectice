import java.util.*;
import java.io.*;

public class Main {
    static int[] nums;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        nums = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int missingIdx = -1;

        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            if (nums[i] == -1) missingIdx = i;
        }

        nums[missingIdx] = Integer.parseInt(br.readLine()); 

        Arrays.sort(nums); 

        postOrder(0, N - 1); 

        System.out.println(sb);
    }

    public static void postOrder(int start, int end) {
        if (start > end) return;

        int mid = (start + end) / 2;
        
        postOrder(start, mid - 1);
        postOrder(mid + 1, end);
        sb.append(nums[mid]).append(" ");
    }
}