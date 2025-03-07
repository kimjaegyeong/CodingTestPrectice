import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static String first;
	static String second;
	static String result;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for(int n=1; n<N+1; n++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			first = st.nextToken();
			second = st.nextToken();
			result = st.nextToken();

			int[][] dp = new int[first.length()+1][second.length()+1];


			for(int i=1; i<first.length()+1; i++) {
				if(first.substring(0,i).equals(result.substring(0,i))) {
					dp[i][0] = 1;
				}
			}


			for(int i=1; i<second.length()+1; i++) {
				if(second.substring(0,i).equals(result.substring(0,i))) {
					dp[0][i] = 1;
				}
			}

			for(int i=1; i<first.length()+1; i++) {
				for(int j=1; j<second.length()+1; j++) {

					if(dp[i-1][j] == 1) {
						for(int l=i-1; l<first.length(); l++) {
							if(first.charAt(l) == result.charAt(i+j-1)) {
								dp[i][j]  = 1;
							}
						}
					}

					if(dp[i][j-1] == 1) {
						for(int l=j-1; l<second.length(); l++) {
							if(second.charAt(l) == result.charAt(i+j-1)) {
								dp[i][j]  = 1;
							}
						}
					}
				}
			}
// 			System.out.println("===========================");
// 			for(int i=0; i<first.length()+1; i++) {
// 				for(int j=0 ; j<second.length()+1; j++) {
// 					System.out.print(dp[i][j] +  " ");
// 				}
// 				System.out.println();
// 			}
// 			System.out.println("===========================");
			sb.append("Data set ").append(n);
			if(dp[first.length()][second.length()]==1) {
				sb.append(": yes");
			} else {
				sb.append(": no");
			}

			sb.append("\n");
		}

		System.out.println(sb);
	}

}
