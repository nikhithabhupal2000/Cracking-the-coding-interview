import java.io.*;
import java.util.*;
public class CountingSort{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the val");
			arr[i] = ip.nextInt();
		}
		System.out.println("Enter the range");
		int range = ip.nextInt();
		printArray(arr);
		arr = sort(arr, range);
		printArray(arr);
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i] + "    ");
		}
		System.out.println();
	}

	public static int[] sort(int[] arr, int range){
		int[] startingIndex = new int[range + 1];
		for(int i = 0; i < arr.length; i ++){
			startingIndex[arr[i]]++;
		}
		for(int i = 1; i < range + 1; i ++){
			startingIndex[i] += startingIndex[i - 1];
		}
		for(int i = range; i > 0; i --){
			startingIndex[i] = startingIndex[i - 1];
		}
		startingIndex[0] = 0;
		int[] sorted = new int[arr.length];
		for(int i = 0; i < arr.length; i ++){
			sorted[startingIndex[arr[i]] ++] = arr[i];
		}
		return sorted;
	}
}
