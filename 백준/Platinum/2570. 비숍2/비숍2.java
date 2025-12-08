import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int M;
	static int[][] map;
	static int[][][] digonals;
	static int[] numDigonal;
	
	static int[] p;
	static int[] check;
	static ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		map = new int[N][N];

		digonals = new int[2][101][101];
		numDigonal = new int[2];
        

		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int y=  Integer.parseInt(st.nextToken()) - 1;
			int x=  Integer.parseInt(st.nextToken()) - 1;

			map[y][x] =1;
		}
        
        
        
		defineDiagonal(0);
		defineDiagonal(1);
		
        for(int i=0; i<=numDigonal[0]; i++){
            edges.add(new ArrayList<Integer>());
        }
        
        //connect nodes
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                edges.get(digonals[0][i][j]).add(digonals[1][i][j]);
                // System.out.println(digonals[0][i][j] + " " + digonals[1][i][j]);
            }
        }
        
		p = new int[numDigonal[1]+1];
		Arrays.fill(p,-1);
        int ans = 0;
        for(int i=1; i<=numDigonal[0]; i++){
            check = new int[numDigonal[0]+1];
            
            if(bipartiteMatching(i)==1){
                ans++;
            }
            
        }
        
        System.out.println(ans);
        
	}
	
	
	public static int bipartiteMatching(int v){
	    //v == 연결할 노드 
	    // par[b] = a b 노드를 a가 점유중이다.
	    for(int n : edges.get(v)){ //나와 연결된 대각선b 들을 순회하면서, 내가 점유할 수 있다면 가지겠다. 
	        if(check[n] == 1) continue;
	        check[n] = 1;
	       // System.out.print(n+" ");
	        
	        if(p[n] == -1 || bipartiteMatching(p[n]) == 1) { //아직 아무도 갖지 않은 대각선b[n] 이면 바로 내꺼,
	        p[n] = v;
	        //그렇지 않은 경우에는 대각선b[n] 의 주인이었던 대각선a[ p[n] ]에게서 뺏는 것을 성공하면 내가 가지겠다. 
	            return 1; 
	        }
	    }
	    
	   // System.out.println("===");
	    
	    return 0; // 나와 연결된 대각선b의 모든 노드에 대해서 대각선a[v]와 연결될 수 없었다. 이미 다른 노드가 전부 가지고 있다.
	}
	

	public static void printMap(int[][] map) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				System.out.print(map[i][j]+ " " );
			}
			System.out.println();
		}
	}

	public static void defineDiagonal(int dir) {
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
            
				if(digonals[dir][i][j] > 0) continue;
				if(map[i][j] == 1) continue;
                
                int d = dir == 0 ? 1: -1;
				digonals[dir][i][j] = ++cnt;
				int sum = 1;
				while(true) {
					int y = sum+i;
					int x = (sum * d)+j;
                    if(y > N-1 || x> N-1 || y < 0 || x < 0) break;
					if(map[y][x] == 1){
					  break;  
					} 
					if(digonals[dir][y][x]>0){
					  break;  
					} 

					digonals[dir][y][x] = cnt;
					sum++;
				}
			}
		}
		
		numDigonal[dir] = cnt;
	}
}
