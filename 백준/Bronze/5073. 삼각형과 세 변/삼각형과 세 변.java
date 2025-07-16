import java.util.*;
import java.io.*;
public class Main
{
	static int a;
	static int b;
	static int c;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			c = Integer.parseInt(st.nextToken());

			if(a==0 && b==0 && c==0) {
				break;
			}

			int v[]= new int[3];
			v[0] = a;
			v[1] =b;
			v[2] = c;
            
            Arrays.sort(v);
            
            if(v[2] >= v[0] + v[1]){
                sb.append("Invalid\n");
                continue;
            }



			//same three Equilateral
			if(a==b && b==c && c==a) {
				sb.append("Equilateral\n");
			} else if( a==b || b==c || c==a) {

				sb.append("Isosceles\n");

			} else if(a!=b && b!=c && c!=a) {
				sb.append("Scalene\n");
			} else {
				sb.append("Invalid");
			}
			// same two Isosceles

			// diffrent three Scalene
		}
		System.out.println(sb);
	}
}
