import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }

        public int compareTo(Node n) {
            return this.idx - n.idx;
        }

        @Override
        public String toString() {
            return "Node [idx=" + idx + ", value=" + value + "]";
        }
    }

    static int N;
    static Node[] map;
    static List<Integer> list;
    static int[] idxList;
    static int max_idx;
    static StringBuilder sb = new StringBuilder();
    static ArrayDeque<Integer> stack = new ArrayDeque<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new Node[N];
        idxList = new int[N];
        list = new ArrayList<Integer>();
        int n, m;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            map[i] = new Node(n, m);
        }
        Arrays.sort(map);

        list.add(map[0].value);

        for (int i = 1; i < N; i++) {
            int idx = lower_bound(map[i].value);
            if (idx == -1) {
                list.add(map[i].value);
                max_idx = list.size() - 1;
                idxList[i] = list.size() - 1;
            } else {
                list.set(idx, map[i].value);
                idxList[i] = idx;
            }
        }

        int idx = max_idx;
        for(int i=N-1; i>=0; i--){
            if(idx==idxList[i]){
               idx--;
                continue;
            }
            stack.push(map[i].idx);
        }
        sb.append(stack.size()).append("\n");
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append("\n");
        }

        System.out.println(sb);
    }

    // n은 map[i].value
    static int lower_bound(int n) {
        int start = 0;
        int end = list.size() - 1;
        if (list.get(list.size() - 1) < n) {
            return -1;
        } else if (list.get(0) > n) {
            return 0;
        }

        while (start < end) {
            int mid = (start + end) / 2;
            if (n >= list.get(mid)) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }

}
