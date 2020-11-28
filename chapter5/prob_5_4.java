import java.io.*;
import java.util.*;
public class prob_5_4{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the num");
		int num = ip.nextInt();
		System.out.println("Number is " + Integer.toBinaryString(num));
		System.out.println("Next smallest is " + Integer.toBinaryString(nextSmallest(num)));
		System.out.println("Next largest is " + Integer.toBinaryString(nextLargest(num)));
	}

	public static int nextLargest(int num){
		num = setLeftMostZero(num);
		num = resetRightMostOne(num);
		return num;
	}

	public static int nextSmallest(int num){
		num = resetLeftMostOne(num);
		num = setRightMostZero(num);
		return num;
	}

	public static int setLeftMostZero(int num){
		for(int i = 31; i >= 0; i --){
			if(!(isSetBit(i, num))){
				num = num | (1 << i);
				return num;
			}
		}
		return -1;
	}

	public static int resetRightMostOne(int num){
		for(int i = 0; i < 32; i ++){
			if(isSetBit(i, num)){
				num = num & (~(1 << i));
				return num;
			}
		}
		return -1;
	}

	public static int resetLeftMostOne(int num){
		for(int i = 31; i >= 0; i --){
			if(isSetBit(i, num)){
				num = num & (~(1 << i));
				return num;
			}
		}
		return -1;
	}

	public static int setRightMostZero(int num){
		for(int i = 0;i < 32; i ++){
			if(!(isSetBit(i, num))){
				num = num | (1 << i);
				return num;
			}
		}
		return -1;
	}

	public static boolean isSetBit(int i, int num){
		int mask = (1 << i);
		num = num & mask;
		return (num != 0);
	}

}
