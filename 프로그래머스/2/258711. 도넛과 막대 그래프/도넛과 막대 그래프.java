import java.util.*;

class Solution {
    int[] inEdge;
    int[] outEdge;
    int wrongNode =0;
    int MAX = 1000002;
    int stick = 0;
    int donut =0 ;
    int eight =0;
    int[] visited;
    boolean[] hasNode ;
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    public int[] solution(int[][] edges) {
        int[] answer = new int[4];
        inEdge = new int[MAX];
        outEdge = new int[MAX];
        visited = new int[MAX];
        hasNode = new boolean[MAX];
        
        int nodeCntMax = 0;
        for(int i=0; i<edges.length; i++){
            nodeCntMax = Math.max(nodeCntMax , edges[i][0]);
            nodeCntMax = Math.max(nodeCntMax , edges[i][1]);
        }
        for(int i=0; i<nodeCntMax+1; i++){
            list.add(new ArrayList<Integer>());
        }
        
        
        for(int i=0; i<edges.length; i++){
            list.get(edges[i][0]).add(edges[i][1]);
            outEdge[edges[i][0]]++;
            inEdge[edges[i][1]]++;
            hasNode[edges[i][0]] = true;
            hasNode[edges[i][1]] = true;            
        }
        
        for(int i=0; i<MAX; i++){
            if(inEdge[i] ==0 && outEdge[i] >=2){
                wrongNode = i;
                break;
            }
            
        }
        
        int parentCnt =0;
        for(int i=0; i<list.get(wrongNode).size(); i++){
            inEdge[list.get(wrongNode).get(i) ]--;
            parentCnt++;
        }
        
         list.get(wrongNode).clear(); 
        
        for(int i=1; i<list.size(); i++){
            if(i ==wrongNode) continue;
            if(!hasNode[i]) continue;
            if(inEdge[i]==1 && outEdge[i]==0 || (inEdge[i]==0 && outEdge[i]==0) ){
                stick++;
            }else if(inEdge[i]==2 && outEdge[i]==2){
                eight++;
            }
        }
        
        donut = parentCnt - stick - eight;
        
        
//         for(int i=1; i<list.size(); i++){
//             if(visited[i]>0 || i == wrongNode || (inEdge[i] >0 && outEdge[i] ==0)){ //막대의 끝부분인 경우는 continue
//                 continue; 
//             }
//                 bfs(i);         

//         }
        
        answer[0] = wrongNode;
        answer[1] = donut;
        answer[2] = stick;
        answer[3] = eight;
        
        
    return answer;
    }
    
    public void bfs(int n){
        Queue<Integer> queue = new ArrayDeque<Integer>();
        queue.offer(n);
        boolean isEight  = false;
        int node = -1;
        while(!queue.isEmpty()){
             node = queue.poll();
            
            for(int i=0; i<list.get(node).size(); i++){
                if(visited[list.get(node).get(i)] >0){
                    continue; 
                }
                
                if(inEdge[list.get(node).get(i)]==2 && outEdge[list.get(node).get(i)]==2){
                    isEight = true;
                }
                visited[list.get(node).get(i)] = node;
                queue.offer(list.get(node).get(i));
            }
        }

        
        if(isEight){
            eight++;
        }else if(visited[n] == node){
            donut++;
        }else{
            stick++;
        }
        
    }
}