import java.util.*;
import java.io.*;


class Person implements Comparable<Person>{
    
    int age;
    String name;
    int idx;
    
    public Person(int age, String name, int idx){
        this.age= age;
        this.idx= idx;
        this.name=name;
    }
    
    public int compareTo(Person p) {
        return this.age - p.age == 0? this.idx - p.idx : this.age - p.age;
    }
}

public class Main
{
    static int N;
    static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		Person persons[] = new Person[N];
		for(int i=0; i<N; i++){
		    StringTokenizer st = new StringTokenizer(br.readLine());
		    int age = Integer.parseInt(st.nextToken());
		    String name = st.nextToken();
		    persons[i] =   new Person(age,name,i);  
		}
		
		Arrays.sort(persons);
		
		for(int i=0; i<N; i++){
		    sb.append(persons[i].age).append(" ").append(persons[i].name).append("\n");
		}
		
		System.out.println(sb);
	}
}
