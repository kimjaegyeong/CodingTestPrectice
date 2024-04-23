
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static long[] map;
	static long max = 1_000_000_000;
	static ArrayList<Long> list;
	static long[] idxv;
	static int max_idx = 0;
	static long max_length = 0;
	static StringBuilder sb = new StringBuilder();
	static ArrayDeque<Long> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		map = new long[N];
		list = new ArrayList<Long>();
		idxv = new long[N];
		for (int i = 0; i < N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		list.add(map[0]);
		for (int i = 1; i < N; i++) {
			int idx = search(map[i]);
//			System.out.println(idx + " " + i + " " + map[i]);
//			System.out.println(list);
//			System.out.println("======");
			if(idx==-1) {
				list.add(map[i]);
				max_idx = i;
				max_length = list.size()-1;
				idxv[i] = list.size()-1;
			}else {
				list.set(idx,map[i]);
				idxv[i] = idx;
			}
		}
		sb.append(list.size()).append("\n");
		backtracking();
		while(!queue.isEmpty()) {
			sb.append(queue.pop()).append(" ");
		}
		
		System.out.println(sb);
	}
	
	static void backtracking() {
		int idx = max_idx;
		long length = max_length;
		while(idx>=0) {
			if(idxv[idx]==length) {
				queue.push(map[idx]);
				length--;
			}
			idx--;
		}
	}

	static public int search(long n) { //lower bind
		int start = 0;
		int end = list.size() - 1;
		if (list.get(end) < n) {
			return -1; // n이 지금까지 만들어진 수열의 가장 큰 수보다 더 클 때
		} else if (list.get(start) >= n) { // n이 지금까지 만들어진 수열의 가장 작은 수보다 더 작거나 같을 때 
			return 0;
		}
		while (start < end) {
			int mid = (start + end) / 2;
			if (n <= list.get(mid)) { // n이 list.get(mid) 보다 작으면 범위를 줄여야 함 end = mid
				end = mid;
			}
			else {
				start = mid+1;
			}
		}
		return end;
	}

}
