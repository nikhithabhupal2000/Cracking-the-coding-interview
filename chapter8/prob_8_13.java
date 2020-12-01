import java.io.*;
import java.util.*;
class Box implements Comparable{
	int width;
	int height;
	int depth;
	Box(){
	}
	Box(int width, int height, int depth){
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
	public int compareTo(Object a){
		Box tmp = (Box)a;
		return tmp.width - this.width;
	}
	//public String toString(
}
public class prob_8_13{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of boxes");
		int n = ip.nextInt();
		Box[] boxes = new Box[n];
		for(int i = 0; i < n; i ++){
			boxes[i] = new Box();
			System.out.println("Enter the width, height, depth");
			boxes[i].width = ip.nextInt();
			boxes[i].height = ip.nextInt();
			boxes[i].depth = ip.nextInt();
		}
		System.out.println("Max height of stack is" + maxHeight(boxes));
	}

	public static int maxHeight(Box[] boxes){
		if((boxes == null) || (boxes.length == 0)){
			return 0;
		}
		Arrays.sort(boxes);
		int[] heights = new int[boxes.length];
		for(int i = 0; i < boxes.length; i ++){
			heights[i] = boxes[i].height;
		}
		for(int i = 1; i < boxes.length; i ++){
			for(int j = 0; j < i; j ++){
				if((boxes[i].height > boxes[j].height) && (boxes[i].depth > boxes[j].depth)){
					heights[i] = Math.max(heights[i], heights[j] + boxes[i].height);
				}
			}
		}
		int max = 0;
		for(int i = 0; i < boxes.length; i ++){
			max = Math.max(max, heights[i]);
		}
		return max;
	}
}
