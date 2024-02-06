import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int K;
    static int L;

    static int[] dy = {0,1,0,-1};
    static int[] dx= {1,0,-1,0};
    static int[][] map ;

    static char[] dir;
    static int[] dir_idx;
    static ArrayList<int[]> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N= Integer.parseInt(br.readLine());
        K= Integer.parseInt(br.readLine());
        map= new int[N][N];
        for(int i=0; i<K; i++){
            String[] input = br.readLine().split(" ");
            map[Integer.parseInt(input[0])-1][Integer.parseInt(input[1])-1] = 1;

        }
        L = Integer.parseInt(br.readLine());
        dir = new char[L];
        dir_idx = new int[L];

        for(int i=0; i<L; i++){
            String[] input = br.readLine().split(" ");
            dir_idx[i] = Integer.parseInt(input[0]);
            dir[i] = input[1].charAt(0);
        }
        snake = new ArrayList<>();
        int x =0,y =0;
        int d=0;
        int count =0;
        int sec=0;
        snake.add(new int[]{0,0});
        while(true){
            count++;
            int nx= x+ dx[d];
            int ny = y + dy[d];

            //종료조건
            if(nx<0 || ny<0 || nx>=N || ny>=N){
                break;
            }
            if(isHit(nx,ny)){
                break;
            }
            //종료조건 끝

            //한 칸 움직일 때
            snake.add(new int[]{ny, nx});

            if(map[ny][nx]!=1){ //사과가 없다면 꼬리 한칸 삭제 (몸이 자라나지 않기 때문)
                snake.remove(0);
            }else{

                map[ny][nx]=0;
            }


            if(sec<L && count==dir_idx[sec]){
                if(dir[sec]=='D'){
                    d++;

                    if(d>3){
                        d=0;
                    }
                }
                else{
                    d--;
                    if(d<0){
                        d=3;
                    }
                }
                sec++;
            }

            x = nx;
            y= ny;

        }
        System.out.println(count);

    }

    private static boolean isHit(int nx, int ny) {
        for(int i=0; i<snake.size(); i++){
            int[] isHit =snake.get(i);
            if(isHit[0]==ny && isHit[1]==nx ){

                return true;
            }
        }
        return false;
    }
}