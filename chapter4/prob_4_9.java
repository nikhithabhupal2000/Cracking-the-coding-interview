import java.util.*;
import java.io.*;
public class prob_4_9{
	public static void main(String[] args){
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(6);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(8);
		System.out.println(printWays(root));
	}

	public static int ways(Node root){
		if(root == null){
			return 0;
		}
		if((root.left == null) || (root.right == null)){
			return 1;
		}
		return 2 * (ways(root.left) * ways(root.right));
	}

	public static ArrayList<ArrayList<Integer>> printWays(Node root){
		ArrayList<ArrayList<Integer>> ways = new ArrayList<>();
		if(root == null){
			return ways;
		}
		ArrayList<ArrayList<Integer>> leftWays = printWays(root.left);
		ArrayList<ArrayList<Integer>> rightWays = printWays(root.right);
		if((leftWays.size() == 0) && (rightWays.size() == 0)){
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(root.data);
			ways.add(tmp);
			return ways;
		}
		if(leftWays.size() == 0){
			for(int i = 0; i < rightWays.size(); i ++){
				rightWays.get(i).add(0, root.data);
			}
			return rightWays;
		}
		else if(rightWays.size() == 0){
			for(int i = 0; i < leftWays.size(); i ++){
				leftWays.get(i).add(0, root.data);
			}
			return leftWays;
		}
		for(int i = 0; i  < leftWays.size(); i ++){
			for(int j = 0; j < rightWays.size(); j ++){
				ArrayList<Integer> tmp = new ArrayList<>();
				tmp.add(root.data);
				tmp.addAll(leftWays.get(i));
				tmp.addAll(rightWays.get(j));
				ways.add(tmp);
				ArrayList<Integer> tmp2 = new ArrayList<>();
				tmp2.add(root.data);
				tmp2.addAll(rightWays.get(j));
				tmp2.addAll(leftWays.get(i));
				ways.add(tmp2);
			}
		}
		return ways;
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
