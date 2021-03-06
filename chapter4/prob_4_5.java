import java.io.*;
import java.util.*;
public class prob_4_5{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		Node root = new Node(87);
		root.left = new Node(2);
		root.right = new Node(99);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		root.right.right = new Node(200);
		System.out.println(isBST(root));
		System.out.println(isBSTRec(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}

	public static boolean isBST(Node root){
		if(root == null){
			return true;
		}
		ArrayList<Integer> inOrder = new ArrayList<>();
		inOrderTraversal(root, inOrder);
		for(int i = 0; i < inOrder.size() - 1; i ++){
			if(inOrder.get(i) >= inOrder.get(i + 1)){
				return false;
			}
		}
		return true;
	}

	public static void inOrderTraversal(Node root, ArrayList<Integer> inOrder){
		if(root != null){
			inOrderTraversal(root.left, inOrder);
			inOrder.add(root.data);
			inOrderTraversal(root.right, inOrder);
		}
	}


	public static boolean isBSTRec(Node root, int left, int right){
		if(root == null){
			return true;
		}
		if((root.data < left) || (root.data > right)){
			return false;
		}
		return isBSTRec(root.left, left, root.data - 1) && isBSTRec(root.right, root.data + 1, right);
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
