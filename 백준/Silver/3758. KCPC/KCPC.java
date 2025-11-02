import java.util.*;
import java.io.*;

class Problem {
    Node[] list;
    
    public Problem(int n ){
        list= new Node[n];
        for(int i=0; i<n;i ++){
            list[i] = new Node(i,0,0,-1); // 초기 lastTime=-1
        }
    }   
}

class Node {
    int teamId;
    int score;
    int cnt;
    int lastTime;
    
    public Node(int teamId, int score, int cnt, int lastTime){
        this.teamId = teamId;
        this.score= score;
        this.cnt = cnt;
        this.lastTime = lastTime;
    }
}

class Team implements Comparable<Team>{
    int id;
    int totalScore;
    int totalCnt;
    int lastTime;
    
    public Team(int id){
        this.id = id;
        this.totalScore = 0;
        this.totalCnt = 0;
        this.lastTime = -1;
    }
    
    @Override
    public int compareTo(Team o){
        if(this.totalScore != o.totalScore) return o.totalScore - this.totalScore; 
        if(this.totalCnt != o.totalCnt) return this.totalCnt - o.totalCnt; 
        return this.lastTime - o.lastTime; 
    }
}

public class Main
{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        
        for(int t1=0; t1<T; t1++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken()) - 1; 
            int m = Integer.parseInt(st.nextToken());
            
            Problem[] problems = new Problem[k];
            for(int i=0;i<k;i++){
                problems[i] = new Problem(n);
            }
            
            for(int time=0; time<m; time++){
                st = new StringTokenizer(br.readLine());
                int teamId = Integer.parseInt(st.nextToken()) - 1;
                int problemId = Integer.parseInt(st.nextToken()) - 1;
                int score = Integer.parseInt(st.nextToken());
                
                Node nd = problems[problemId].list[teamId];
                nd.score = Math.max(nd.score, score); 
                nd.cnt++; 
                nd.lastTime = time; 
            }
            
            Team[] teams = new Team[n];
            for(int i=0;i<n;i++) teams[i] = new Team(i);
            
            for(int pid=0; pid<k; pid++){
                for(int tid=0; tid<n; tid++){
                    Node nd = problems[pid].list[tid];
                    teams[tid].totalScore += nd.score;
                    teams[tid].totalCnt += nd.cnt;
                    teams[tid].lastTime = Math.max(teams[tid].lastTime, nd.lastTime);
                }
            }
            
            // 순위 계산
            Arrays.sort(teams);
            
            for(int rank=0; rank<n; rank++){
                if(teams[rank].id == t){
                    System.out.println(rank+1);
                    break;
                }
            }
        }
    }
}
