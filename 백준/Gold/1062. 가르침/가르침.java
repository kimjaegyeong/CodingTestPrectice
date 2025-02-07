import java.util.*;
import java.io.*;

/*
3 6
antarctica
antahellotica
antacartica

*/
public class Main
{
    static int N,K;
    static String[] words;
    static int result = 0;
	static HashSet<Character> totalSet = new HashSet<>();
	static ArrayList<HashSet<Character>> wordSet = new ArrayList<>();
	static ArrayList<Character> totalList ;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
	    visited = new boolean[27];
	    words = new String[N];
	    
	    for(int i=0; i<N; i++){
	        words[i] = br.readLine();
	    }
	    
	    for(int i=0; i<N; i++){
	        wordSet.add( new HashSet<Character>()) ;
	    }
	
    	for(int i=0; i<N; i++){
    	    for(int j=0; j<words[i].length() ; j++){
    	        totalSet.add(words[i].charAt(j));
    	        wordSet.get(i).add(words[i].charAt(j));
	        }
	    }
	    
	     totalList = new ArrayList<>(totalSet);
	     visited[(int) 'a' - 97] = true;
	     visited[(int) 'i' - 97] = true;
	     visited[(int) 't' - 97] = true;
	     visited[(int) 'c' - 97] = true;
	     visited[(int) 'n' - 97] = true;
	    if(K < 5) {
	        System.out.println(0);
	        return;
	    }
	    backTracking(0,5);
        System.out.println(result);
	    
	}
    
    
    public static boolean hasAlpha(int i){
        for(Character c : wordSet.get(i)){
            if(!visited[ (int) c - 97]){
                return false;
            }
        }
        return true;
    }
    
    public static void backTracking(int n, int depth){
        if(depth == K || depth == totalSet.size() ){ 
            int totalSameCnt = 0 ;
            for(int i=0 ;i<wordSet.size(); i++){
                if(hasAlpha(i)) totalSameCnt++;
            }
        
            result = Math.max(totalSameCnt, result);
            
            return;
            
        }
        
        for(int i = n ; i < totalList.size(); i++){
            int idx = (int) totalList.get(i) - 97;
            if(!visited[idx]){
                visited[idx] = true;
                backTracking(i+1, depth+1);
                visited[idx] = false;        
            }
        }
    }
}
