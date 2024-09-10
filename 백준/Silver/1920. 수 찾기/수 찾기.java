import java.util.*;
import java.io.*;
public class Main
{
    //이분탐색 g할 수이ㅇ잇어 
    static int N;
    static long[] v1,v2;
    static int M;
    
    static int test(long val1, long val2){
        if(val1 < val2) return 1;
        else if(val1 > val2) return -1;
        return 0;
    }
    
    static boolean isExist(long val){
        long s_idx, e_idx, mid;
        s_idx = 0; e_idx = N - 1;
        
        while(s_idx <= e_idx){
            mid = (s_idx + e_idx) / 2;
            
            int ret = test(v1[(int)mid], val);
            if(ret == -1) e_idx = mid - 1;
            if(ret == 0) return true;
            if(ret == 1) s_idx = mid + 1;
        }
        return false;
    }
    
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        v1 = new long[N];
        String inputs[] = br.readLine().split(" ");
        for(int i=0; i<inputs.length; i++){
            v1[i] = Long.parseLong(inputs[i]);
            
        }
        M = Integer.parseInt(br.readLine());
        v2 = new long[M];
        inputs = br.readLine().split(" ");
        for(int i=0; i<inputs.length; i++){
            v2[i] = Long.parseLong(inputs[i]);
        }
        
        //input process end 
        Arrays.sort(v1);
        
        //이분탐색은 s, e 를 설정하고, 찾고자 하는 값인 n 이 mid 값보다 크면 s를 mid로 옮겨 더 큰 범위에서 찾도록하고,
        //mid값보다 작으면 e를 mid로 하여 mid보다 작은 범위에서 찾도록 한다.
        //s <e 일 때 까지 반복하다보면 해당 값을 찾을 수 있는데, 만약 탐색이 끝났는데도 없다면 ...

        for(int i=0; i<v2.length; i++){
            System.out.println(isExist(v2[i])? 1 : 0);
        }
    }
}