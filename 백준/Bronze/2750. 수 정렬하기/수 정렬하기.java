import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[] array;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        array = new int[N];
        for(int n = 0; n < N; n++) array[n] = Integer.parseInt(br.readLine());
        Arrays.sort(array);
        for(int n: array) System.out.println(n);
    }
}
