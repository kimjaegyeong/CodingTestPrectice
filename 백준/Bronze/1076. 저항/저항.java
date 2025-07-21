import java.util.*;
import java.io.*;
public class Main
{

    static long answer = 1;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for(int i=0; i<3; i++){
            String input = br.readLine();
            int[] v = getNum(input);

            if(i==2){
                answer *= v[1];
            }else if(i==1){
                answer += v[0];
            }else {
                answer*=v[0];
                answer*=10;
            }
        }
        System.out.println(answer);
        

	}

	public static int[] getNum(String s) {
		if(s.equals("black")) {
			return new int[] {0,1};
		} else if(s.equals("brown")) {
			return new int[] {1,10};
		} else if(s.equals("red")) {
			return new int[] {2,100};
		} else if(s.equals("orange")) {
			return new int[] {3,1000};
		} else if(s.equals("yellow")) {
			return new int[] {4,10000};
		} else if(s.equals("green")) {
			return new int[] {5,100000};
		} else if(s.equals("blue")) {
			return new int[] {6,1000000};
		} else if(s.equals("violet")) {
			return new int[] {7,10000000};
		} else if(s.equals("grey")) {
			return new int[] {8,100000000};
		}
		return new int[] {9,1000000000};
	}
}
