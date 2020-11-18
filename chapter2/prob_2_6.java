import java.util.*;
import java.io.*;
public class prob_2_6{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the ll");
		int len = ip.nextInt();
		Node head = Node.getLL(len, 2);
		System.out.println("\n The ll is");
		Node.printLL(head);
		System.out.println("ll is a pallindrome" + isPall(head));
	}

	public static boolean isPall(Node head){
		if((head == null) || (head.next == null)){
			return true;
		}
		Node proper = Node.copyLL(head);
		head = Node.reverseLL(head);
		while(head.next != null){
			if(head.val != proper.val){
				return false;
			}
			head = head.next;
			proper = proper.next;
		}
		return true;
	}
}
