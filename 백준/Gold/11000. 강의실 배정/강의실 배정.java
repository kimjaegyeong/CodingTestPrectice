/***************************************************************************************
 강의실 배정할 때, 가장 시작 시간이 빠른 순으로 정렬을 해야 함. 
 왜냐면 시작 시간이 빠른 것부터 강의가 시작될 수 있으니까. 이미 시작된 강의실은 
 끝날 때 까지 하나의 강의실을 점유하고 있을 것이고, 그 다음 가장 빠르게 시작되는 강의가 
 이전의 강의의 끝나는 시간보다 빠르다면 새로운 강의실이 필요함. 
 
 이 문제가 그리디인 이유는 한 번 처리한 강의실에 대해서는 다시 볼 필요가 없기 때문.
 시작 시간대로 정렬했기 때문에 이전의 강의가 끝날 때 까지 강의실 개수는 줄어들 수 없음.
 그렇기 때문에 하나씩 뽑아가면서 이전 강의가 끝나는 시간 =< 현재 강의가 시작되는 시간인 
 경우만 체크해서 처리하면 됨. 이전 강의가 끝나기 전까지 뽑히는 강의들은 무조건 큐에 
 추가될 수 밖에 없다(강의실이 추가로 필요하다)
***************************************************************************************/
import java.io.*;
import java.lang.Exception.*;
import java.util.*;

 
public class Main
{
    static class Node implements Comparable<Node>{
    int a;
    int b;
    public Node(int a, int b){
        this.a= a;
        this.b= b;
    }
    
    public int compareTo(Node n){
        return this.a - n.a == 0 ?  this.b - n.b : this.a- n.a;
    }
    
}
    
    static int N;
    static int a,b;
	public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        ArrayList<Node> list = new ArrayList<Node>();
        N = Integer.parseInt(br.readLine());  
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Node(a,b));
        }
        Collections.sort(list);
        
        pq.offer(list.get(0).b);
        //pq에는 종료시각만 넣는다. 그러면 가장 빨리 종료되는 강의실이 항상 앞에 있을테니까
        for(int i=1; i<list.size(); i++){
            int e =pq.peek();
            if(list.get(i).a >= e){
                pq.poll();
                pq.offer(list.get(i).b);
            }else{
                pq.offer(list.get(i).b);
            }
        }
        
        System.out.println(pq.size());
        
        
	}
}
