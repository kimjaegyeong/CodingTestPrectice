import java.util.*;
import java.io.*;

class Node{
    int oi,ci;
    
    public Node(int oi, int ci){
        this.oi = oi;
        this.ci = ci;
    }
}

public class Main
{
    static char[] exp;
	static ArrayList<Node> parentheses = new ArrayList<>();
	static ArrayDeque<Character> stack = new ArrayDeque<>();
	static ArrayDeque<Integer> idxStack = new ArrayDeque<>(); 
	static HashSet<String> set = new HashSet<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		exp = new char[input.length()];

		for(int i=0; i<input.length(); i++){
		   exp[i] = input.charAt(i);
		   searchParentheses(exp[i], i);
		}
        
        for(int i= 1; i< (1 << parentheses.size()); i++){
             StringBuilder sb = new StringBuilder();
            // ArrayList<Integer> arr = new ArrayList<>();
            char[] copyExp = new char[exp.length];
            for(int j=0; j<exp.length; j++){
                copyExp[j] = exp[j];
            }
            
            for(int j= 0; j < parentheses.size(); j++){
                
                if((i & (1 << j)) != 0 ){
                    copyExp[parentheses.get(j).oi] = '.';
                    copyExp[parentheses.get(j).ci] = '.';
                }
            }
            
            for(int j=0; j<copyExp.length; j++){
                if(copyExp[j] !='.'){
                    sb.append(copyExp[j]);
                }
            }
            set.add(sb.toString());
        }
        
        StringBuilder sb = new StringBuilder();
        List<String> temp = new ArrayList<>(set);
        Collections.sort(temp);

        for(String c : temp){
            sb.append(c);
            sb.append("\n");
        }
        
        System.out.println(sb);
	}
	
	public static void searchParentheses(char element, int idx){
	    if(element == ')'){
	        char prev = stack.peek();
	        if(prev == '('){
	            stack.pop();
	            int prevIdx = idxStack.pop();
	            parentheses.add(new Node(prevIdx, idx));
	        }
	    }else if(element=='('){
	        stack.push(element);
	        idxStack.push(idx);
	    }
	}
	
}
