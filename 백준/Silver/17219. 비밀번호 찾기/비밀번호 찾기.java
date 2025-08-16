import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int M;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		HashMap<String, String> map = new HashMap<String,String>();
		for(int i=0; i<N; i++){
		    st= new StringTokenizer(br.readLine());
		    
		    map.put(st.nextToken(), st.nextToken());
		}
		
		for(int i=0; i<M; i++){
		    String input = br.readLine();
		    sb.append(map.get(input)).append("\n");
		}
		
		System.out.println(sb);
	}
}
