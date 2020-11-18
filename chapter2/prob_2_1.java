import java.io.*;
import java.util.*;
public class prob_2_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the desired length of linkedlist");
		int len = ip.nextInt();
		System.out.println("Enter the range of vals in linkedlist");
		int range = ip.nextInt();
		Node head = Node.getLL(len, range);
		Node head2 = Node.getLL(len, range);
		System.out.println("\nActual linked list is");
		Node.printLL(head);
		removeDupsWithSpace(head);
		System.out.println("\nLinked list after duplicates are removed");
		Node.printLL(head);
		System.out.println("\n Actual LinkedList is");
		Node.printLL(head2);
		removeDupsConstantSpace(head2);
		System.out.println("\n Linked list after removing duplicates");
		Node.printLL(head2);
	}

	public static void removeDupsWithSpace(Node head){
		if((head == null) || (head.next == null)){
			return;
		}
		HashSet<Integer> seen = new HashSet<>();
		Node tmp = head;
		Node prev = null;
		while(tmp != null){
			if(seen.contains(tmp.val)){
				prev.next = tmp.next;
			}
			else{
				seen.add(tmp.val);
				prev = tmp;
			}
			tmp = tmp.next;
		}
	}

	public static void removeDupsConstantSpace(Node head){
		if((head == null) || (head.next == null)){
			return;
		}
		Node current = head;
		Node runner = head;
		while(current != null){
			runner = current;
			while(runner.next != null){
				if(runner.next.val == current.val){
					runner.next = runner.next.next;
				}
				else{
					runner = runner.next;
				}
			}
			current = current.next;
		}
	}
}
