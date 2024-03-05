import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
public class Main {
    static int T;
    static char[] v;
    static   Deque<Character> stack = new ArrayDeque<>();
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for(int t=0; t<T; t++){
            v = br.readLine().toCharArray();
            stack.clear();
            if(v[0]==')'){
                sb.append("NO").append("\n");
                continue;
            }
            stack.push(v[0]);

            boolean result =stack();
            if(result){
                sb.append("YES").append("\n");
            }else{
                sb.append("NO").append("\n");
            }
        }

        System.out.println(sb);
    }

    static boolean stack(){
        for(int i=1; i<v.length; i++){

            if(v[i] == ')'){
                if(stack.isEmpty()) {
                    return false;
                }
                if(stack.peek()=='(') stack.pop();
            }else{
                stack.push(v[i]);
            }
        }
        if(stack.isEmpty()){
            return true;

        }else{
           return false;
        }
    }
}
