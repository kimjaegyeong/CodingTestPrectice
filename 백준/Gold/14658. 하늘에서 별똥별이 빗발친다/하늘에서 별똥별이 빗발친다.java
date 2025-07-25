import java.util.*;
import java.io.*;

class Star{
    int y;
    int x;
    
    public Star(int x, int y){
        this.y=y;
        this.x=x;
    }
}

public class Main
{
    static int N;
    static int M;
    static int L;
    static int K;
    static int ans = -1;
    static HashSet<Integer> ySet = new HashSet<Integer>();
    static HashSet<Integer> xSet = new HashSet<Integer>();

    static Star[] arr;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		arr = new Star[K];
		for(int i=0; i<K; i++){
		    st = new StringTokenizer(br.readLine());
		    int x = Integer.parseInt(st.nextToken());
		    int y = Integer.parseInt(st.nextToken());
		    xSet.add(x);
		    ySet.add(y);
		    arr[i] = new Star(x,y);
		}
		
		Iterator xIt = xSet.iterator();
		
		while(xIt.hasNext()){
		    int x = (int) xIt.next();
		    Iterator yIt = ySet.iterator();
		    while(yIt.hasNext()){
		        int y = (int) yIt.next();
                
                ans = Math.max(ans,cntStar(x,y));
		    }
		}
		
		System.out.println(K - ans);
	}
	
	public static int cntStar(int x, int y){
	    int ey = y + L;
	    int ex = x + L;
	    int cnt = 0;
        
        for(Star s : arr){
            if((s.x >= x && s.x <=ex) && (s.y >= y && s.y<= ey)){
                cnt++;
            }
        }
         
	    return cnt;
	    
	}
}
