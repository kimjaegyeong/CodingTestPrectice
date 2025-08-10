import java.util.*;
import java.io.*;

public class Main
{
	static int N;
	static int size =0;
	static ArrayList<Integer> list;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		for(int i=1; i<=N; i++) {
			int x1 = N;
			int x2 = i;
			ArrayList<Integer> nList = new ArrayList<Integer>();
			nList.add(x1);
			nList.add(x2);
			int next = x2;
			while(next >= 0) {
				if(x1- x2 >=0) {
					next = x1- x2;
					x1 = x2;
					x2 = next;
					nList.add(x2);
				}else{
				    if(size < nList.size()){
				        list = nList;
				        size = nList.size();
				    }
				    break;
				}
			}
		}
		
		sb.append(size).append("\n");
        for(int i : list){
            sb.append(i).append(" ");
        }
        System.out.println(sb);
	}
}
