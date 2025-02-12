import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static HashSet<String> geneSet = new HashSet<String>();
    static int visited[];
	static ArrayList<String> list;
	static int cnt = 0;
	static int ASCII_A = 65; 
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		visited = new int[26];
		for(int i=0 ;i<N; i++){
		    String input = st.nextToken();
		    if(geneSet.contains(input)){
		       int idx = compareGene(input.charAt(0), input.charAt(1));
		       visited[idx] = 1;
		        
		    }
		    geneSet.add(input);
		    
		}
		
		list = new ArrayList<>(geneSet);
	    getGene();
	    
	    for(int i=0 ; i < visited.length; i++){
	        if(visited[i] == 1) {
	            cnt++;
	            sb.append((char) (i + ASCII_A) +" ");
	        }
	    }
	    
	    System.out.println(cnt);
	    System.out.println(sb);
	}
	
	static void getGene(){
	    for(int i=0; i<list.size(); i++){
	        for(int j=i+1; j<list.size(); j++){
	            pickGene(list.get(i), list.get(j));
	        }
	    }    
	}
	
	static void pickGene(String left, String right){
	    visited[compareGene(left.charAt(0), right.charAt(1))] = 1;
	    visited[compareGene(left.charAt(1), right.charAt(0))] = 1;
	    
	}
	
	static int compareGene(char g1, char g2){
	    if(g1 > g2) {
	        return parseIdx(g1); 
	    }
	    return parseIdx(g2);
	}
	
	static int parseIdx(char ch){
	    return ch - ASCII_A;
	}
}
