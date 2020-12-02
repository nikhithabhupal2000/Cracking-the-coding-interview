import java.io.*;
import java.util.*;
public class prob_4_8{
	static Node lca = null;
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(3);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.right.left.left = new Node(7);
		root.right.right.right = new Node(8);
		lowestCommonAncestor(root, 7, 3);
		System.out.println(lca.data);
	}

	public static ArrayList<HashSet<Integer>> lowestCommonAncestor(Node root, int val1, int val2){
		ArrayList<HashSet<Integer>> children = new ArrayList<>();
		HashSet<Integer> leftChild = new HashSet<>();
		HashSet<Integer> rightChild = new HashSet<>();
		if(root != null){
			ArrayList<HashSet<Integer>> leftSide = lowestCommonAncestor(root.left, val1, val2);
			ArrayList<HashSet<Integer>> rightSide = lowestCommonAncestor(root.right, val1, val2);
			if(root.left != null){
				leftChild.add(root.left.data);
			}
			if(root.right != null){
				rightChild.add(root.right.data);
			}
			leftChild.addAll(leftSide.get(0));
			leftChild.addAll(leftSide.get(1));
			rightChild.addAll(rightSide.get(0));
			rightChild.addAll(rightSide.get(1));
		}
		children.add(leftChild);
		children.add(rightChild);
		if(leftChild.contains(val1) && !(leftChild.contains(val2))){
			lca = root;
		}
		else if(rightChild.contains(val1) && !(rightChild.contains(val2))){
			lca = root;
		}
		return children;
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
