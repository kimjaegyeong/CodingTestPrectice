class Solution {
    static int min = Integer.MAX_VALUE;
    static int[][] info ;
    static int N;
    static int M;
    static boolean visited[][][];
    public int solution(int[][] in, int n, int m) {
        info = in;
        N = n;
        M = m;
        visited = new boolean[in.length+1][200][200];
        dfs(0, 0,0);
        if(min == Integer.MAX_VALUE) {
            min = -1;
        }
        return min;
    }
    
    public static void dfs(int depth ,int a, int b) {
                
        if(depth == info.length) {
            min = Math.min(a,min);
            return;
        }
        
        if(a + info[depth][0] < N ){
            if(!visited[depth+1][a+info[depth][0]][b]) {
                visited[depth+1][a+ info[depth][0]][b] = true;
                dfs(depth+1, a + info[depth][0], b);   
            }
        }
        if(b + info[depth][1] <M) {
            if(!visited[depth+1][a][b+info[depth][1]]){
                visited[depth+1][a][b+info[depth][1]] = true;
                dfs(depth+1,a, b+info[depth][1]);    
            }
        }
    }
}