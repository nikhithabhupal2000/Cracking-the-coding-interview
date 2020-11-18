import java.util.*;
import java.io.*;
public class Node{
	int val;
	Node next;
	public Node(int val){
		this.val = val;
	}

	public static Node getLL(int len, int range){
		if(len == 0){
			return null;
		}
		Random rand = new Random();
		Node head = new Node(rand.nextInt(range));
		len --;
		Node tmp = head;
		while(len != 0){
			tmp.next = new Node(rand.nextInt(range));
			tmp = tmp.next;
			len --;
		}
		return head;
	}

	public static void printLL(Node head){
		if(head == null){
			return;
		}
		Node tmp = head;
		while(tmp != null){
			System.out.print(tmp.val + "    ");
				tmp = tmp.next;
		}
	}
	public static Node getNthNode(Node head, int n){
		Node tmp = head;
		int counter = 1;
		while(counter != n){
			tmp = tmp.next;
			counter ++;
		}
		return tmp;
	}

	public static Node reverseLL(Node head){
		if((head == null) || (head.next == null)){
			return head ;
		}
		Node next = null;
		Node prev = null;
		Node current = head;
		while(current != null){
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		head = prev;
		return head;
	}


	public static Node copyLL(Node head){
		Node copy = new Node(0);
		Node tmp2 = copy;
		Node tmp = head;
		while(tmp != null){
			tmp2.next = new Node(tmp.val);
			tmp2 = tmp2.next;
			tmp = tmp.next;
		}
		return copy.next;
	}


	public static int length(Node list){
		if(list == null){
			return 0;
		}
		int count = 0;
		Node tmp = list;
		while(tmp != null){
			count ++;
			tmp = tmp.next;
		}
		return count;
	}

}
