import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Meeting implements Comparable<Meeting>{
        long s, e;

        public Meeting(long s , long e){
            this.s =s;
            this.e= e;
        }
        public String toString(){
            return "s: " +s + " e: " + e;
        }
        public int compareTo(Meeting m){
          long result =  this.e - m.e == 0 ? this.s - m.s : this.e- m.e;
          return (int)result;
        }

    }
    static int N;
    static Meeting[] meetings;
    public static void main(String[] args) throws Exception{
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        meetings = new Meeting[N];
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            meetings[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(meetings);
        long start =0 ;
        int cnt =0;
        for(int i=0; i<N ; i++){
            if(meetings[i].s >=start){
                start = meetings[i].e;
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
