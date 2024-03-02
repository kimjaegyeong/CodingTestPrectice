import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int N;
    static int[] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map= new int[N+1];

        if(N<3){
            System.out.println(N% 10007);
            return;
        }
        map[0] =0 % 10007 ;
        map[1] =1% 10007;
        map[2] =2% 10007;
        map[3] =3% 10007;

        for(int i=3; i<=N; i++){
            map[i] = (map[i-1]+ map[i-2]) % 10007;
        }

        System.out.println(map[N]);
        }
}
