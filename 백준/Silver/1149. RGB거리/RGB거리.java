import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static  int N;
    static  int map[][];

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        //red = [0][N], green =[1][N], blue = [2][N]
        map = new int[3][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int red = Integer.parseInt(st.nextToken());
            int green = Integer.parseInt(st.nextToken());
            int blue = Integer.parseInt(st.nextToken());

            map[0][i] = Math.min(map[1][i-1] , map[2][i-1]) + red;
            map[1][i] = Math.min(map[0][i-1], map[2][i-1]) + green;
            map[2][i] = Math.min(map[0][i-1], map[1][i-1]) + blue;

        }

        int min = Integer.MAX_VALUE;
        for(int i=0; i<3; i++){
            min=  Math.min(map[i][N],min);
        }

        System.out.println(min);

    }
}
