import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
class Node{
    int x;
    int y;
    int cost;

    public Node(int y,int x, int cost){
        this.x=x;
        this.y=y;
        this.cost= cost;
    }
}
public class Main {
    static int N;
    static int[][] map;
    final int M = 101;
    static int[] dx={0,0,1,-1};
    static int[] dy= {1,-1,0,0};
    static int min_cost=9999;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader( new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        //input start
        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }
        //input end

        //search_island start
        int island_count=2;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==1){
                    search_island(i,j, island_count);
                    island_count++;
                }
            }
        }
        //search_island end
//        print_map();

        //create_bridge start
        for(int i=2; i<island_count; i++){
            create_bridge(i, getCopy_map());
        }
        //create_bridge end

        //result
        System.out.println(min_cost);
    }

    private static void print_map() {
        Arrays.stream(map).forEach(i -> {
            Arrays.stream(i).forEach(j-> System.out.print(j+ " "));
            System.out.println();
        });
    }

    private static int[][] getCopy_map() {
        int[][] copy_map = new int[N][N];
        for(int i=0; i<N; i++){
           for(int j=0; j<N; j++){
               copy_map[i][j] = map[i][j];
           }
        }
        return copy_map;
    }

    public static void create_bridge(int island_number, int[][] map){
        Queue<Node> queue = new ArrayDeque<>();
        int cost=0;
        int ny,nx;

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(map[i][j]==island_number){
                    queue.add(new Node(i,j,cost));
                }
            }
        }

        while(!queue.isEmpty()){
            Node node =queue.poll();

            for(int i=0; i<4; i++){
                ny= node.y + dy[i];
                nx= node.x + dx[i];

                if(ny >= N || nx >= N || ny<0 || nx<0 || map[ny][nx]==island_number || map[ny][nx]==-1){
                    continue;
                }

                if(map[ny][nx]!=island_number && map[ny][nx]!=0){
                    min_cost=Math.min(node.cost ,min_cost);
                    break;
                }

                map[ny][nx] = -1;
                queue.add(new Node(ny,nx,node.cost+ 1));

            }
        }
    }
    public static void search_island(int y, int x ,int island_count ){
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{y,x});
        map[y][x] = island_count;
        while(!queue.isEmpty()){
            int[] yx=queue.poll();
            for(int i=0; i<4; i++){
                int ny= yx[0] + dy[i];
                int nx= yx[1] + dx[i];

                if(ny >= N || nx >= N || ny<0 || nx<0){
                    continue;
                }

                if(map[ny][nx]==1){
                    map[ny][nx]= island_count;
                    queue.add(new int[]{ny,nx});
                }
            }
        }
    }
}