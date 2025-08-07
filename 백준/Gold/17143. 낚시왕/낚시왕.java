import java.util.*;
import java.io.*;



public class Main
{
	static class Shark implements Comparable<Shark> {
		int y;
		int x;
		int s;
		int d;
		int z;

		// r, c, s, d, z
		public Shark(int y, int x, int s, int d, int z) {
			this.y=y;
			this.x=x;
			this.d=d;
			this.s=s;
			this.z=z;
		}

		public int compareTo(Shark s) {
			return s.z - this.z;
		}

		public String toString() {
//		    return "y = " + y + " x = " + x + " s = " + s + " d = " + d + " z = " + z;
			return ""+z;
		}


	}

	static class UnderGround {
		PriorityQueue<Shark> pq = new PriorityQueue<Shark>();

		public void addShark(Shark shark) {
			pq.offer(shark);
		}

		public boolean hasFish() {
			return !pq.isEmpty();
		}

		public void putFish(Shark shark) {
			if(hasFish()) {
				Shark s1 = pq.poll();
				if(s1.z >= shark.z) {
					pq.offer(s1);
				} else {
					pq.offer(shark);
				}
				return   ;
			}

			pq.offer(shark);
		}

		public void eatFish() {
			Shark bigShark = pq.poll();
			pq.clear();
			pq.offer(bigShark);

		}

		public Shark catchingFish() {
			Shark s = pq.poll();
			pq.clear();
			return s;
		}

		public ArrayList<Shark> moveSharks() {
			ArrayList<Shark> sList = new ArrayList<>();

			while (!pq.isEmpty()) {
				Shark shark = pq.poll();
				int y = shark.y;
				int x = shark.x;
				int dir = shark.d;
				int move = shark.s % ((dir < 2) ? 2 * (N - 1) : 2 * (M - 1));

				for (int i = 0; i < move; i++) {
					int ny = y + dy[dir];
					int nx = x + dx[dir];

					if (!check(ny, nx)) {
						dir = changeDir(dir);
						ny = y + dy[dir];
						nx = x + dx[dir];
					}

					y = ny;
					x = nx;
				}

				shark.y = y;
				shark.x = x;
				shark.d = dir;
				sList.add(shark);
			}

			return sList;
		}


		public int changeDir(int dir) {
			if(dir == 0 || dir == 1) {
				return dir == 0 ?  1 : 0;
			} else {
				return dir == 2 ? 3 : 2 ;
			}
		}

	}

	static int N;
	static int M;
	static int S;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,1,-1};
	static UnderGround[][] ug;
	static int ans = 0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		ug = new UnderGround[N][M];

		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ug[i][j] = new UnderGround();
			}
		}

		for(int i=0; i<S; i++) {
			st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken())-1;
			int x = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken())-1;
			int z = Integer.parseInt(st.nextToken());

			ug[y][x].addShark(new Shark(y,x,s,d,z));
		}

		for(int i=0; i<M; i++) {
			//move the fishing man
			for(int j=0; j<N; j++) {
				if(ug[j][i].hasFish()) {
					Shark s = ug[j][i].catchingFish();
					ans+=s.z;
					break;
				}
			}


			//move sharks
			UnderGround[][] newUg = new UnderGround[N][M];

			for(int k=0; k<N; k++) {
				for(int j=0; j<M; j++) {
					newUg[k][j] = new UnderGround();
				}
			}

			for(int k=0; k<N; k++) {
				for(int j=0; j<M; j++) {
					ArrayList<Shark> sharks = ug[k][j].moveSharks();

					for(Shark s : sharks) {
						newUg[s.y][s.x].putFish(s);
					}
				}
			}

			ug = newUg;

		}

		System.out.println(ans);

	}

	public static void printMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(!ug[i][j].hasFish()) {
					System.out.print(0+"|");
				}
				else {
					System.out.print(ug[i][j].pq.peek()+ "|");
				}
			}
			System.out.println();
		}

		System.out.println("===");
	}

	public static boolean check(int y, int x) {
		return y < N && x < M && y>=0 && x>=0 ;
	}
}
