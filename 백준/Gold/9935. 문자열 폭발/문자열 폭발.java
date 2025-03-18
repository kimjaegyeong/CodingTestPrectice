import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String mapping = br.readLine();

        Stack<Character> stack = new Stack<>();

        for(int i=0; i<input.length(); i++) {
            stack.push(input.charAt(i));

            if(stack.size()>= mapping.length()) {
                boolean flag = true;

                for(int j=0; j<mapping.length(); j++) {
                    if(stack.get(stack.size()-mapping.length()+j) != mapping.charAt(j)) {
                        flag = false;
                        break;
                    }
                }
                
                if(flag) {
                    for(int j=0; j<mapping.length(); j++) {
                        stack.pop();
                    }
                }
            }

        }

        StringBuilder sb = new StringBuilder();
        for(Character c : stack) {
            sb.append(c);
        }
        System.out.println(sb.length()==0? "FRULA" : sb.toString());
    }
}