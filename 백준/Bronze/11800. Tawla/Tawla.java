import java.util.*;
import java.io.*;
public class Main
{

    static StringBuilder sb = new StringBuilder();
	static String[] dice ;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
        dice = new String[7];
        
        dice[1] = "Yakk";
        dice[2] = "Doh";
        dice[3]= "Seh";
        dice[4] ="Ghar";
        dice[5] =  "Bang";
        dice[6] = "Sheesh";
		for(int i=1; i<=N; i++) {
			String[] input = br.readLine().split(" ");

			int a = Integer.parseInt(input[0]);
			int b = Integer.parseInt(input[1]);
            
            sb.append("Case " + i + ": ");
            
            String ans = "";
			if(a==b) {
				if(a== 1) {
                    ans =  "Habb Yakk"  ;
				}else if(a==2){
				    ans =  "Dobara" ;
				    
				}else if( a==3) {
				    ans="Dousa";
				}else if(a==4){
				    ans ="Dorgy";
				}else if(a==5){
				    ans = "Dabash";
				}else if(a==6){
				    ans= "Dosh";
				}
			}else
			 {
			     if((a==5 && b==6 )|| (a==6 && b==5)){
			         ans = "Sheesh Beesh";
			     } else {
			         
			         if(a >b){
			             ans = dice[a] + " " + dice[b];   
			         }else {
			             ans = dice[b] + " " + dice[a];
			         }
			        
			     }
			 }
			 
			 sb.append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
}
