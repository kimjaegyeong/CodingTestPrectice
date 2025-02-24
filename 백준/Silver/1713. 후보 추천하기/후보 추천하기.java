import java.util.*;
import java.io.*;
public class Main
{
	static int N;
	static int R;
	static int sn = 0;
	static int result = 0;
	static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
	static int inTime[];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		R = Integer.parseInt(br.readLine());
		inTime = new int[1001];
		StringTokenizer st = new StringTokenizer(br.readLine());

		for(int i=0; i<R; i++) {
			int students= Integer.parseInt(st.nextToken());
			execute(students, i);
		}

		List<Integer> keySet = new ArrayList<>(map.keySet());
		Collections.sort(keySet);
		for(int i : keySet){
		    System.out.print(i + " ");
		}

	}

	public static void execute(int id, int time) {


		if(map.containsKey(id)) {
			boolean result = map.replace(id,map.get(id), map.get(id) + 1);
			return;
		}
		if(!check(id)) {
			changeStudent(id);

		} else {
			sn++;
		}

		map.put(id,0);
		inTime[id] = time;



	}

	public static boolean check(int id) {
		if(sn < N ) {
			return true;
		}
		return false;
	}

	public static void changeStudent(int id) {
		int recoNum = 10000;
		int time = 10000;
		int idx = 0;
		for(Map.Entry<Integer,Integer> entry: map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();
			if(recoNum > value) {
				recoNum = value;
				time = inTime[key];
				idx = key;
			}
			else if(recoNum==value) {
				if(inTime[key] < time) {
					recoNum = value;
					time = inTime[key];
					idx = key;
				}
			}
		}
		inTime[idx] = 0;
		boolean check = map.remove(idx, recoNum);
	}

}
