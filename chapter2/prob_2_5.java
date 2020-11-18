import java.io.*;
import java.util.*;
public class prob_2_5{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of digits of num1");
		int len = ip.nextInt();
		Node num1 = Node.getLL(len, 10);
		System.out.println("Enter the number of digits in num2");
		len = ip.nextInt();
		Node num2 = Node.getLL(len, 10);
		System.out.println("\n Num1 is");
		Node.printLL(num1);
		System.out.println("\n num2 is");
		Node.printLL(num2);
		Node ans = add(num1, num2);
		System.out.println("\nAnswer is");
		Node.printLL(ans);
	}
	public static Node add(Node num1, Node num2){
		Node ans = new Node(0);
		Node tmp = ans;
		int carry = 0;
		while((num1 != null) || (num2 != null)){
			int sum = 0;
			if((num1 != null) && (num2 != null)){
				sum += num1.val + num2.val + carry;
				num1 = num1.next;
				num2 = num2.next;
			}
			else if(num1 != null){
				sum += num1.val + carry;
				num1 = num1.next;
			}
			else if(num2 != null){
				sum += num2.val + carry;
				num2 = num2.next;
			}
			tmp.next = new Node(sum % 10);
			tmp = tmp.next;
			carry = sum / 10;
		}
		if(carry != 0){
			tmp.next = new Node(carry);
		}
		return ans.next;
	}

	
}
