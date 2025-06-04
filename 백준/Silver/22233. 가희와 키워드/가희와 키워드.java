import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static int M;
    static int cnt =0;
    static HashSet<String> set = new HashSet<String>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++){
		    set.add(br.readLine());
		}
		
		
		for(int i=0; i<M; i++){
		    st = new StringTokenizer(br.readLine(),",");
		    int it = st.countTokens(); 
            for(int j=0; j<it; j++){
                String word = st.nextToken();
                
                if(set.contains(word)){
                    set.remove(word);
                }
            }
		    
		    sb.append(set.size()).append("\n");
		}
		
		System.out.println(sb);
	}
}
