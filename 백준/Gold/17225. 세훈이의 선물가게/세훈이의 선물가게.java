import java.util.*;
import java.io.*;

class Order implements Comparable<Order> {
    int t; 
    int c; 
    public Order(int t, int c) {
        this.t = t;
        this.c = c;
    }
    public int compareTo(Order o) {
        if (this.t == o.t) return this.c - o.c; 
        return this.t - o.t;
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        PriorityQueue<Order> pq = new PriorityQueue<>();
        int nowBlue = 0, nowRed = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int m = Integer.parseInt(st.nextToken());

            if (color == 'B') {
                int start = Math.max(nowBlue, t);
                for (int j = 0; j < m; j++) {
                    pq.offer(new Order(start, 0));
                    start += A;
                }
                nowBlue = start;
            } else {
                int start = Math.max(nowRed, t);
                for (int j = 0; j < m; j++) {
                    pq.offer(new Order(start, 1));
                    start += B;
                }
                nowRed = start;
            }
        }

        ArrayList<Integer> blue = new ArrayList<>();
        ArrayList<Integer> red = new ArrayList<>();
        int giftNum = 1;
        while (!pq.isEmpty()) {
            Order o = pq.poll();
            if (o.c == 0) blue.add(giftNum);
            else red.add(giftNum);
            giftNum++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(blue.size()).append("\n");
        for (int g : blue) sb.append(g).append(" ");
        sb.append("\n").append(red.size()).append("\n");
        for (int g : red) sb.append(g).append(" ");
        System.out.println(sb);
    }
}
