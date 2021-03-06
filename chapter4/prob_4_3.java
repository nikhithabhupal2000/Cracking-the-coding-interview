import java.io.*;
import java.util.*;
public class prob_4_3{
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(6);
		root.left.left.left = new Node(7);
		root.left.left.right = new Node(8);
		root.right.right.left = new Node(9);
		root.right.right.right = new Node(10);
		levelLinkedList(root);
	}

	public static void levelLinkedList(Node root){
		if(root == null){
			return;
		}
		ArrayList<LinkedList<Integer>> levels = new ArrayList<>();
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(q.size() > 0){
			LinkedList<Integer> level = new LinkedList<>();
			int count = q.size();
			while(count != 0){
				Node tmp = q.remove();
				level.add(tmp.data);
				if(tmp.left != null){
					q.add(tmp.left);
				}
				if(tmp.right != null){
					q.add(tmp.right);
				}
				count --;
			}
			levels.add(level);
		}
		System.out.println(levels);
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
