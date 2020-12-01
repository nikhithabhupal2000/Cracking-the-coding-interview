import java.io.*;
import java.util.*;
public class prob_3_3{
	public static void main(String[] args) throws Exception{
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the threshold value");
		int threshold = ip.nextInt();
		SetOfStacks ss = new SetOfStacks(threshold);
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.pop();
		ss.push(5);
		ss.push(6);
		ss.pop();
		ss.push(7);
		ss.popAt(0);
		ss.popAt(0);
		ss.push(8);
		ss.push(9);
		ss.pop();
		ss.push(10);
		ss.push(11);
	}
}
class SetOfStacks{
	ArrayList<Stack<Integer>> stacks;
	int threshold;
	int lastIndex;
	public SetOfStacks(int threshold){
		this.threshold = threshold;
		stacks = new ArrayList<>();
		lastIndex = -1;
	}

	public void printStacks(){
		for(Stack<Integer> a : stacks){
			System.out.println(a);
		}
		System.out.println();
	}
	public void push(int ele){
		if((lastIndex == -1) || (isFull(lastIndex))){
			Stack<Integer> stack = new Stack<>();
			stacks.add(stack);
			lastIndex ++;
		}
		stacks.get(lastIndex).push(ele);
		printStacks();
	}

	public boolean isFull(int index){
		return (stacks.get(index).size() == threshold);
	}

	public int pop() throws Exception{
		if(isEmpty()){
			throw new Exception();
		}
		int val = stacks.get(lastIndex).pop();
		if(stacks.get(lastIndex).size() == 0){
			stacks.remove(lastIndex);
			lastIndex --;
		}
		printStacks();
		return val;
	}
	public int peek() throws Exception{
		if(isEmpty()){
			throw new Exception();
		}
		printStacks();
		return stacks.get(lastIndex).peek();
	}

	public boolean isEmpty(){
		return stacks.size() == 0;
	}

	public int popAt(int index) throws Exception{
		if((index < 0) || (index > lastIndex)){
			throw new Exception();
		}
		int val = stacks.get(index).pop();
		if(stacks.get(index).size() == 0){
			stacks.remove(index);
			lastIndex --;
		}

		printStacks();
		return val;
	}

}
