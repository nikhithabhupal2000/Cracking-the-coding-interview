import java.util.*;
import java.io.*;
public class BubbleSort{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int numberOfElements = ip.nextInt();
		int[] nums = new int[numberOfElements];
		for(int i = 0; i < numberOfElements; i ++){
			System.out.println("Enter nums");
			nums[i] = ip.nextInt();
		}
		bubbleSort(nums);
		System.out.print("The sorted array is :       ");
		for(int i = 0; i < numberOfElements; i ++){
			System.out.print(nums[i]+ "     ");
		}
	}

	public static void bubbleSort(int[] nums){
		int n = nums.length;
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < n - i - 1; j ++){
				if(nums[j] > nums[j + 1]){
					swap(nums, j, j + 1);
				}
			}
		}
	}

	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
