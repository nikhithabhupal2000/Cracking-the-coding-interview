import java.util.*;
import java.io.*;
public class SelectionSort{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int size = ip.nextInt();
		int[] nums = new int[size];
		for(int i = 0; i < size; i ++){
			System.out.println("Enter the num");
			nums[i] = ip.nextInt();
		}
		selectionSort(nums);
		System.out.print("The sorted array is    ");
		for(int i = 0; i < size; i ++){
			System.out.print(nums[i] + "    ");
		}
	}

	public static void selectionSort(int[] nums){
		for(int i = 0; i < nums.length; i ++){
			int j = smallIndex(nums, i);
			swap(nums, i, j);
		}
	}

	public static int smallIndex(int[] nums, int start){
		int val = nums[start];
		int index = start;
		for(int i = start + 1; i < nums.length; i ++){
			if(val > nums[i]){
				val = nums[i];
				index = i;
			}
		}
		return index;
	}

	public static void swap(int[] nums, int i, int j){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
