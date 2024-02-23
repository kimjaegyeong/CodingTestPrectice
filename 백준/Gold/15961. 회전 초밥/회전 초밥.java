import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    static int N, d, k, c;
    static int[] map;
    static int[] susi;
    static int ans ;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d= Integer.parseInt(st.nextToken());
        k= Integer.parseInt(st.nextToken());
        c= Integer.parseInt(st.nextToken());
        map = new int[N];
        susi = new int[d+1];
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(br.readLine());
        }
        int s= 1 , e =k;
        int max= 0;

        for(int i=0; i<k; i++){
            if(susi[map[i]]==0) {
                max++;
            }
            susi[map[i]] ++;
        }

        while(true){
            if(susi[map[s-1]]==1) max--;
            susi[map[s-1]]--;

            if(susi[map[e]]==0) max++;
            susi[map[e]]++;

            if(susi[c]==0) {
                ans = Math.max(max+1, ans);
            }else{
                ans = Math.max(max, ans);
            }

            s++;
            e++;
            if(e==N) e= 0;
            if(s==N) break;
        }

        System.out.println(ans);

    }
}
