import java.io.*;
import java.util.*;
public class prob_5_7{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the num");
		int num = ip.nextInt();
		System.out.println("The binary representation of " + num + " is " + Integer.toBinaryString(num));
		System.out.println("After swap " + Integer.toBinaryString(pairWiseSwap(num)));
	}

	public static int pairWiseSwap(int num){
		int rightShift = num >> 1;
		//System.out.println(Integer.toBinaryString(rightShift));
		int leftShift = num << 1;
		//System.out.println(Integer.toBinaryString(leftShift));
		leftShift = clearOddBits(leftShift);
		rightShift = clearEvenBits(rightShift);
		//System.out.println(Integer.toBinaryString(rightShift));
		//System.out.println(Integer.toBinaryString(leftShift));
		return (leftShift | rightShift);
	}

	public static int clearEvenBits(int num){
		int mask = 1431655765;
		//System.out.println(Integer.toBinaryString(mask));
		return (num & mask);
	}

	public static int clearOddBits(int num){
		int mask = 715827882;
		//System.out.println(Integer.toBinaryString(mask));
		return (num & mask);
	}
}
