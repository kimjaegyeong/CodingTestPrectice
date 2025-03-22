import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static String input ;
	static int bc;
	static int rc;
	static int b_seq;
	static int r_seq;
	static int ans = 10000000;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		input = br.readLine();

// 		for(int i=0; i<N; i++) {
// 			if(input.charAt(i)=='R') {
// 				rc++;
// 				b_seq = Math.max(b_seq, bc);
// 				bc = 0;
// 			} else {
// 				bc++;
// 				r_seq = Math.max(r_seq, rc);
// 				rc = 0 ;
// 			}

// 		}
// 		System.out.println(b_seq + " " + r_seq);
// 		if(b_seq > r_seq) {

// 		} else {

// 		}

		move('R');
        move('B');
		System.out.println(ans);
	}

	public static void move(char boll) {
		int mc = 0;
		boolean flag = false;
		for(int i=0; i<N; i++) {
			if(input.charAt(i)!=boll) {
				flag = true;
			}
			if(flag) {
				if(input.charAt(i)==boll) {
					mc++;
				}
			}
		}

		ans = Math.min(ans, mc);
		mc =0;
        flag= false;
		for(int i= N-1; i>=0; i--) {
			if(input.charAt(i)!=boll) {
				flag = true;
			}

			if(flag) {
				if(input.charAt(i)==boll) {
					mc++;
				}

			}
		}

		ans = Math.min(ans,mc);
	}

}
