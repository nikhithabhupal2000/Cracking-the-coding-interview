import java.util.*;
import java.io.*;
public class prob_10_11{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the val");
			arr[i] = ip.nextInt();
		}
		printArray(arr);
		peaksAndValleys2(arr);
		printArray(arr);
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i] + "    ");
		}
		System.out.println();
	}

	public static void peaksAndValleys(int[] arr){
		Arrays.sort(arr);
		for(int i = 1; i < arr.length; i += 2){
			swap(arr, i, i - 1);
		}
	}


	public static void peaksAndValleys2(int[] arr){
		for(int i = 1; i < arr.length; i += 2){
			int maxIndex = peakIndex(arr, i, i - 1, i + 1);
			if(maxIndex != i){
				swap(arr, maxIndex, i);
			}
		}
	}


	public static int peakIndex(int[] arr, int i, int j, int k){
		if(k < arr.length){
			if((arr[i] >= arr[j]) && (arr[i] >= arr[k])){
			       return 	i;
			}
			else if((arr[j] >= arr[i] ) && (arr[j] >= arr[k])){
				return j;
			}
			else{
				return k;
			}
		}
		else{
			if(arr[i] > arr[j]){
				return i;
			}
			else{
				return j;
			}
		}
	}

	public static void swap(int[] arr, int i, int j){
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}
}
