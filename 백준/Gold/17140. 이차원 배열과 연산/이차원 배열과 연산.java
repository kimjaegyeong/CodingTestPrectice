import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    int v;
    int c;
    public Node(int v, int c) {
        this.v = v;
        this.c = c;
    }
    public int compareTo(Node n) {
        return this.c - n.c == 0 ? this.v - n.v : this.c - n.c;
    }
    public String toString() {
        return "(" + v + ", " + c + ")";
    }
}

public class Main {
    static int R;
    static int C;
    static int K;
    static int time = 0;
    static final int N = 3;
    static int map[][];
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken()) - 1;
        C = Integer.parseInt(st.nextToken()) - 1;
        K = Integer.parseInt(st.nextToken());
        
        map = new int[N][N];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v;
            }
        }
        
        if(R < map.length && C < map[0].length && map[R][C] == K) {
            System.out.println(0);
            return;
        }
        
        boolean result = simul();
        if(result) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }
    
    public static boolean simul() {
        while(time <= 100) {
            time++;
            
            if(map.length >= map[0].length) {
                map = calR();
            } else {
                map = calC();
            }
            
            if(R < map.length && C < map[0].length && map[R][C] == K) {
                return true;
            }
        }
        return false;
    }
    
    public static int[][] calR() {
        int max = 0;
        ArrayList<ArrayList<Node>> mapList = new ArrayList<>();
        
        for(int i = 0; i < map.length; i++) {
            int v[] = new int[101];
            for(int j = 0; j < map[0].length; j++) {
                int value = map[i][j];
                if(value != 0) {
                    v[value]++;
                }
            }
            
            ArrayList<Node> list = new ArrayList<>();
            for(int j = 1; j < v.length; j++) {  // j=1부터 시작 (0은 무시)
                if(v[j] > 0) {
                    list.add(new Node(j, v[j]));
                }
            }
            
            Collections.sort(list);
            mapList.add(list);
            max = Math.max(max, list.size());
        }
        
        // 새 배열 크기 결정
        int newCol = Math.min(max * 2, 100);
        if(newCol == 0) newCol = 2; // 최소 크기
        
        int[][] newMap = new int[map.length][newCol];
        
        for(int i = 0; i < mapList.size(); i++) {
            ArrayList<Node> list = mapList.get(i);
            int idx = 0;
            
            for(int j = 0; j < list.size() && idx < newCol - 1; j++) {
                newMap[i][idx] = list.get(j).v;      // 수
                newMap[i][idx + 1] = list.get(j).c;  // 횟수
                idx += 2;
            }
        }
        
        return newMap;
    }
    
    public static int[][] calC() {
        int max = 0;
        ArrayList<ArrayList<Node>> mapList = new ArrayList<>();
        
        for(int i = 0; i < map[0].length; i++) {
            int v[] = new int[101];
            for(int j = 0; j < map.length; j++) {
                int value = map[j][i];
                if(value != 0) {
                    v[value]++;
                }
            }
            
            ArrayList<Node> list = new ArrayList<>();
            for(int j = 1; j < v.length; j++) {  // j=1부터 시작 (0은 무시)
                if(v[j] > 0) {
                    list.add(new Node(j, v[j]));
                }
            }
            
            Collections.sort(list);
            mapList.add(list);
            max = Math.max(max, list.size());
        }
        
        // 새 배열 크기 결정
        int newRow = Math.min(max * 2, 100);
        if(newRow == 0) newRow = 2; // 최소 크기
        
        int[][] newMap = new int[newRow][map[0].length];
        
        for(int i = 0; i < mapList.size(); i++) {
            ArrayList<Node> list = mapList.get(i);
            int idx = 0;
            
            for(int j = 0; j < list.size() && idx < newRow - 1; j++) {
                newMap[idx][i] = list.get(j).v;      // 수
                newMap[idx + 1][i] = list.get(j).c;  // 횟수
                idx += 2;
            }
        }
        
        return newMap;
    }
}