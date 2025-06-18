import java.util.*;
import java.io.*;

class Event implements Comparable<Event> {
    double gradient;
    int state;

    public Event(double gradient, int state) {
        this.gradient = gradient;
        this.state = state;
    }

    public int compareTo(Event e) {
        return Double.compare(this.gradient, e.gradient);
    }
}

public class Main {
    static int N;
    static ArrayList<Event> events = new ArrayList<>();
    static int MAX  = -1;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());

            double g1 = y2 / x1;
            double g2 = y1 / x2;
            
            double min = 0;
            double max = 0;
            if(g1 > g2) {
                min = g2;
                max=  g1;
            }else {
                min = g1;
                max = g2;
            }

            events.add(new Event(min, 1));  
            events.add(new Event(max, -1)); 
        }

        Collections.sort(events);
        
        int cnt = 0;
        for (Event e : events) {
            cnt += e.state;
            MAX = Math.max(MAX, cnt);
        }

        System.out.println(MAX);  
    }
}