import java.util.*;
import java.io.*;
public class prob_10_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the sizes");
		int s1 = ip.nextInt();
		int s2 = ip.nextInt();
		int[] arr1 = new int[s1 + s2];
		int[] arr2 = new int[s2];
		System.out.println("Enter first arr");
		for(int i = 0; i < s1; i ++){
			System.out.println("Enter val");
			arr1[i] = ip.nextInt();
		}
		System.out.println("Enter second arr");
		for(int i = 0; i < s2; i ++){
			System.out.println("Enter val");
			arr2[i] = ip.nextInt();
		}
		printArray(arr1);
		printArray(arr2);
		merge(arr1, arr2);
		printArray(arr1);
	}

	public static void printArray(int[] arr){
		for(int i = 0; i < arr.length; i ++){
			System.out.print(arr[i] + "      ");
		}
		System.out.println();
	}

	public static void merge(int[] arr1, int[] arr2){
		int p2 = arr2.length - 1;
		int p1 = arr1.length - 1 - arr2.length;
		int current = arr1.length - 1;
		while((p1 >= 0) && (p2 >= 0)){
			if(arr1[p1] > arr2[p2]){
				arr1[current --] = arr1[p1 --];
			}
			else{
				arr1[current --] = arr2[p2 --];
			}

		}
		while(p1 >= 0){
			arr1[current --] = arr1[p1 --];
		}
		while(p2 >= 0){
			arr1[current --] = arr2[p2 --];
		}
	}
}
