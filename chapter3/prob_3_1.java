import java.io.*;
import java.util.*;
public class prob_3_1{
	public static void main(String[] args) throws Exception{
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the initial capacity of stacks");
		int defaultSize = ip.nextInt();
		MultiStack multiStack = new MultiStack(3, defaultSize);
		multiStack.printInfo();
		multiStack.push(0, 1);
		multiStack.printInfo();
		multiStack.push(1, 1);
		multiStack.printInfo();
		multiStack.push(2, 1);
		multiStack.printInfo();
		multiStack.push(1, 2);
		multiStack.printInfo();
		multiStack.push(1, 3);
		multiStack.printInfo();
		multiStack.push(1, 4);
		multiStack.printInfo();
		multiStack.push(1, 5);
		multiStack.printInfo();
		multiStack.push(1, 6);
		multiStack.printInfo();
		multiStack.push(1, 7);
		multiStack.printInfo();
		multiStack.push(2, 4);
		multiStack.printInfo();
	}

	
}

class MultiStack{
	private class StackInfo{
		public int start, size, capacity;
		public StackInfo(int start, int capacity){
			this.start = start;
			this.capacity = capacity;
		}
		
		public boolean isFull(){
			return size == capacity;
		}

		public boolean isEmpty(){
			return size == 0;
		}

		public int lastCapacityIndex(){
			return adjustIndex(start + capacity - 1);
		}

		public int lastElementIndex(){
			return adjustIndex(start + size - 1);
		}

		public boolean isWithinStackCapacity(int index){
			if((index < 0) || (index >= values.length)){
				return false;
			}
			int contiguousIndex = (index < start) ? index + values.length :index;
			int end = start + capacity;
			return start <= contiguousIndex && contiguousIndex < end;
		}
		public String toString(){
			return "size = " + this.size + "   " + "capacity = " + this.capacity + "  start =  " + this.start;
		}
	}


	StackInfo[] info;
	int[] values;


	public void printInfo(){
                for(int i = 0; i < this.info.length; i ++){
                        System.out.println(this.info[i]);
                }
                System.out.println();
        }
	public MultiStack(int numberOfStacks, int defaultSize){
		info = new StackInfo[numberOfStacks];
		for(int i = 0; i < numberOfStacks; i ++){
			info[i] = new StackInfo(defaultSize * i, defaultSize);
		}
		values = new int[numberOfStacks * defaultSize];
	}

	public void push(int stackNum, int value) throws Exception{
		if(allStacksAreFull()){
			throw new Exception();
		}
		StackInfo stack = info[stackNum];
		if(stack.isFull()){
			expand(stackNum);
		}
		values[stack.lastElementIndex()] = value;
		stack.size ++;
	}
	public int pop(int stackNum) throws Exception{
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()){
			throw new Exception();
		}
		int value = values[stack.lastElementIndex()];
		values[stack.lastElementIndex()] = 0;
		stack.size --;
		return value;
	}

	public int peek(int stackNum) throws Exception{
		StackInfo stack = info[stackNum];
		if(stack.isEmpty()){
			throw new Exception();
		}
		return values[stack.lastElementIndex()];
	}

	public int numberOfElements(){
		int count = 0;
		for(StackInfo a : info){
			count += a.size;
		}
		return count;
	}

	public boolean allStacksAreFull(){
		return (values.length == numberOfElements());
	}

	public void expand(int stackNum){
		shift((stackNum + 1) % info.length);
		info[stackNum].capacity ++;
	}



	private void shift(int stackNum){
		System.out.println("Shifting " + stackNum);
		StackInfo stack = info[stackNum];
		if(stack.size >= stack.capacity){
			int nextStack = (stackNum + 1) % info.length;
			shift(nextStack);
			stack.capacity ++;
		}
		int index = stack.lastCapacityIndex();
		while(stack.isWithinStackCapacity(index)){
			values[index] = values[previousIndex(index)];
			index = previousIndex(index);
		}
		values[stack.start] = 0;
		stack.start = nextIndex(stack.start);
		stack.capacity --;
	}

	private int previousIndex(int index){
		return adjustIndex(index - 1);
	}

	private int nextIndex(int index){
		return adjustIndex(index + 1);
	}

	private int adjustIndex(int index){
		int max = values.length;
		return ((index % max) + max) % max;
	}
}
