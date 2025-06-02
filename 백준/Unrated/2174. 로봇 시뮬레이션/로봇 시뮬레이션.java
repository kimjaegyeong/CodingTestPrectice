import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Robot{
    int x,y,name;
    char d;
    public  Robot(int x, int y, char d, int name){
        this.x=x;
        this.y=y;
        this.d=d;
        this.name = name;
    }
}

public class Main {
    static int A,B;
    static int N,M;
    static Robot[] robots;

//    static int[] dx = {-1,0,1,0};
//    static int[] dy = {0,-1,0,1};
    static int[][] direction = { {0,1}, {1,0}, {0,-1}, {-1,0} } ; //NESW
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String input[] = br.readLine().split(" ");
        A = Integer.parseInt(input[0]);
        B = Integer.parseInt(input[1]);
        input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        robots = new Robot[N];
        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            robots[i] = new Robot(Integer.parseInt(input[0]) -1,Integer.parseInt(input[1]) -1,input[2].charAt(0), i+1);
        }

        boolean stop_flag = false;
        for(int i=0; i<M; i++){
            input = br.readLine().split(" ");
            int r_number =Integer.parseInt(input[0]) - 1;
            char command = input[1].charAt(0);
            int cycle = Integer.parseInt(input[2]);

            Robot robot = robots[r_number];
            char dir = robot.d;
            int idx =dir_to_idx(dir);

            if(command=='F'){
                for(int j=0; j<cycle; j++){
                    int nextX = robot.x + direction[idx][0];
                    int nextY = robot.y + direction[idx][1];
               //    System.out.println(" x: "+nextX +" y "+ nextY);
                    int crash_robot = crash(nextX, nextY, j);
                    if(nextY < 0 || nextX < 0 || nextY >= B || nextX >= A){
//                        System.out.println(nextY + " " + nextX);
                        System.out.println("Robot "+(r_number+1)+" crashes into the wall");
                        stop_flag = true;
                        break;
                    }
                    else if(crash_robot>0){
                        System.out.println("Robot "+(r_number+1)+" crashes into robot "+crash_robot);
                        stop_flag = true;
                        break;
                    }
                    robots[r_number].y = nextY;
                    robots[r_number].x = nextX;

                } //for문 끝
                if(stop_flag) break;

            }else if(command=='R'){
                for(int j=0; j<cycle; j++){
                    idx++;
                    if(idx>3){
                        idx=0;}
                }
                char new_dir=idx_to_dir(idx);
                robots[r_number].d = new_dir;

            }else {
                for(int j=0; j<cycle; j++){
                    idx--;
                    if(idx<0){
                        idx=3;
                    }
                }
                char new_dir=idx_to_dir(idx);
                robots[r_number].d = new_dir;
                //command == L
            }
        }
        if(stop_flag==false){
            System.out.println("OK");
        }

    }

    private static int crash(int nextX, int nextY, int robot) {
        for(int i=0; i<N; i++){
            if(i==robot){
                continue;
            }
            else if(robots[i].x==nextX && robots[i].y==nextY){
                return i+1;
            }
        }
        return -1;
    }

    // N , W, E, S
    private static int dir_to_idx(char dir) {
        switch(dir) {
            case 'N' : return 0;
            case 'E' : return 1;
            case 'S' : return 2;
            case 'W' : return 3;
        }
    return 0;
    }
    private static char idx_to_dir(int idx){
        switch(idx){
            case 0 : return 'N';
            case 1 : return 'E';
            case 2 : return 'S';
            case 3 : return 'W';
        }
        return '0';
    }

}