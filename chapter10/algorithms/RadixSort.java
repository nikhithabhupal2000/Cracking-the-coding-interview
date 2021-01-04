import java.io.*;
import java.util.*;
public class RadixSort{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of array");
		int n = ip.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the val");
			arr[i] = ip.nextInt();
		}
		printArray(arr);
		arr = sort(arr);
		printArray(arr);
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i] + "    ");
		}
		System.out.println();
	}


	public static int[] sort(int[] arr){
		int maxDigits = 3;
		for(int i = 0; i < maxDigits; i ++){
			arr = countSort(arr, i + 1);
		}

		return arr;
	}

	public static int[] countSort(int[] arr, int d){
		int[] startIndex = new int[10];
		for(int i = 0; i < arr.length; i ++){
			int tmp = (arr[i] % (int)Math.pow(10,d)) / (int)Math.pow(10,d - 1);
			if(tmp > 9){
				tmp = 0;
			}
			startIndex[tmp] ++;
		}

		for(int i = 1; i < 10; i ++){
			startIndex[i] += startIndex[i - 1];
		}

		for(int i = 9; i > 0; i --){
			startIndex[i] = startIndex[i - 1];
		}

		startIndex[0] = 0;

		int[] sol = new int[arr.length];
		for(int i = 0; i < arr.length; i ++){
			int tmp = (arr[i] % (int)Math.pow(10,d)) /(int)Math.pow(10,d - 1);
			sol[startIndex[tmp] ++ ] = arr[i];
		}
		return sol;
	}
}
