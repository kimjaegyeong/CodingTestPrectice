import java.util.*;
import java.io.*;

class Ball implements Comparable<Ball> {
    int color;
    int size;
    int idx;
    
    public Ball(int color, int size, int idx) {
        this.color = color;
        this.size = size;
        this.idx = idx;
    }
    
    public Ball(int size, int idx) {
        this.size = size;
        this.idx = idx;
    }
    
    public int compareTo(Ball b) {
        return this.size - b.size;
    }
}

public class Main {
    static int N;
    static Ball arr[];
    static int sum[];
    static int colorSum[];
    static int ans[];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        arr = new Ball[N];
        colorSum = new int[N+1];
        ans = new int[N];
        
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int color = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            arr[i] = new Ball(color, size, i);
        }
        
        Arrays.sort(arr);
        
        int totalSum = 0; 
        
        int i = 0;
        while(i < N) {
            int currentSize = arr[i].size;
            
            int j = i;
            while(j < N && arr[j].size == currentSize) {
                j++;
            }
            
            for(int k = i; k < j; k++) {
                Ball current = arr[k];
                ans[current.idx] = totalSum - colorSum[current.color];
            }
            
            for(int k = i; k < j; k++) {
                Ball current = arr[k];
                totalSum += current.size;
                colorSum[current.color] += current.size;
            }
            
            i = j;  
        }
        
        for(int i2 = 0; i2 < N; i2++) {
            sb.append(ans[i2]).append("\n");
        }
        
        System.out.print(sb);
    }
}