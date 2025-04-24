import java.util.*;

class Solution {
    public int solution(int[] players, int m, int k) {
        
        int time = 0;
        int total = 0;
        int nowCnt = 1;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        while(time < players.length){
            if(players[time] >= (nowCnt) * m) {
                // 사람 수 / m == 필요한 서버 개수 
                // 증설 서버 개수 = 필요 서버 개수 - 현재 가지고 있는 서버(nowCnt)
                // 사람 수 < 증설 서버 개수 * m 이 아니라면 1개 더 증설해야 함 
                //증설 서버 개수 queue에 넣기 
                
                int addCnt = (players[time] / m) - nowCnt ;
                if(players[time] >= (addCnt + nowCnt) * m) {
                    addCnt ++;
                }
                total+=addCnt;
                nowCnt = addCnt + nowCnt;
                
                queue.offer(new int[]{time+k,addCnt});
            }
            
            while(!queue.isEmpty()){
                int[] node = queue.peek();
                if(node[0] == time+1) {
                    nowCnt -= node[1];
                    queue.poll();
                }else{
                    break;
                }
            }
            
            time++;
        }
    
        return total;
    }
}