import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int dice[];
    static int diceDir;
    
    static int[] dy = {-1,0,1,0}; //북 동 남 서 
    static int[] dx = {0,1,0,-1};
    
    static int sy= 0;
    static int sx = 0;
    
    static int res = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    N = Integer.parseInt(st.nextToken());
	    M = Integer.parseInt(st.nextToken());	    
	    K = Integer.parseInt(st.nextToken());	    
	    
	    map = new int[N][M];
	    dice = new int[6]; // 동,서,남,북,천장,바닥
	    //초기상태
	    dice[0] = 3;
	    dice[1] = 4;
	    dice[2] = 2;
	    dice[3] = 5;
	    dice[4] = 1;
	    dice[5] = 6;
	    
	    diceDir = 1; 
	    
	    for(int i=0; i<N; i++){
	        st = new StringTokenizer(br.readLine());
	        for(int j=0; j<M; j++){
	            map[i][j] = Integer.parseInt(st.nextToken());
	        }
	    }
	    
	    
	    for(int i=0; i<K; i++){
	        int ny = sy + dy[diceDir];
	        int nx = sx + dx[diceDir];
	        
	        if(!check(ny,nx)){
	            if(diceDir == 1 || diceDir == 3) {
	                diceDir = diceDir == 1? 3 : 1;
	            }else{
	              diceDir =  diceDir ==  2 ? 0 : 2;
	            }
	            
	            ny = sy + dy[diceDir];
	            nx = sx + dx[diceDir];
	        }
	        moveDice();	        
	        res+=(getScore(ny,nx) * map[ny][nx]);
	        updateDir(ny,nx);

	        sy= ny;
	        sx = nx;
	       // System.out.println(sy+ " " + sx + " " + diceDir);
	       // System.out.println(Arrays.toString(dice));
	        
	    }
	    
	    System.out.println(res);
        
	}
	
	public static int getScore(int y, int x){
        ArrayDeque<int[]> q = new ArrayDeque<int[]>();
	    boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{y,x,1});
        visited[y][x] = true;
	    int max = 1;
	    int total = 0;
	    while(!q.isEmpty()){
	        int[] node = q.poll();
	        total++;
	        max = Math.max(max,node[2]);
	        for(int i=0; i<4; i++){
	            int ny = node[0] + dy[i];
	            int nx = node[1] + dx[i];
	            
	            if(!check(ny,nx) || visited[ny][nx] || map[ny][nx] != map[y][x]) continue;
	            
	            q.offer(new int[]{ny,nx,node[2]+1});
	            visited[ny][nx] = true;
	        }
	    }
	    

	    return total;
	}
	
	public static boolean check(int y, int x){
	    return y<N && x<M && y>=0 && x>=0;
	}
	
	public static void updateDir(int y, int x){
	    int A = dice[5];
	    int B = map[y][x];
	    
	    if(A > B ){
	        //시계방향 회전
	        diceDir++;
	        if(diceDir == 4) {
	            diceDir = 0;
	        }
	    }else if(A < B) {
	        //반시계방향 회전
	       diceDir = (diceDir +3) % 4;
	    }
	}
	
	// 0  1  2  3  4    5
	//동 서 남 북 천장 바닥 
	public static void moveDice(){
	    int tempDice[] = new int[6];
	    if(diceDir == 0) {
	        //남
	        tempDice[5] = dice[2];
	        tempDice[4] = dice[3];
	        tempDice[3] = dice[5];
	        tempDice[2] = dice[4];
	        tempDice[1] = dice[1];
	        tempDice[0] = dice[0];
	    }else if(diceDir ==1){
	        //동
	        tempDice[5] = dice[0];
	        tempDice[4] = dice[1];
	        tempDice[0] = dice[4];
	        tempDice[1] = dice[5];
	        tempDice[2] = dice[2];
	        tempDice[3] = dice[3];
	    }else if(diceDir ==2){
	        //북
	        tempDice[5] = dice[3];
	        tempDice[3] = dice[4];
	        tempDice[2] = dice[5];
	        tempDice[4] = dice[2];
	        tempDice[1] = dice[1];
	        tempDice[0] = dice[0];
	    }else{
	        //서
	        tempDice[5] = dice[1];
	        tempDice[4] = dice[0];
	        tempDice[1] = dice[4];
	        tempDice[0] = dice[5];
	        tempDice[2] = dice[2];
	        tempDice[3] = dice[3];
	    }
	    
	    dice = tempDice;
	}
}
