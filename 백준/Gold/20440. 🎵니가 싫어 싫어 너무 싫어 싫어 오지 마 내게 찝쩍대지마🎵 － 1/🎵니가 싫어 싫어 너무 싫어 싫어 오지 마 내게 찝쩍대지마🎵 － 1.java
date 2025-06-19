import java.util.*;
import java.io.*;

class Event implements Comparable<Event> {
	int time;
	int state;

	public Event(int time, int state) {
		this.time = time;
		this.state = state;
	}

	public int compareTo(Event e) {
		return this.time - e.time == 0 ? this.state - e.state : this.time - e.time;
	}
}

public class Main
{
	static int N;
	static int max = -1;
	static ArrayList<Event> events = new ArrayList<Event>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st =new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			events.add(new Event(s, 1));
			events.add(new Event(e, -1));

		}

		Collections.sort(events);

		int cnt = 0;
		int start = 0;
		int end = 0;
		ArrayList<int[]> list= new ArrayList<int[]>();
		for(Event e : events) {
			cnt+=e.state;

			if(max < cnt) {
				max = cnt;
				start = e.time;

			}
			else if(max == cnt) {
			        start = e.time;
			}
			else if( max -1 == cnt) {
			    end = e.time;
			    list.add(new int[]{start,end, max});
			}

		}
        
        Collections.sort(list, (a,b) -> Integer.compare(a[0], b[0]));
        
        int ans =0;
        int as= -1;
        int ae=-1;
		for(int i =0 ; i<list.size(); i++){
            
		    int[] coord = list.get(i);

		    if(ans < coord[2]){
		        as = coord[0];
		        ae= coord[1];
		        ans = coord[2];
		    }else if ( ans == coord[2]) {
		        if(ae == coord[0]) {
		            ae = coord[1];
		        }
		    }
		}
		
		System.out.println(ans);
		System.out.println(as + " " +ae);


	}
}
