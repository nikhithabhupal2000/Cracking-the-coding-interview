import java.io.*;
import java.util.*;
public class prob_5_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the original number");
		int original = ip.nextInt();
		System.out.println("Enter the to-insert number");
		int insert = ip.nextInt();
		System.out.println("Enter the lower end");
		int lower = ip.nextInt();
		System.out.println("Enter the higher end");
		int higher = ip.nextInt();
		int inserted = insertNum(original, insert, lower, higher);
		System.out.println(Integer.toBinaryString(inserted));
		inserted = insertNum2(original, insert, lower, higher);
		System.out.println(Integer.toBinaryString(inserted));
	}

	public static int insertNum(int original, int insert, int lower, int higher){
		original = clearBits(original, lower, higher);
		insert = insert << lower;
		return original | insert;
	}

	public static int insertNum2(int original, int insert, int lower, int higher){
		int mask1 = (1 << (lower + 1)) - 1;
		int mask2 = (1 << (higher + 1)) - 1;
		int mask = ~(mask1 ^ mask2);
		original = original & mask;
		insert = insert << lower;
		return original | insert;


	}


	public static int clearBits(int original, int lower, int higher){
		for(int i = lower; i <= higher; i ++){
			int mask = ~(1 << i);
			original = original & mask;
		}
		return original;
	}
}
