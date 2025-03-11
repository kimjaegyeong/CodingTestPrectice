import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int K;
    static boolean[] hasPower;
    static int ans = 200001; // 충분히 큰 초기값

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        hasPower = new boolean[N + 1]; // 1-indexed로 변경
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            hasPower[i] = st.nextToken().charAt(0) == '1';
        }
        
        binarySearch();
        System.out.println(ans);
    }
    
    public static void binarySearch() {
        int start = 1;
        int end = N;
        
        while (start <= end) {
            int mid = (start + end) / 2;
            if (canReachDay1(mid)) {
                ans = mid;
                end = mid - 1; // 더 작은 값 찾기
            } else {
                start = mid + 1; // 더 큰 값 필요
            }
        }
    }
    
    public static boolean canReachDay1(int t) {
        int currentDay = N;
        int usesLeft = K;
        
        while (currentDay > 1 && usesLeft > 0) {
            // T일 전으로 가려는 위치 계산 (1일 이전이면 1일로)
            int destination = Math.max(1, currentDay - t);
            
            // 이미 1일에 도달했다면 성공
            if (destination == 1) {
                return true;
            }
            
            usesLeft--;
            
            // destination 이후에 전원이 있는 첫 번째 날을 찾음
            int nextDay = destination;
            boolean foundPoweredDay = false;
            
            while (nextDay < currentDay) {
                if (hasPower[nextDay]) {
                    foundPoweredDay = true;
                    break;
                }
                nextDay++;
            }
            
            // 적절한 전원이 있는 날을 찾지 못했다면 실패
            if (!foundPoweredDay || nextDay == currentDay) {
                return false;
            }
            
            currentDay = nextDay;
        }
        
        // 1일에 도달했는지 확인
        return currentDay == 1;
    }
}