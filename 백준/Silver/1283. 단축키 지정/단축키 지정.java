import java.util.*;
import java.io.*;
public class Main
{
    static int N;
    static String words[];
    static int idx = -1;
    static int pre = -1;
    static int len = 0;
    static HashSet<Character> map = new HashSet<Character>();
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    words = new String[10];
		    len = 0;
		    while(st.hasMoreTokens()){
		        
		        words[len] = st.nextToken();
		        len++;
		    }
		    idx = -1;
		    pre = -1; 
		    for(int j=0; j<len; j++){
		        if(!map.contains(words[j].toLowerCase().charAt(0))){
		            map.add(words[j].toLowerCase().charAt(0));
		            idx = j;
		            break;
		        }
		    }
		    
		    //idx > 0 이면 처리 하고 continue 
		    if(idx == -1){
		        search();
		    }
		    
		    sbAppend(idx,pre);
		   
		}
		System.out.println(sb);   
	}
	
	public static boolean search(){
	    for(int j=0; j<len; j++){
	                
		            for(int k=0; k<words[j].length(); k++){
		                
		                if(!map.contains(words[j].toLowerCase().charAt(k))) {
		                    
		                    idx = j;
		                    pre = k;
		                    map.add(words[j].toLowerCase().charAt(k));
		                    return true;
		                }
		            }
		        }
		        
		        return false;
	}
	
	public static void sbAppend(int idx, int pre ) {
	    for(int i=0; i<len; i++){
	        for(int j=0; j<words[i].length(); j++){
	            if(i == idx && pre == j) {
	                sb.append("[");
	                sb.append(words[i].charAt(pre));
	                sb.append("]");
	                idx =-1;
	                pre = -1;
	            }
	            
	            else if(i==idx && pre == -1){
	                sb.append("[");
	                sb.append(words[i].charAt(0));
	                sb.append("]");
	                idx= -1;
	            }
	            else {
	                sb.append(words[i].charAt(j));
	            } 
	           
	        }
	        sb.append(" ");
	    }
	    sb.append("\n");
	}
}
