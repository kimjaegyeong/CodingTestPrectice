import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int map[][];

	static int result ;
	static int dy[] = {0,0,1,-1};
	static int dx[] = {1,-1,0,0};
	static int students[][];
	static int order[];
	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		students = new int[N*N + 1][4];
		order = new int[N*N];
		map = new int[N][N];
		for(int i=0; i<N*N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			order[i] = Integer.parseInt(st.nextToken());
			for(int j=0; j<4; j++) {
				students[order[i]][j] = Integer.parseInt(st.nextToken());
			}
		}
	

		for(int i=0; i<N*N; i++) {
            // System.out.println("==== " +  order[i] + " ====");
			simul(order[i]);
// print();
        
		}
        
        
        
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                int cnt =0;
                for(int d=0; d<4; d++){
                    int ny = i + dy[d];
                    int nx=  j + dx[d];

    
                    if(!check(ny,nx)) continue;
                    
                    for(int k=0; k<4; k++){

                        
                        if(students[map[i][j]][k] == map[ny][nx]){
                            cnt++;
                        } 
                    }
                }
                calHappy(cnt);
            }
        }
        System.out.println(result);

	}

	public static void print() {
		for(int i=0; i<N; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}

	public static void simul(int students) {
		int py = -1;
		int px = -1;

		int pn = 0; // emptyNum
		int fn = 0;  //favoriteNum
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {

				//already sit another students
				if(map[i][j]!=0 ) {
				    continue;
				}

				int tempPn = 0 ;
				int tempFn = 0 ;

				for(int k=0; k<4; k++) {
					int ny = i + dy[k];
					int nx = j + dx[k];
					if(!check(ny,nx)) continue;

					if(map[ny][nx] == 0 ) tempPn++;
					if(calFn(students,ny,nx)) tempFn++;
				}

				if(tempFn > fn) {
					fn = tempFn;
					pn = tempPn;
					py = i;
					px = j;

				}else if(tempFn == fn && pn < tempPn) {
					pn = tempPn;
					py = i;
					px = j;

				}
				
		    }
		}

		if(py == -1 && px == -1){
		    for(int i=0; i<N; i++){
		        for(int j=0; j<N; j++){
		            if(map[i][j] == 0 ){
		                map[i][j] = students;
		                return;
		            }  
		            
		        }
		    }
		}
		map[py][px] = students;
	}


	public static void calHappy(int happy) {
		if(happy == 1) {
			result++;
		} else if(happy==2) {
			result+=10;
		} else if(happy==3) {
			result+=100;
		} else if(happy==4) {
			result+=1000;
		}
	}

	public static boolean calFn(int s, int y, int x) {
		for(int i=0; i<4; i++) {
			if(map[y][x] == students[s][i]) {
				return true;
			}
		}
		return false;
	}

	public static boolean check(int y,int x) {
		if(y >= N || x >= N || y< 0 || x < 0) return false;
		return true;
	}
}
