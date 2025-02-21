import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int L;
	static int W;
	static int weight[];
	static int truckPos[];
	static int time = 0;
	static int cnt;
	static int totalW;
	static int totalT;
	static int head;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		W = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		weight = new int[N];
		truckPos = new int[N];
		for(int i=0; i<N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}


		for(int i=0; i<N; i++) {
			putTruck(i);
		}

        if(truckPos[N-1]>=0){
		    time+=W - truckPos[N-1] + 1;            
        }

		System.out.println(time);

	}

	public static void putTruck(int truck) {
	    
		if(check(weight[truck])) {
			time++;
			move(1);
			truckPos[truck] = 1;
			totalW += weight[truck];
			totalT++;
			
		} else {
		    while(!check(weight[truck])){
		        pollHead();    
		    }
			truckPos[truck] = 1;
			totalW += weight[truck];
			totalT++;
		}

	}

	public static void pollHead() {
		int pos = truckPos[head];
		int dist = W - pos +1;
		move(dist);
		time+=dist;

	}

	public static void move(int dist) {
		for(int i=0; i<N; i++) {
			if(truckPos[i]>0) {
				truckPos[i]+=dist;
			}
		}

		if(truckPos[head] > W){
		    truckPos[head] = -1; 
		    totalW-= weight[head];
		    totalT--;
			head++;
		}
	}

	public static boolean check(int w) {
		if(w + totalW <= L && totalT < W) {
			return true;
		}
		return false;
	}
}