import java.io.*;
import java.util.*;
public class prob_2_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("\nEnter the desired length of linked list");
		int len = ip.nextInt();
		System.out.println("\nEnter the range of vals");
		int range = ip.nextInt();
		System.out.println("\nEnter the K value");
		int k = ip.nextInt();
		Node head = Node.getLL(len, range);
		System.out.println("\nThe linkedList is ");
		Node.printLL(head);
		kThValFromLastRec(head, k);
		System.out.println("\n" + k + "th val from last is" + kThValFromLast(head, k));
	}
	public static int kThValFromLast(Node head, int k){
		Node runner = head;
		Node current = head;
		while(k != 1){
			runner = runner.next;
			k--;
		}
		while(runner.next != null){
			runner = runner.next;
			current = current.next;
		}
		return current.val;
	}

	public static int kThValFromLastRec(Node head, int k){
		if(head == null){
			return 0;
		}
		int index = 1 + kThValFromLastRec(head.next, k);
		if(index == k){
			System.out.println("\n" + head.val);
		}
		return index;
	}
}
