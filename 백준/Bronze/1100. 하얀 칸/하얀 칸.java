import java.util.*;
import java.io.*;

public class Main {
    static char[][] map;
    static int N = 8;
    
    static int ans=0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine(); 
            for (int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j);
            }
        }
        
        for(int i=0; i<N; i++){
            if(i%2==0) {
                for(int j=0; j<N; j+=2){
                    if(map[i][j] == 'F') {
                        ans++;
                    }
                }
            }else {
                for(int j=1; j<N; j+=2){
                    if(map[i][j]=='F'){
                        ans++;
                    }
                }
            }
        }
        
        System.out.println(ans);

    }
}
