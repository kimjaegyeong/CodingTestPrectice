import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int T;
    static int n;
    static int result;
    static int[] visit;
    static HashMap<String, Integer> map;
    static StringBuilder sb= new StringBuilder();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new HashMap<String, Integer>();
            result = 1;
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String name = st.nextToken();
                String key = st.nextToken();
                if (!map.containsKey(key)) {
                    map.put(key, 1);
                } else {
                    map.put(key, map.get(key) + 1);
                }
            }

            for(int value : map.values()){
                result *= (value + 1);
            }
            sb.append(result-1).append("\n");
        }
        System.out.println(sb);
    }
}
