import java.util.*;
import java.io.*;

public class Main
{
	static char[] map;
	static StringBuilder sb = new StringBuilder();
	static int[][] check = { {0,1,2}, {3,4,5}, {6,7,8}, {0,3,6}, {1,4,7}, {2,5,8}, {0,4,8},{2,4,6} };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String input = br.readLine();
			if(input.equals("end")) {
				System.out.println(sb);
				return;
			}

			map = input.toCharArray();

			int cnt_O = 0;
			int cnt_X = 0;

			for(int i=0; i<9; i++) {
				if(map[i]=='O') {
					cnt_O++;
				} else if(map[i]=='X') cnt_X++;

			}

			if(cnt_O + cnt_X == 9 ) {
				if((cnt_O +1 )== cnt_X) {
					if(OWin()) {
						sb.append("invalid").append("\n");
					} else {
						sb.append("valid").append("\n");
					}
				}
				else sb.append("invalid").append("\n");
				continue;
			}

			boolean result = checkMap( cnt_O,  cnt_X);
			if(result) {
				sb.append("valid").append("\n");
			} else {
				sb.append("invalid").append("\n");
			}
		}


	}

	static public boolean XWin() {
		boolean flag = false;
		for(int i=0; i<check.length; i++ ) {
			int bingo_X =0;
			for(int j=0; j<3; j++) {
				if(map[check[i][j]]=='X') bingo_X++;
			}

			if(bingo_X ==3) {
				if(!flag) flag = true;
				else return false;
			}
		}
		return flag;
	}

	static public boolean OWin() {
		for(int i=0; i<check.length; i++ ) {
			int bingo_O =0;
			int bingo_X =0;
			for(int j=0; j<3; j++) {
				if(map[check[i][j]] == 'O') bingo_O++;
				else if(map[check[i][j]]=='X') bingo_X++;
			}

			if(bingo_O ==3) return true;
		}

		return false;
	}

	static public boolean checkMap(int O, int X) {
		boolean flag = false;
		for(int i=0; i<check.length; i++ ) {
			int bingo_O =0;
			int bingo_X =0;
			for(int j=0; j<3; j++) {
				if(map[check[i][j]] == 'O') bingo_O++;
				else if(map[check[i][j]]=='X') bingo_X++;
			}

			if(bingo_O ==3 || bingo_X==3) {

				if(bingo_O==3 ) {
					if(O != X) return false;
				}
				
				if(bingo_X ==3) {
				    if((O+1) != X) return false;
				}
                
				if(!flag) {
					flag = true;
				} else {
					return false;
				}
			}
		}

		return flag;
	}

}
