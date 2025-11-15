import java.util.*;
import java.io.*;

class Node {
	char alpha;
	int aCost;
	int dCost;


	public Node(char alpha, int aCost, int dCost) {
		this.alpha = alpha;
		this.aCost= aCost;
		this.dCost= dCost;
	}

}

public class Main
{
	static int N;
	static int M;
	static int K;

	static Node[] map;
	static int[] detach;
	static int[] attach;
    
    static int[] isAlpha = new int[27];
    
    static int ans = 100000001;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		map= new Node[N];
		
		Node[] nodes = new Node[M];

		ArrayList<Node>[] attachList = new ArrayList[27];

		for(int i=0; i<27; i++) {
			attachList[i] = new ArrayList<>();
		}


		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			char alpha = st.nextToken().charAt(0);
			int dCost = Integer.parseInt(st.nextToken());
			int aCost = Integer.parseInt(st.nextToken());
			nodes[i] =  new Node(alpha, aCost, dCost);
			isAlpha[alpha - 97] = 1;
			attachList[alpha - 97].add(new Node(alpha, aCost, dCost)) ;
		}

		for(int i=0; i<27; i++) {
			Collections.sort(attachList[i], (a, n) -> Integer.compare(a.aCost, n.aCost));
		}


		st=  new StringTokenizer(br.readLine());

		for(int i=0; i<N; i++) {
			int idx = Integer.parseInt(st.nextToken());
			map[i] = nodes[idx - 1];
		}

		String input = br.readLine();
        

        //inputtext와 사용가능한 알바펫의 종류가 일치하는지 체크 필요 
        for(int i=0; i<input.length(); i++){
            if(isAlpha[input.charAt(i) - 97] == 0 ) {
                System.out.println(-1);
                return;
            }
        }
        

		int s = 0;
		int e = 0;

		while(s <= N - K ) {
			int sum =0;
			init();
			if(e - s > K -1 ) {
				s++;
			}
			else if( e -s < K -1 ) {
				e++;
			} else if(e -s == K - 1) {
                
                PriorityQueue<Integer> q[] = new PriorityQueue[27];
                
                for(int i=0; i<27; i++){
                    q[i] = new PriorityQueue<Integer>();
                }
                
                for(int i=0; i<s; i++){
                    q[map[i].alpha - 97].offer(map[i].dCost);
                }
                
                for(int i=s; i<=e; i++){
                    int dSticker = map[i].alpha - 97;
                    int goalSticker = input.charAt(i - s) - 97;
                    if(dSticker == goalSticker) {
                        continue;
                    }else{
                        q[map[i].alpha - 97].offer(0);
                        sum+= map[i].dCost;
                    }
                    
                }
                
                for(int i=e+1; i<N; i++){
                    q[map[i].alpha - 97].offer(map[i].dCost);
                }
                
                for(int i=s; i<=e; i++){
                    int dSticker = map[i].alpha - 97;
                    int goalSticker = input.charAt(i - s) - 97;
                    if(dSticker == goalSticker) {
                        continue;
                    }
                    
                    if(!q[goalSticker].isEmpty()){
                        int v = q[goalSticker].poll();
                        if(v < attachList[goalSticker].get(0).aCost){
                            sum+=v;
                        }else{
                            sum+= attachList[goalSticker].get(0).aCost;
                        }
                    }else{
                        sum+= attachList[goalSticker].get(0).aCost;
                    }
                }
                ans = Math.min(ans, sum);
                
                e++;
                
			}
		}
		
		System.out.println(ans);
	}

	public static void init() {
		detach = new int[27];
		attach = new int[27];
	}
}
