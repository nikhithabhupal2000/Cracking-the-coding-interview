import java.util.*;
import java.io.*;
public class prob_3_5{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		Stack<Integer> vals = new Stack<>();
		System.out.println("Enter the num of ele in stack");
		int n = ip.nextInt();
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the vlue");
			vals.push(ip.nextInt());
		}
		System.out.println("Before sorting" + vals);
		vals = sortStack(vals);
		System.out.println("After sorting" + vals);
	}

	public static Stack<Integer> sortStack(Stack<Integer> vals){
		Stack<Integer> sorted = new Stack<>();
		while(vals.size() > 0){
			int val = vals.pop();
			while((sorted.size() != 0) && (sorted.peek() > val)){
				vals.push(sorted.pop());
			}
			sorted.push(val);
		}
		return sorted;
	}
}
