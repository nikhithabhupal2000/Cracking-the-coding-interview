import java.util.*;
import java.io.*;
public class prob_3_4{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the operations and enter 'exit' to stop{e <val>, d}");
		ArrayList<String> operations = new ArrayList<>();
		while(true){
			String instruction = ip.nextLine();
			if(instruction.equals("exit")){
				break;
			}
			operations.add(instruction);
		}
		MyQueue myQueue = new MyQueue();
		myQueue.perform(operations);
	}
}

class MyQueue{
	Stack<Integer> primary;
	Stack<Integer> auxillary;
	public MyQueue(){
		primary = new Stack<>();
		auxillary = new Stack<>();
	}
	public void enQueue(int val){
		primary.push(val);
	}
	public int deQueue(){
		if(primary.size() <= 0){
			System.out.println("No ele found");
			return -1;
		}
		while(primary.size() != 1){
			auxillary.push(primary.pop());
		}
		int ans = primary.pop();
		while(auxillary.size() != 0){
			primary.push(auxillary.pop());
		}
		return ans;
	}
	public void perform(ArrayList<String> operations){
		while(operations.size() != 0){
			String[] operation = operations.get(0).split(" ");
			if(operation.length == 1){
				System.out.println("dequeud" + "     " + this.deQueue());
			}
			else{
				this.enQueue(Integer.parseInt(operation[1].trim()));
			}
		}
	}
}
