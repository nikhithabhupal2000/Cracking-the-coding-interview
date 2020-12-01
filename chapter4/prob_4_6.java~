import java.io.*;
import java.util.*;
public class prob_4_6{
	public static void main(String[] args){
		Node root = new Node(87, null);
		root.left = new Node(2, root);
		root.right = new Node(99, root);
		root.left.left = new Node(1, root.left);
		root.left.right = new Node(50, root.left);
		root.right.right = new Node(200, root.right);
		root.left.right.left = new Node(48, root.left.right);
		root.left.right.right = new Node(49, root.left.right);
		root.left.right.left.left = new Node(3, root.left.right.right);
		int val = 87;
		System.out.println(successor(root, val));
	}


	public static int successor(Node root, int val){
		Node tmp = root;
		while(tmp != null){
			if(tmp.data == val){
				return successor(tmp);
			}
			else if(tmp.data >= val){
				return successor(root.left, val);
			}
			else{
				return successor(root.right, val);
			}
		}
		return -1;
	}
	public static int  successor(Node root){
		if(root.right != null){
			Node tmp = root.right;
			while(tmp.left != null){
				tmp = tmp.left;
			}
			return tmp.data;
		}
		else{
			if(root.parent != null){
				return root.parent.data;
			}
			else{
				return -1;
			}
		}
	}
}
class Node{
	int data;
	Node parent;
	Node left;
	Node right;
	Node(int data, Node parent){
		this.data = data;
		this.parent = parent;
	}
}
