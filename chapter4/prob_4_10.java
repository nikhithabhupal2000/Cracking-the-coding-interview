import java.util.*;
import java.io.*;
public class prob_4_10{
	public static void main(String[] args){
		Node root1 = new Node(1);
		root1.left = new Node(4);
		root1.right = new Node(3);
		root1.left.left = new Node(6);
		root1.right.left = new Node(4);
		root1.right.right = new Node(5);
		root1.right.left.left = new Node(7);
		root1.right.left.right = new Node(8);
		Node root2 = new Node(4);
		root2.left = new Node(7);
		root2.right = new Node(8);
		System.out.println(isSubTree(root1, root2));
	}

	public static boolean isSubTree(Node root1, Node root2){
		if((root1 == null) && (root2 == null)){
			return true;
		}
		if(root1 == null){
			return false;
		}
		if(root2 == null){
			return false;
		}
		if(root1.data == root2.data){
			boolean ans = false;
			ans = ans  || isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
			if(ans == true){
				return ans;
			}
			ans = ans || isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
			return ans;
		}
		return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
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
