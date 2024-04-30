

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int M;
	static int K;
	static int[] cardNum;
	static int[] cheolsuCard;
	static boolean[] visit;
	static List<Integer> list = new ArrayList<>();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		cardNum = new int[N];
		cheolsuCard = new int[M];
		visit = new boolean[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int num = Integer.parseInt(st.nextToken());
			cardNum[i] = num;
			list.add(num);
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			cheolsuCard[i] = Integer.parseInt(st.nextToken());
		}
		

		Collections.sort(list);
//		System.out.println(list);
		for (int i = 0; i < K; i++) {
			int idx = lower_bound(cheolsuCard[i]);

			//찾아낸 idx가 true라면 한칸씩 밀어가면서 진짜 lower bound를 찾아내기
			while(visit[idx]) {
				idx ++;
			}
			visit[idx] = true;
			sb.append(list.get(idx)).append("\n");
			//list.remove(idx);
		}

		System.out.println(sb);
	}

	static public int lower_bound(int n) {
		int start = 0;
		int end = list.size() - 1;
		if (list.get(end) < n) {
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
		//lowerBound end
		return end;
	}
}
