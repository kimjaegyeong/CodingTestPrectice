import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static boolean lights_origin[];
	static boolean result[];
	static boolean lights[];
	static int cnt = 0;
	static int res =Integer.MAX_VALUE;
	static boolean flag = true;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		lights_origin = new boolean[N];
		result = new boolean[N];

		String input = br.readLine();
		for(int i=0; i<N; i++) {
			lights_origin[i] = input.charAt(i) == '0' ? false : true;
		}

		input = br.readLine();

		for(int i=0; i<N; i++) {
			result[i] = input.charAt(i) == '0' ? false : true;
		}

		//input process end

		lights = copyMap(lights_origin);

		for(int i=0; i<N; i++) {

			if(lights[i] != result[i]) {

				if(i==N-1) {
					change(i);

				} else {
					change(i+1);
				}
				cnt++;
			}

			//  printMap(lights);
			boolean ans = diff(i);
			if(!ans ) {
				cnt = Integer.MAX_VALUE;
				break ;
			}
		}
	     res = Math.min(res, cnt);
        // end process 1 (don't turn off the first switch)
        


		cnt = 1;
		lights = copyMap(lights_origin);
		lights[0] = !lights[0];
		lights[1] = !lights[1];

		for(int i=0; i<N; i++) {

			if(lights[i] != result[i]) {

				if(i==N-1) {
					change(i);

				} else {
					change(i+1);
				}
				cnt++;
			}

			//  printMap(lights);
			boolean ans = diff(i);
			if(!ans) {
				cnt = Integer.MAX_VALUE;
				break;
			}
		}

		res = Math.min(cnt, res);
        
        if(res == Integer.MAX_VALUE) {
            System.out.println("-1");
            return; 
        }
		System.out.println(res);


	}

	public static void printMap(boolean[] map) {
		for(int i=0; i<N; i++) {
			System.out.print(map[i] == true ? "1" : "0"  );
		}
		System.out.println();
		System.out.println("======");
	}

	public static boolean diff(int idx) {
		    if(idx == 0) {
		        if(lights[idx]!=result[idx]) return false;
		    }
			else if(lights[idx-1]!=result[idx-1] || lights[idx] != result[idx]) return false;
		
		return true;
	}

	public static void change(int i) {
		if(i < N-1) {
			lights[i+1] = !lights[i+1];
		}
		lights[i] = !lights[i];
		lights[i-1] = !lights[i-1];

	}

	public static boolean[] copyMap(boolean[] map) {
		boolean[] copy = new boolean[N];
		for(int i=0; i<N; i++) {
			copy[i] = map[i];
		}

		return copy;
	}


}
