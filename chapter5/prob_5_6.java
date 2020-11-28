import java.util.*;
import java.io.*;
public class prob_5_6{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the nums");
		int num1 = ip.nextInt();
		int num2 = ip.nextInt();
		System.out.println("No of bits to flip :" + countBitsToFlip(num1, num2));
	}

	public static int countBitsToFlip(int num1, int num2){
		int xorValue = num1 ^ num2;
		return numberOfSetBits(xorValue);
	}
	public static int numberOfSetBits(int num){
		int count = 0;
		while(num != 0){
			count ++;
			num = num & (num - 1);
		}
		return count;
	}
}
