import java.util.*;
import java.io.*;
public class prob_3_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of operations");
		int numberOfOperations = ip.nextInt();
		String[] operations = new String[numberOfOperations];
		ip.nextLine();
		for(int i = 0; i < numberOfOperations; i ++){
			operations[i] = ip.nextLine();
		}

		minStack(operations);

	}

	public static void minStack(String[] operations){
		Stack<Integer> mainStack = new Stack<>();
		Stack<Integer> auxillaryStack = new Stack<>();
		for(int i = 0; i < operations.length; i ++){
			String[] tokens = operations[i].split(" ");
			if(tokens[0].toUpperCase().equals("PUSH")){
				int val = Integer.parseInt(tokens[1]);
				if((auxillaryStack.size() == 0) || (auxillaryStack.peek() >= val)){
					auxillaryStack.push(val);
				}
				mainStack.push(val);
			}
			else if(tokens[0].toUpperCase().equals("POP")){
				if(mainStack.peek() == auxillaryStack.peek()){
					auxillaryStack.pop();
				}
				mainStack.pop();
			}
			else if(tokens[0].toUpperCase().equals("MIN")){
				System.out.println(auxillaryStack.peek());
			}
			else{
				System.out.println("Wrong input");
			}

		}
	}
}
