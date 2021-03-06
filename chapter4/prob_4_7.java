import java.io.*;
import java.util.*;
public class prob_4_7{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of projects and dependencies");
		int vertices = ip.nextInt();
		int edges = ip.nextInt();
		ip.nextLine();
		char[] projects = new char[vertices];
		for(int i = 0; i < vertices; i ++){
			System.out.println("Enter the project name");
			projects[i] = ip.nextLine().charAt(0);
		}
		Graph g = new Graph(vertices, edges, projects);
		ArrayList<Character> order = new ArrayList<>();
		g.getOrdering(order);
		System.out.println(order);
	}
}
class Graph{
	int vertices;
	int edges;
	HashMap<Character, ArrayList<Character>> adjList;
	Graph(int vertices, int edges, char[] projects){
		this.vertices = vertices;
		this.edges = edges;
		adjList = new HashMap<>();
		for(int i = 0; i < vertices; i ++){
			ArrayList<Character> tmp = new ArrayList<>();
			adjList.put(projects[i], tmp);
		}
		readDependencies();
	}

	public void getOrdering(ArrayList<Character> order){
		HashSet<Character> visited = new HashSet<>();
		for(Map.Entry<Character, ArrayList<Character>> e : adjList.entrySet()){
			if(!visited.contains(e.getKey())){
				explore(e.getKey(), order, visited);
			}
		}
	}

	public void explore(char val, ArrayList<Character> order, HashSet<Character> visited){
		visited.add(val);
		for(Character c : adjList.get(val)){
			if(!visited.contains(c)){
				explore(c, order, visited);
			}
		}
		order.add(0, val);
	}

	public void readDependencies(){
		Scanner ip = new Scanner(System.in);
		for(int i = 0; i < this.edges; i ++){
			System.out.println("Enter the edge");
			char u = ip.nextLine().charAt(0);
			char v = ip.nextLine().charAt(0);
			addEdge(u, v);
		}
	}

	public void addEdge(char u, char v){
		ArrayList<Character> tmp = adjList.get(u);
		tmp.add(v);
		adjList.put(u, tmp);
	}
}

