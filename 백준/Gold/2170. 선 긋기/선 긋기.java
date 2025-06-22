import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
	int s;
	int e;

	public Node(int s, int e) {
		this.s=s;
		this.e=e;
	}

	public int compareTo(Node n ) {
		return this.s- n.s == 0 ? this.e - n.e : this.s - n.s ;
	}
}

public class Main
{
	static int total;
	static int N;
	static ArrayList<Node> list= new ArrayList<Node>();
	static PriorityQueue<Node> pq = new PriorityQueue<Node>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());

		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			pq.offer(new Node(s,e));

		}

		Node first = pq.poll();
		int start =first.s;
		int end = first.e;

		while(!pq.isEmpty()) {
			Node now = pq.poll();
			if (now.s <= end) {
				end = Math.max(end, now.e);
			} else {
				total += end - start;
				start = now.s;
				end = now.e;
			}
		}
		total += end - start;

		System.out.println(total);

	}




}
