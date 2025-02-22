
import java.util.*;
import java.io.*;

public class Main
{
	static int R,C;
	static int N;
	static char map[][];
	static int[] dy = {1,-1,0,0};
	static int[] dx= {0,0,1,-1};
	static char third[][];
    static char four[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {

				map[i][j] = str.charAt(j);
			}
		}

		// Input Process End

		char[][] second = new char[R][C];

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				second[i][j]  = 'O';
			}
		} //폭탄 전부 심은 경우 

		third = new char[R][C];
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                third[i][j] = 'O';
            }
        }

		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 'O') {
					third[i][j] = '.';
					search(i,j,third);
				}
			}
		} //이게 첫번째로 만들어질 수 있는 map
		
		four = new char[R][C];
		
		        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                four[i][j] = 'O';
            }
        }
		
				for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(third[i][j] == 'O') {
					four[i][j] = '.';
					search(i,j,four);
				}
			}
		}// 이게 두번째 폭발에서 만들어질 수 있는 map ( third 의 O 에서 폭발이 일어난 경우 );
		    


		if(N==1) {
			printMap(map);
			return;

		}
		else if(N%2==0) {
			printMap(second);
		} else if(N%4==1) {
			printMap(four);
		} else if(N%4==3) {
			printMap(third);
		}


	}


	public static void printMap(char[][] map) {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}

	public static void search(int y, int x, char[][] map) {
		for(int d=0; d<4; d++) {
			int ny = y + dy[d];
			int nx= x + dx[d];
			if(check(ny,nx)) {
				map[ny][nx]='.';
			}
		}
	}
	public static boolean check(int y, int x) {
		if(y < 0 || x < 0 || y>=R || x>=C) {
			return false;
		}
		return true;
	}


}
