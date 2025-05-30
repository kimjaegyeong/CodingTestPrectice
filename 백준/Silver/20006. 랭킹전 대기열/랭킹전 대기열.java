import java.util.*;
import java.io.*;

class Player implements Comparable<Player> {
	int level;
	String name;

	public Player(int level, String name) {
		this.level = level;
		this.name = name;
	}

	public int compareTo(Player p ) {
		return this.name.compareTo(p.name);
	}

	public String toString() {
		return this.level +  " " + this.name;
	}
}

class Room {
	ArrayList<Player> players = new ArrayList<Player>();
	int max;
	int boundary;
	public boolean getStatus() {
		if(players.size() == max) return true;
		return false;
	}

	public Room(int max) {
		this.max = max;
	}

	public boolean enterPlayer(Player player) {
		if(players.size() == 0 ) {
			boundary = player.level;
		}
		else if(max == players.size()) return false;
		else if(player.level < boundary - 10 || player.level > boundary + 10 ) {
			return false;
		}

		players.add(player);
		return true;
	}

}

public class Main
{
	static int N;
	static int max;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		max= Integer.parseInt(st.nextToken());
		ArrayList<Room> rooms = new ArrayList<Room>();
		rooms.add(new Room(max));

		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			int level = Integer.parseInt(st.nextToken());
			String name = st.nextToken();

			Player player= new Player(level,name);
			boolean flag = false;
			for(Room room : rooms) {
				if(room.enterPlayer(player)) {
					flag = true;
					break;
				}
			}

			if(!flag) {
				Room room = new Room(max);
				room.enterPlayer(player);
				rooms.add(room);
			}
		}

		for(Room room : rooms) {
			if(room.getStatus()) {

				sb.append("Started!").append("\n");
				Collections.sort(room.players);
				for(Player player : room.players) {
                    sb.append(player).append("\n");
				}
			} else {
				sb.append("Waiting!").append("\n");
				Collections.sort(room.players);
				for(Player player : room.players) {
					sb.append(player).append("\n");
				}

			}

		}
		
		System.out.println(sb);

	}
}
