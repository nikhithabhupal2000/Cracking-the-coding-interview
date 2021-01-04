import java.io.*;
import java.util.*;
public class prob_10_10{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		RankNode root = new RankNode(5);
		RankNode.insert(root, 1);
		RankNode.insert(root, 4);
		RankNode.insert(root, 4);
		RankNode.insert(root, 5);
		RankNode.insert(root, 9);
		RankNode.insert(root, 7);
		RankNode.insert(root, 13);
		RankNode.insert(root, 3);
		RankNode.inOrder(root);
		System.out.println();
		System.out.println(RankNode.getRank(root, 1));
		System.out.println(RankNode.getRank(root, 3));
		System.out.println(RankNode.getRank(root, 4));
	}
}


class RankNode{
	RankNode left,right;
	int leftSize;
	int val;
	RankNode(int val){
		this.val = val;
		this.leftSize = 0;
		this.left = null;
		this.right = null;
	}

	public static RankNode insert(RankNode root, int val){
		if(root == null){
			root = new RankNode(val);
			return root;
		}
		if(root.val >= val){
			root.left = insert(root.left, val);
			root.leftSize ++;
		}
		else{
			root.right = insert(root.right, val);
		}
		return root;
	}


	public static void inOrder(RankNode root){
		if(root != null){
			inOrder(root.left);
			System.out.print("    " + root.val + "{" + root.leftSize + "}");
			inOrder(root.right);
		}
	}

	public static int getRank(RankNode root, int val){
		if(root.val == val){
			return root.leftSize;
		}
		if(root.val > val){
			return getRank(root.left, val);
		}
		else{
			return 1 + root.leftSize + getRank(root.right, val);
		}
	}
}
