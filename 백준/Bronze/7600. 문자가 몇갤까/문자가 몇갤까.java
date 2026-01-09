import java.util.*;
import java.io.*;
public class Main
{


    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {

			String[] input = br.readLine().split(" ");

			if(input[0].equals("#")) break;
			int[] alpha = new int[26];

			for(int i=0; i<input.length; i++) {

				for(int j=0; j< input[i].length(); j++) {
					char cha =input[i].charAt(j);
					if( cha - 0 > 96 && cha - 0 <123 ) {
						alpha[cha - 97]++;
					} else if(cha - 0 > 64 && cha - 0 < 91) {
						alpha[cha - 65]++;
					}
				}
			}
			
			
			int ans = 0;
			for(int i=0; i<alpha.length; i++) {
				if(alpha[i] > 0) ans++;
			}

            sb.append(ans).append("\n");
		}
		
		System.out.println(sb);

	}
}
