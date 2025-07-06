import java.util.*;
import java.io.*;
public class Main
{
	static int P ;
	static int ASize;
	static int BSize;

	static int A[];
	static int B[];

	static int[][] Amap;
	static int[][] Bmap;

	static int[] piece;

	static int ans;
	
	static int aSum = 0;
	static int bSum =0;
    
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		P = Integer.parseInt(br.readLine());
		String[] input = br.readLine().split(" ");

		ASize = Integer.parseInt(input[0]);
		BSize = Integer.parseInt(input[1]);
		Amap = new int[ASize][ASize];
		Bmap=  new int[BSize][BSize];
		piece = new int[P+1];
		A = new int[ASize];
		B = new int[BSize];

		for(int i=0; i<ASize; i++) {
			A[i] = Integer.parseInt(br.readLine());
			aSum +=A[i];
		}

		for(int i=0; i<BSize; i++) {
			B[i] = Integer.parseInt(br.readLine());
			bSum+=B[i];
		}

		for(int i=0; i<ASize; i++) {
			Amap[0][i] = A[i];
			piece[A[i]]++;
		}

		for(int i=1; i<ASize-1; i++) { //전체합이 중복으로 map에 저장되는 경우 배제제
			for(int j=0; j<ASize; j++) {
				int next = (j+i) % ASize;
				Amap[i][j] = Amap[i-1][j] + A[next];
				if(Amap[i][j] <= P  ) {
					piece[Amap[i][j]]++;
				}
			}
		}
		
		if(aSum <= P) {
		    piece[aSum]++;    
		}
		

		for(int i=0; i<BSize; i++) {
			Bmap[0][i] = B[i];
		}

		for(int i=1; i<BSize-1; i++) {
			for(int j=0; j<BSize; j++) {
				int next = (j+i) % BSize;
				Bmap[i][j] = Bmap[i-1][j] + B[next];
			}
		}

		for(int i=0; i<BSize-1; i++) {
			for(int j=0; j<BSize; j++) {
				if(P - Bmap[i][j] > 0 ) { // 무조건 A 구간합 + B 구간합으로 이루어져야 하는 경우 
					ans+=piece[P-Bmap[i][j]];
				} else if(P == Bmap[i][j]) { // B 구간합이 P 인 경우 
					ans++;
				} 
			}
		}
		
		
		if(P - bSum > 0){
		      ans+= piece[P - bSum];    
		 }
		 
		
		ans+= piece[P]; //A 의 부분조각이 정답 그 자체일 때

		if(bSum == P){
		  ans++;
		} 
		System.out.println(ans);

	}
}
