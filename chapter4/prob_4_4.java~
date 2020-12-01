import java.io.*;
import java.util.*;
public class prob_4_4{
	static boolean ans = true;
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
	//	root.left.left.left = new Node(5);
	//	root.left.left.left.left = new Node(6);
		System.out.println(isBalanced(root));
		System.out.println(ans);
	}

	public static int  isBalanced(Node root){
		if(root == null){
			return 0;
		}
		int h1 = isBalanced(root.left);
		int h2 = isBalanced(root.right);
		if(Math.abs(h1 - h2) <= 1){
			ans = ans && true;
		}
		else{
			ans = ans && false;
		}
		return 1 + Math.max(h1, h2);
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
