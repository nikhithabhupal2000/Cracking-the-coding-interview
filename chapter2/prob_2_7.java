import java.io.*;
import java.util.*;
public class prob_2_7{
	public static void main(String[] args){
		Node list1 = Node.getLL(10, 50);
		Node list2 = Node.getLL(5, 50);
		list2.next.next.next.next.next = list1.next.next;
		System.out.println("\n First list is");
		Node.printLL(list1);
		System.out.println("\n second list is");
		Node.printLL(list2);
		System.out.println("\n The insersection val is " + intersectionNode(list1, list2));
	}

	public static int intersectionNode(Node list1, Node list2){
		if((list1 == null) || (list2 == null)){
			return 0;
		}
		int len1 = Node.length(list1);
		int len2 = Node.length(list2);
		while(len1 > len2){
			list1 = list1.next;
			len1 --;
		}
		while(len2 > len1){
			list2 = list2.next;
			len2 --;
		}
		while(list1 != null){
			if(list1 == list2){
				return list1.val;
			}
			list1 = list1.next;
			list2 = list2.next;
		}
		return -1;
	}

}
