
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static int T;
	static String commend;
	static int n;
	static ArrayList<Integer> map;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for (int t = 0; t < T; t++) {
			commend = br.readLine();
			n = Integer.parseInt(br.readLine());
			String input = br.readLine();
			map = new ArrayList<Integer>();
			input = input.substring(1, input.length() - 1);
			String input_v[] = input.split(",");

			// 만약 input 문자열에 아무런 숫자도 없는 경우
			if (input.equals("")) {
				if (commend.contains("D")) {
					sb.append("error").append("\n");
				} else {
					sb.append("[]").append("\n");
				}
				continue;
			}

			for (int i = 0; i < input_v.length; i++) {
				map.add(Integer.parseInt(input_v[i]));
			}

			int pre_idx = 0;
			int post_idx = map.size() - 1;
			boolean reverse = false;
			for (int i = 0; i < commend.length(); i++) {
				switch (commend.charAt(i)) {
				case 'D':
					if (reverse) {
						post_idx -= 1;
					} else {
						pre_idx += 1;
					}
					break;
				case 'R':
					reverse = reverse == true ? false : true;
					break;
				}
			}
			
			if(post_idx <0 || pre_idx> map.size()) {
				sb.append("error").append("\n");
				continue;
			}
			
			
			sb.append("[");
 			if(reverse) {
				for(int i= post_idx; i>=pre_idx; i--) {
					if(i==pre_idx) {
						sb.append(map.get(pre_idx));
						break;
					}
					sb.append(map.get(i)).append(",");
				}
				
			}else {
				for(int i= pre_idx; i<=post_idx; i++ ) {
					if(i==post_idx) {
						sb.append(map.get(post_idx));
						break;
					}
					sb.append(map.get(i)).append(",");
				}
				
			}
			sb.append("]");
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
