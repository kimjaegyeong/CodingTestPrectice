import java.util.*;
import java.io.*;
public class Main
{
	static int G;
	static int P;

	static int p[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		G = Integer.parseInt(br.readLine());
		P = Integer.parseInt(br.readLine());
		p = new int[G+1];
		for(int i=0; i<=G; i++) {
			p[i] = i;
		}
		for (int i = 0; i < P; i++) {
			int ap = Integer.parseInt(br.readLine());

			int parent = find(ap);

			if (parent == 0) {
				System.out.println(i);
				return;
			}

			p[parent] = find(parent - 1);
		}


		System.out.println(P);

	}


	public static int find(int a) {
		if(p[a] == a) return a;
		return p[a] = find(p[a]);

	}



}
