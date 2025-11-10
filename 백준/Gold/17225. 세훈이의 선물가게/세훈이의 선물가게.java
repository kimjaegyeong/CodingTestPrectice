import java.util.*;
import java.io.*;

class Order implements Comparable<Order> {
	int t;
	int c;
	int n;
	public Order(int t, int c) {
		this.t=t;
		this.c=c;

	}

	public int compareTo(Order o) {
		return this.t - o.t == 0 ? this.c- o.c : this.t- o.t;
	}
}

public class Main


{
	static int A;
	static int B;
	static int N;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());

		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

        PriorityQueue<Order> pq = new PriorityQueue<Order>();

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			char c = st.nextToken().charAt(0);
			int n = Integer.parseInt(st.nextToken());
            
            int duration = A;
			int nColor = 0;
			if(c == 'R') {
				nColor = 1;
				duration = B;
			}
            
            int cnt = t;
            for(int j=0; j<n; j++){
                pq.offer(new Order(cnt,nColor));
                cnt+= duration;
            }
		}
		
		int aCnt = 0 ;
		int bCnt = 0;
		
		ArrayList<Integer> aList = new ArrayList<Integer>();
		ArrayList<Integer> bList =new ArrayList<Integer>();
		
		int giftNum = 1;
		while(!pq.isEmpty()){
		    Order o = pq.poll();
		    
		    if(o.c == 0) {
		        aCnt++;
		        aList.add(giftNum);
		    }else{
		        bCnt++;
		        bList.add(giftNum);
		    }
		    giftNum++;
		}
		
		sb.append(aCnt).append("\n");
		for(int gift : aList){
		    sb.append(gift).append(" ");
		}
		sb.append("\n");
		sb.append(bCnt).append("\n");
		for(int gift : bList){
		    sb.append(gift).append(" ");
		}
		
		System.out.println(sb);
	}
}