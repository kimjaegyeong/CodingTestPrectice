import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Node {
    int x, y;
    int dist;

    public Node(int y, int x, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
}

public class Main {

    public static void check(Node node , int y, int x) {
        while (true) {
            int ny = node.y;
            int nx = node.x;
            visited[ny][nx] = 1;
            if (ny == y && nx == x) {

                break;
            }

            Node nNode = map[ny][nx];

            node.y = nNode.y;
            node.x = nNode.x;
        }
    }
    public static Node bfs(Node node, Node dNode) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(node);

        int min = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            Node nn = queue.poll();

            for (int i = 0; i < 4; i++) {
                int ny = nn.y + dy[i];
                int nx = nn.x + dx[i];

                if (nn.x == dNode.x && nn.y == dNode.y) {
                    // dist 비교
                    return nn;
                }

                if (ny >= N || ny < 0 || nx >= M || nx < 0) {
                    continue;
                }
                if (visited[ny][nx] == 1) {
                    continue;
                }
                int nDist = nn.dist + 1;
                visited[ny][nx] = 1;
                map[ny][nx] = nn;
                queue.add(new Node(ny, nx, nDist));
            }
        }
        return null;
    }

    static int N, M;
    static Node a1, a2, b1, b2;
    static Node map[][];
    static int visited[][];
    static int aMin;
    static int bMin;
    static int totalMin;
    static int[] dy = { 1, 0, 0, -1 };
    static int[] dx = { 0, 1, -1, 0 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        M = Integer.parseInt(input[0]) + 1;
        N = Integer.parseInt(input[1]) + 1;
        map = new Node[N][M];
        aMin = Integer.MAX_VALUE;
        bMin = Integer.MAX_VALUE;
        totalMin = Integer.MAX_VALUE;
        boolean possible = false;
        input = br.readLine().split(" ");
        int x = Integer.parseInt(input[0]);
        int y = Integer.parseInt(input[1]);
        a1 = new Node(y, x, 0);

        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        a2 = new Node(y, x, 0);

        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        b1 = new Node(y, x, 0);

        input = br.readLine().split(" ");
        x = Integer.parseInt(input[0]);
        y = Integer.parseInt(input[1]);
        b2 = new Node(y, x, 0);
        // input process end

        // B 확정 후 A 최단거리

        visited = new int[N][M];
        visited[b1.y][b1.x] = 1;

        visited[a1.y][a1.x] = 1;
        visited[a2.y][a2.x] = 1;



        Node bn= bfs(b1, b2);
        visited = new int[N][M];

        check(bn, b1.y ,b1.x);
//        print_visited();
        visited[a1.y][a1.x] = 1;



        Node an = bfs(a1, a2);

        if(an==null || bn==null) {

        }else {
            possible=true;
            int aMin = an.dist;
            int bMin = bn.dist;
            totalMin = Math.min(totalMin, aMin+bMin);

        }

        // A 확정 후 B 최단거리

        visited = new int[N][M];
        map = new Node[N][M];
        visited[a1.y][a1.x] = 1;
        visited[b1.y][b1.x] = 1;
        visited[b2.y][b2.x] = 1;

        Node aNode = bfs(a1, a2);

        visited = new int[N][M];
        check(aNode, a1.y, a1.x);

        visited[b1.y][b1.x] = 1;
        Node bNode = bfs(b1, b2);

        if(bNode==null || aNode==null) {
        }else {
            possible= true;
            int aMin = aNode.dist;
            int bMin = bNode.dist;
            totalMin = Math.min(totalMin, aMin+bMin);

        }

        if(!possible){
            System.out.println("IMPOSSIBLE");
        }else {
            System.out.println(totalMin);
        }
    }

    private static void print_visited() {
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                System.out.print(visited[i][j]+" ");
            }
            System.out.println();
        }
    }
}
