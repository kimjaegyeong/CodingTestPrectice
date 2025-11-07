import java.util.*;
import java.io.*;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input;

        char[] v = new char[]{
            '`','1','2','3','4','5','6','7','8','9','0','-','=', 
            'Q','W','E','R','T','Y','U','I','O','P','[',']','\\',
            'A','S','D','F','G','H','J','K','L',';','\'',
            'Z','X','C','V','B','N','M',',','.','/'
        };

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < v.length; i++) {
            map.put(v[i], i);
        }

        // 여러 줄 입력 처리
        while ((input = br.readLine()) != null) {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == ' ') {
                    sb.append(' ');
                } else {
                    int idx = map.get(ch);
                    sb.append(v[idx - 1]);
                }
            }
            sb.append('\n'); // 줄 구분 유지
        }

        System.out.print(sb.toString());
    }
}
