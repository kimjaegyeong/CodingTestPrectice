import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static String[] words;
	static int[] tarWords;
	static int alpha[];
	static boolean flag = true;
	static int ans  =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		words = new String[N];
		alpha = new int[26];
		for(int i=0; i<N; i++) {
			words[i] = br.readLine();
		}

		for(int i=0; i<words[0].length(); i++) {
			alpha[words[0].charAt(i) - 65] ++ ;
		}

		for(int i=1; i<N; i++) {

			String src = words[0];
			String tar= words[i];
			flag = false;
			int cnt = 0;
			tarWords = Arrays.copyOf(alpha, alpha.length);
			for(int j=0; j<tar.length(); j++) {
				tarWords[tar.charAt(j) - 65] --;

			}

			int plus = 0;
			int minus =0 ;

			for(int j=0; j<tarWords.length; j++) {
				if(tarWords[j] >=1 ) plus+=tarWords[j];
				if(tarWords[j] <= -1) minus+= Math.abs(tarWords[j]);
			}

			if(plus == 0  && minus ==0 ) flag = true;
			else if(plus ==1 && minus == 1) flag =true;
			else if(plus ==1 && minus ==0 ) flag= true;
			else if(plus == 0 && minus == 1) flag= true;
			if(flag) ans++;


		}
    
    System.out.println(ans);
	}


}
