import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int s;
	int e;

	public Node(int s, int e) {
		this.s = s;
		this.e = e;
	}

	public int compareTo(Node n) {
		return this.e - n.e ==0 ? this.s - n.s : this.e- n.e;
	}

}

public class Main
{
	static int N,K;
	static int cnt = 1;
	static Node meeting[];
	static PriorityQueue<Node> pq ;
	static boolean visited[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		meeting = new Node[N];

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			meeting[i] = new Node(s,e);
		}

		Arrays.sort(meeting);

		visited = new boolean[N];
        pq = new PriorityQueue<>((a, b) -> Integer.compare(b.e, a.e));

		for(int i=0; i<N; i++) {
            int idx = 0;
            Node[] rooms = new Node[K] ;
			while(!pq.isEmpty()) {
				Node n = pq.poll();

				if(meeting[i].s > n.e ) {
					cnt++;
					pq.offer(meeting[i]);
				
					break;
				} else if(pq.size() + idx +1 < K) {
					rooms[idx] = n;
					
					idx++;
					cnt++;
					pq.offer(meeting[i]);
					break;
				} else {
					rooms[idx] = n;
					idx++;
				}
			}

			for(int j=0; j<idx; j++) {
				pq.offer(rooms[j]);
			}
			
			if(pq.isEmpty() && pq.size() < K) {
				pq.offer(meeting[i]);
				continue;
			}

		}


		System.out.println(cnt);

	}

}
