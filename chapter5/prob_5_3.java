import java.util.*;
import java.io.*;
public class prob_5_3{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number");
		int num = ip.nextInt();
		System.out.println(lenOfContinousOnesAfterAFlip(num));
	}

	public static int lenOfContinousOnesAfterAFlip(int num){
		int[] leftSum = new int[32];
		int[] rightSum = new int[32];
		generateLeftSum(leftSum, num);
		generateRightSum(rightSum, num);
		int len = 0;
		for(int i = 1; i < 31; i ++){
			if(leftSum[i] == 0){
				len = 1 + Math.max((leftSum[i - 1] + rightSum[i + 1]), leftSum[i + 1] + rightSum[i - 1]);
			}
		}
		return len;
	}

	public static void generateLeftSum(int[] leftSum, int num){
		int prev = 0;
		for(int i = 0; i < 32; i ++){
			int lastBit = (num & 1);
			if(lastBit == 1){
				leftSum[i] = 1 + prev;
			}
			else{
				leftSum[i] = 0;
			}
			prev = leftSum[i];
			num = num >> 1;
		}
	}

	public static void generateRightSum(int[] rightSum,int[] leftSum:wq int num){
		int start = 0;

	}

}
