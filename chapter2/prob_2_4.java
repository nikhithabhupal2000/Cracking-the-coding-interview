import java.util.*;
import java.io.*;
public class prob_2_4{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("\nEnter the desired length of ll");
		int len = ip.nextInt();
		System.out.println("\n Enter the range of vals");
		int range = ip.nextInt();
		Node head = Node.getLL(len, range);
		System.out.println("\nThe linked list is ");
		Node.printLL(head);
		System.out.println("\n Enter the partiion");
		int partition = ip.nextInt();
		splitAroundPartition(head, partition);
		System.out.println("\n Modified ll is");
		Node.printLL(head);
	}


	public static void splitAroundPartition(Node head, int partition){
		Node current = head;
		Node runner = head;
		runner = posRunner(head, partition);
		while(runner != null){
			//System.out.println("\n " + runner.val + "    " + current.val);
			if(current == runner){
				runner = runner.next;
				runner = posRunner(runner, partition);
			}
			else if(current.val >= partition){
				int tmp = current.val;
				current.val = runner.val;
				runner.val = tmp;
				runner = posRunner(runner, partition);
			}
			current = current.next;
		}
	}

	public static Node posRunner(Node runner, int val){
		Node runner2 = runner;
		while((runner2 != null) && (runner2.val >= val)){
			runner2 = runner2.next;
		}
		return runner2;
	}
	
}
