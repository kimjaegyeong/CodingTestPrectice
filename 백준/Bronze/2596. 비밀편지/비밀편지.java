import java.util.*;
import java.io.*;
public class Main
{
	static String input;
	static String pwds[];
	static String[] inputs;
	static String[] alpha;
	public static void main(String[] args) throws Exception {

		pwds = new String[] {
		    "000000","001111","010011","011100","100110","101001","110101","111010"
		};

		alpha = new String[] {
		    "A","B","C",
		    "D","E","F",
		    "G","H"
		};

		String ans = "";
		int n = 0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

		input = br.readLine();
		inputs = new String[n];
		int cnt= 0;
		for(int i=0; i<input.length(); i+=6) {

			inputs[cnt] = input.substring(i, i+6);
			cnt++;

		}

		for(int i=0; i<inputs.length; i++) {

			boolean flag = false;
			for(int j=0; j<pwds.length; j++) {
				if(inputs[i].equals(pwds[j])) {
					ans+= alpha[j];
					
					flag =true;
				    break;
				    
				}
			}

			for(int j=0; j<pwds.length; j++) {
				int wrongCnt = 0;
				for(int k=0; k<pwds[j].length(); k++) {
					if(pwds[j].charAt(k) != inputs[i].charAt(k)) {
						wrongCnt++;
					}
				}

				if(wrongCnt == 1) {
					flag =true;
					ans+=alpha[j];
					break;
				}

			}

			if(!flag){
			    System.out.println(i+1);
				return;
			}
				
		}
		
		System.out.println(ans);
	}
}
