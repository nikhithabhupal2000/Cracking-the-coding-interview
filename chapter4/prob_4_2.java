import java.util.*;
import java.io.*;
public class prob_4_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for(int i =0; i < n; i ++){
			System.out.println("Enter the val");
			arr[i] = ip.nextInt();
		}
		makeBst(arr);
	}

	public static void makeBst(int[] arr){
		Node root = makeBST(arr, 0, arr.length - 1);
		inOrder(root);
	}
	public static Node makeBST(int[] arr, int low, int high){
		if(low > high){
			return null;
		}
		int mid = low + (high - low) / 2;
		Node root = new Node(arr[mid]);
		root.left = makeBST(arr, low, mid - 1);
		root.right = makeBST(arr, mid + 1, high);
		return root;
	}

	public static void inOrder(Node root){
		if(root != null){
			inOrder(root.left);
			System.out.println(root.data);
			inOrder(root.right);
		}
	}


}

class Node{
	int data;
	Node left;
	Node right;
	public Node(int data){
		this.data = data;
	}
}
