import java.util.*;
import java.io.*;
public class prob_8_3{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the value");
			arr[i] = ip.nextInt();
		}
		System.out.println("Magic Index is " + magicIndexDuplicates(arr, 0, arr.length - 1));
	}

	public static int magicIndex(int[] arr){
		if((arr == null) || (arr.length == 0)){
			return -1;
		}
		int low = 0;
		int high = arr.length - 1;
		while(low <= high){
			int mid = low + (high - low) / 2;
			if(arr[mid] == mid){
				return mid;
			}
			else if(arr[mid] > mid){
				high = mid - 1;
			}
			else{
				low = mid + 1;
			}
		}
		return -1;
	}

	public static int magicIndexDuplicates(int[] arr, int start, int end){
		if((arr == null) || (arr.length == 0)){
			return -1;
		}
		if((start < 0) || (end >= arr.length)){
			return -1;
		}
		if(start > end){
			return -1;
		}
		int mid = start + (end - start) / 2;
		if(arr[mid] == mid){
			return mid;
		}
		int leftIndex = Math.min(mid - 1, arr[mid]);
		int magicValue = magicIndexDuplicates(arr, start, leftIndex);
		if(magicValue != -1){
			return magicValue;
		}
		int rightIndex = Math.max(mid + 1, arr[mid]);
		return magicIndexDuplicates(arr, rightIndex, end);

	}
}
