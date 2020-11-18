import java.util.*;
import java.io.*;
public class prob_2_8{
	public static void main(String[] args){
		Node head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(3);
		head.next.next.next = new Node(4);
		head.next.next.next.next = head.next;
		System.out.println("The start of loop is");
		System.out.println(getLoopStart(head).val);
	}

	public static Node getLoopStart(Node list){
		if(list == null){
			return null;
		}
		Node slowPointer = list;
		Node fastPointer = list;
		while((slowPointer.next != null) && (fastPointer.next != null) && (fastPointer.next.next != null)){
			slowPointer = slowPointer.next;
			fastPointer = fastPointer.next.next;
			if(slowPointer == fastPointer){
				slowPointer = list;
				while(slowPointer != fastPointer){
					slowPointer = slowPointer.next;
					fastPointer = fastPointer.next;
				}
				return slowPointer;
			}
		}
		return null;
	}

}
