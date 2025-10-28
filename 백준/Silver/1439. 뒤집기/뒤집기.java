import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim();
        if (s.length() == 0) {
            System.out.println(0);
            return;
        }

        int count0 = 0;
        int count1 = 0;
        char prev = '\0';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                if (c == '0') count0++;
                else if (c == '1') count1++;
                prev = c;
            }
        }

        System.out.println(Math.min(count0, count1));
    }
}
