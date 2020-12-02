import java.util.*;
import java.io.*;
public class prob_4_12{
	static int count = 0;
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(1);
		root.left.left = new Node(-1);
		root.left.right = new Node(0);
		root.right.right = new Node(1);
		int sum = 2;
		findWays(root, sum);
		System.out.println(count);
	}

	public static ArrayList<Integer> findWays(Node root, int sum){
		ArrayList<Integer> sol = new ArrayList<>();
		if(root == null){
			return sol;
		}
		ArrayList<Integer> leftWays = findWays(root.left, sum);
		ArrayList<Integer> rightWays = findWays(root.right, sum);
		sol.add(root.data);
		if(root.data == sum){
			count ++;
		}
		for(int i = 0; i < leftWays.size(); i ++){
			sol.add(root.data + leftWays.get(i));
			if(root.data + leftWays.get(i) == sum){
				count ++;
			}
		}
		for(int i = 0; i < rightWays.size(); i ++){
			sol.add(root.data + rightWays.get(i));
			if(root.data + rightWays.get(i) == sum){
				count ++;
			}
		}
		return sol;
	}
}

class Node{
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data = data;
	}
}
