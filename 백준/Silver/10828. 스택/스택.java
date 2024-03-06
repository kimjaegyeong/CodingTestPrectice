import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            switch (commend){
                case "push":
                    int n = Integer.parseInt(st.nextToken());
                    stack.push(n);
                    break;
                case "pop":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(stack.pop());
                    }
                    break;
                case "top":
                    if(stack.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(stack.peek());
                    }
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    if(stack.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                    break;

            }
        }
    }
}
