import java.io.*;
import java.util.*;
public class prob_4_7_change{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of vertices");
		int vertices = ip.nextInt();
		System.out.println("Enter the number of edges");
		int edges = ip.nextInt();
		Graph g = new Graph(vertices, edges);
		ArrayList<Integer> order = new ArrayList<>();
		g.getOrdering(order);
		System.out.println(order);
	}

}

class Graph{
	int vertices;
	int edges;
	ArrayList<ArrayList<Integer>> adjList;
	Graph(int vertices, int edges){
		this.vertices = vertices;
		this.edges = edges;
		adjList = new ArrayList<>();
		for(int i = 0; i < vertices; i ++){
			ArrayList<Integer> tmp = new ArrayList<>();
			adjList.add(tmp);
		}
		readEdges();
	}

	public void getOrdering(ArrayList<Integer> order){
		int[] visited = new int[vertices];
		Arrays.fill(visited, -1);
		for(int i = 0; i < vertices; i ++){
			if(visited[i] == -1){
				explore(i, visited, order);
			}
		}
	}

	public void explore(int val, int[] visited, ArrayList<Integer> order){
		visited[val] = 1;
		for(int a : adjList.get(val)){
			if(visited[a] == -1){
				explore(a, visited, order);
			}
		}
		order.add(0, val);
	}

	public void readEdges(){
		Scanner ip = new Scanner(System.in);
		for(int i = 0; i < this.edges; i ++){
			System.out.println("Enter the edge");
			int u = ip.nextInt();
			int v = ip.nextInt();
			addEdge(u, v);
		}
	}

	public void addEdge(int u, int v){
		this.adjList.get(u).add(v);
	}

}
