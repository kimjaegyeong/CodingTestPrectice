import java.util.*;
import java.io.*;
public class Main
{
	static char[][] map;
	static int dy[] = {1,1,1,0,0,0,-1,-1,-1};
	static int dx[] = {-1,0,1,-1,0,1,-1,0,1};
	static int jy ;
	static int jx;
	static int[][] arduino;
	static int cnt;
	static int R;
	static int C;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
        
        map = new char[R][C];
        arduino = new int[R][C];
		for(int i=0; i<R; i++) {
			String input =br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j]=='I') {
					jy = i;
					jx = j;
				}
				else if(map[i][j] =='R') {
					arduino[i][j] = 1;
				}
			}
		}

		String input = br.readLine();

		for(int i=0; i<input.length(); i++) {
			int dir = input.charAt(i) - 49 ;
			
			jy = jy + dy[dir];
			jx = jx + dx[dir];

			if(arduino[jy][jx] > 0) {
				System.out.println("kraj " + (i + 1));
				return;
			}
			boolean flag = move();
			if(flag) {
				System.out.println("kraj " + (i + 1));
				return ;
			}
		}
		
        
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(arduino[i][j] == 1) sb.append("R");
                else if(i == jy && j == jx) {
                    sb.append("I");
                }else{
                    sb.append(".");
                }
            }
            sb.append("\n");
        }
        
        
        System.out.println(sb);

        




	}

	public static int calDist(int y, int x) {
		return Math.abs(jy- y) + Math.abs(jx- x);

	}

	public static boolean move() {
	       
	   ArrayList<int[]> list = new ArrayList<int[]>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(arduino[i][j] > 0) {
				    int minDist = 10000001;
				    int minDir = 10000001;
				    
					for(int d=0; d<=8; d++) {
					    if(d == 4) continue;
					    if(!check(i+dy[d] , j + dx[d])) continue;
						int dist = calDist(i + dy[d],j + dx[d]);
						if(dist == 0) return true;
						if(dist < minDist) {
						    minDist = dist;
						    minDir = d;
						    
						}
					}
					
					list.add(new int[]{i,j,minDir});

				}
			}
		}
		
		for(int i=0 ;i<list.size(); i++){
		    int[] coord = list.get(i);
		    arduino[coord[0] + dy[coord[2]] ][ coord[1] + dx[coord[2]]]++ ;
		    arduino[coord[0]][coord[1]] --;
		}
		
		//bomb
		
		for(int i=0; i<R; i++){
		    for(int j=0; j<C; j++){
		        if(arduino[i][j] > 1) {
		            arduino[i][j] = 0;
		        }
		    }
		}
		
		return false;
	}

	public static boolean check(int y, int x) {
		if(y >= R || x>=C || y<0 || x<0) return false;
		return true;
	}
}
