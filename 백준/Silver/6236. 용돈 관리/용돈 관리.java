import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int M;
    static int map[];
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N];
        
        int maxCost = 0;
        int totalCost = 0;
        for(int i=0; i<N; i++) {
            map[i] = Integer.parseInt(br.readLine());
            maxCost = Math.max(maxCost, map[i]);  // 하루 지출 중 최대값
            totalCost += map[i];  // 총 지출 합계
        }
        
        // 이분 탐색 범위 설정: 최소는 하루 최대 지출, 최대는 총 지출
        int s = maxCost;
        int e = totalCost;
        
        while(s <= e) {
            int mid = (s+e)/2;
            if(isPossible(mid)) {
                result = mid;  // 현재 값으로 가능하면 결과 업데이트
                e = mid - 1;   // 더 작은 값 탐색
            } else {
                s = mid + 1;   // 더 큰 값 탐색
            }
        }
        
        System.out.println(result);
    }
    
    // k원으로 M번 이하의 인출로 모든 지출을 감당할 수 있는지 확인
    public static boolean isPossible(int k) {
        int money = k;
        int withdrawCount = 1;  // 첫 날 무조건 인출
        
        for(int i=0; i<N; i++) {
            if(map[i] > k) return false;  // 한 번에 인출할 수 있는 금액보다 지출이 크면 불가능
            
            if(map[i] > money) {
                withdrawCount++;
                money = k - map[i];  // 새로 인출하고 지출
            } else {
                money -= map[i];    // 현재 돈에서 지출
            }
        }
        
        return withdrawCount <= M;  // M번 이하로 인출했는지 확인
    }
}