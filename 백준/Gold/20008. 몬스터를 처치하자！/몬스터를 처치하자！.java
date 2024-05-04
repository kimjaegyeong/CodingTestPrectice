import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int hp;
    static Skill[] skills;
    static int[] wait;
    static int result = Integer.MAX_VALUE;

    static class Skill implements Comparable<Skill>{
        int time;
        int damage;
        int index;

        public Skill(int time, int damage, int index) {
            this.time = time;
            this.damage = damage;
            this.index =index;
        }

        public int compareTo(Skill s) {
            return this.time- s.time == 0 ? s.damage - this.damage : this.time- s.time;
        }

        @Override
        public String toString() {
            return "Skill [time=" + time + ", damage=" + damage + "]";
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        hp = Integer.parseInt(st.nextToken());
        skills = new Skill[N];
        wait = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int damage = Integer.parseInt(st.nextToken());
            skills[i] = new Skill(time, damage, i);
        }

        dfs(0, hp, wait);
        System.out.println(result);
    }

    static void dfs(int cnt , int mhp, int[] wait){
        if(mhp<=0){// 몬스터의 피가 0 이하이면 최소시간 갱신 후 재귀 종료
            result = Math.min(result,cnt);
            return ;
        }

        int able = 0;
        int tempWait[] = new int[N];
        tempWait = Arrays.copyOf(wait, N);
//        System.out.println(Arrays.toString(tempWait) + " " + cnt +" " +mhp);
        // 대기시간 0인 스킬 찾기
        for(int i=0; i<N; i++){
            if(able==1){ //만약 스킬을 써서 스킬의 대기시간이 변경된 경우라면
                    tempWait = Arrays.copyOf(wait,N);

            }
            if(tempWait[i]<=0){
                //스킬 사용
                able = 1;
                // 모든 스킬에 대해서 시간 -- , 사용한 스킬은 대기시간 다시 충전
                for(int j=0; j<N; j++){
                    tempWait[j]--;
                }
                tempWait[i] = skills[i].time-1;
                //dfs
                dfs(cnt+1, mhp- skills[i].damage,tempWait);
            }
        }

        //대기시간 0인 거 없으면 ...
        // dfs(cnt+n ... )
        if(able==0){
            //모든 스킬의 대기시간을 최소 대기시간만큼 줄이고 dfs
            int min= Integer.MAX_VALUE;
            int index =0;
            for(int i=0; i<N; i++){
                if(min>=wait[i]){
                    min = wait[i];
                    index = i;
                }
            }

            for(int j=0; j<N; j++){
                wait[j]= wait[j] - min;
            }


            dfs(cnt+min, mhp, wait);

        }



    }
}

