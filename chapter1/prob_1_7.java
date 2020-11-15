import java.util.*;
import java.io.*;
public class prob_1_7{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter the size of matrix :");
		int imageSize = ip.nextInt();
		int[][] image = new int[imageSize][imageSize];
		for(int i = 0; i < imageSize; i ++){
			for(int j = 0; j < imageSize; j ++){
				System.out.print("Enter pixel value :  ");
				image[i][j] = ip.nextInt();
			}
		}
		prob_1_8.printMatrix(image);
		System.out.println("\n rotated clockwise");
		rotateClockwise(image);
		prob_1_8.printMatrix(image);
		System.out.println("\n rotated anti - clockwise");
		rotateAntiClockwise(image);
		prob_1_8.printMatrix(image);
	}
	public static void rotateClockwise(int[][] image){
		if((image == null) || (image.length == 0)){
			return;
		}
		transpose(image);
		flipRows(image);
	}
	public static void rotateAntiClockwise(int[][] image){
		if((image == null) || (image.length == 0)){
			return;
		}
		transpose(image);
		flipCols(image);
	}

	public static void transpose(int[][] image){
		int imageSize = image.length;
		for(int i = 0; i < imageSize; i ++){
			for(int j = 0; j < imageSize; j ++){
				if(i < j){
					swap(image, i, j, j, i);
				}
			}
		}
	}

	public static void swap(int[][] image, int i, int j, int i1, int j1){
		int tmp = image[i][j];
		image[i][j] = image[i1][j1];
		image[i1][j1] = tmp;
	}

	public static void flipRows(int[][] image){
		int imageSize = image.length;
		for(int i = 0; i < (imageSize) / 2; i ++){
			for(int j = 0; j < imageSize; j ++){
				swap(image, j, i, j, imageSize - 1- i);
			}
		}
	}

	public static void flipCols(int[][] image){
		int imageSize = image.length;
		for(int i = 0; i < (imageSize) / 2; i ++){
			for(int j = 0; j < imageSize; j ++){
				swap(image, i, j, imageSize - 1- i, j);
			}	
		}
	}

	
}
