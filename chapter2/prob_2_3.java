import java.util.*;
import java.io.*;
public class prob_2_3{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the length of linked list");
		int len = ip.nextInt();
		System.out.println("Enter the range of vals");
		int range = ip.nextInt();
		Node head = Node.getLL(len, range);
		System.out.println("\nThe linkedlist is");
		Node.printLL(head);
		System.out.println("\n Enter node you want to delete");
		int n = ip.nextInt();
		delNode(Node.getNthNode(head, n));
		System.out.println("\n The modified linked list is");
		Node.printLL(head);
	}

	public static void delNode(Node middleNode){
		if(middleNode.next == null){
			System.out.println("Last Node is not accepted");
		}
		middleNode.val = middleNode.next.val;
		middleNode.next = middleNode.next.next;

	}
}
