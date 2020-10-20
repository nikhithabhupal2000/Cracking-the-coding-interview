import java.util.*;
public class MergeSort{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		int size = ip.nextInt();
		int[] nums = new int[size];
		for(int i = 0; i < size; i ++){
			System.out.println("Enter num");
			nums[i] = ip.nextInt();
		}
		mergeSort(nums);
		System.out.print("The sorted array is     ");
		for(int i = 0; i < size; i ++){
			System.out.print(nums[i] + "   ");
		}
	}

	public static void mergeSort(int[] nums){
		int[] helper = new int[nums.length];
		mergeSort(nums, helper, 0, nums.length - 1);
	}

	public static void mergeSort(int[] nums, int[] helper, int low, int high){
		if(low < high){
			int mid = low + (high - low) / 2;
			mergeSort(nums, helper, low, middle);
			mergeSort(nums, helper, middle + 1, high);
			merge(nums, helper, low, middle, high);
		}
	}

	public static void merge(int[] nums, int[] helper, int low, int middle, int high){
		
	}
}
