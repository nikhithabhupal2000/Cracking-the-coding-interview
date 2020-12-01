import java.io.*;
import java.util.*;
public class prob_4_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int vertices = ip.nextInt();
		System.out.println("Enter the number of edges");
		int edges = ip.nextInt();
		Graph g = new Graph(vertices, edges);
		System.out.println("Enter the source and destination");
		int source = ip.nextInt();
		int destination = ip.nextInt();
		System.out.println(g.isReachable(source, destination));
	}
}

class Graph{
	int vertices;
	int edges;
	ArrayList<ArrayList<Integer>> adjList;
	public Graph(int vertices, int edges){
		this.vertices = vertices;
		this.edges = edges;
		adjList = new ArrayList<>();
		for(int i = 0; i < vertices; i ++){
			ArrayList<Integer> tmp = new ArrayList<>();
			adjList.add(tmp);
		}
		readEdges();
	}

	private void readEdges(){
		Scanner ip = new Scanner(System.in);
		for(int i = 0; i < this.edges; i ++){
			System.out.println("Enter the edge");
			int u = ip.nextInt();
			int v = ip.nextInt();
			this.addEdge(u, v);
		}
	}

	private void addEdge(int a, int b){
		adjList.get(a).add(b);
	}

	public boolean isReachable(int source, int destination){
		int[] visited = new int[this.vertices];
		explore(visited, source);
		return visited[destination] == 1;
	}

	public void explore(int[] visited, int source){
		visited[source] = 1;
		for(int a : this.adjList.get(source)){
			if(visited[a] == 0){
				explore(visited, a);
			}
		}
	}
}

