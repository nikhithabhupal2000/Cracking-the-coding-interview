import java.io.*;
import java.util.*;
public class prob_8_5{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the nums");
		int num1 = ip.nextInt();
		int num2 = ip.nextInt();
		System.out.println(multiply(num1, num2));
		System.out.println(multiplyByBits(num1, num2));
	}

	public static int multiply(int num1, int num2){
		if(num1 > num2){
			return multiplyHelper(num2, num1);
		}
		return multiplyHelper(num1, num2);
	}

	public static int multiplyHelper(int num1, int num2){
		if(num1 == 0){
			return 0;
		}
		else if(num1 == 1){
			return num2;
		}
		int halfProduct = multiplyHelper(num1 / 2, num2);
		int ans = halfProduct + halfProduct;
		if(num1 % 2 != 0){
			ans += num2;
		}
		return ans;
	}

	public static int multiplyByBits(int num1, int num2){
		if(num1 > num2){
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		int ans = 0;
		int bitNum = 0;
		while(num1 != 0){
			if((num1 & 1) != 0){
				ans += num2 << bitNum;
			}
			bitNum ++;
			num1 = num1 >> 1;
		}
		return ans;
	}
}
