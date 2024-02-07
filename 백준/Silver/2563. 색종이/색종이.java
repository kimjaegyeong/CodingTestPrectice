import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int map[][]= new int[100][100];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new int[100][100];
        N = Integer.parseInt(br.readLine());
        int cnt =0;
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);

            for(int r=y; r<y+10; r++){
                for(int c=x; c<x+10; c++){
                    if(map[r][c]==0){
                        map[r][c] = 1;
                    }
                }
            }
        }

        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                if(map[i][j]==1){
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}
