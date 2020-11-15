import java.util.*;
import java.io.*;
public class prob_1_8{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.print("Enter number of rows");
		int numRows = ip.nextInt();
		System.out.print("Enter number of cols");
		int numCols = ip.nextInt();
		int[][] matrix = new int[numRows][numCols];
		for(int i = 0; i < numRows; i ++){
			for(int j = 0; j < numCols; j ++){
				System.out.print("val -");
				matrix[i][j] = ip.nextInt();
			}
		}
		printMatrix(matrix);
		System.out.println("");
		zeroify(matrix);
		printMatrix(matrix);
	}
	public static void zeroify(int[][] matrix){
		if((matrix == null) || (matrix.length == 0) || (matrix[0].length == 0)){
			return;
		}
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		boolean isFirstRowZeroable = isRowZeroable(matrix);
		boolean isFirstColZeroable = isColZeroable(matrix);
		markZeroingRowsAndCols(matrix);
		changeRows(matrix);
		changeCols(matrix);
		if(isFirstRowZeroable){
			for(int i = 0; i < numCols; i ++){
				matrix[0][i] = 0;
			}
		}
		if(isFirstColZeroable){
			for(int i = 0; i < numRows; i ++){
				matrix[i][0] = 0;
			}
		}
	}
	public static boolean isRowZeroable(int[][] matrix){
		int numCols = matrix[0].length;
		for(int i = 0; i < numCols; i ++){
			if(matrix[0][i] == 0){
				return true;
			}
		}
		return false;
	}

	public static boolean isColZeroable(int[][] matrix){
		int numRows = matrix.length;
		for(int i = 0; i < numRows; i ++){
			if(matrix[i][0] == 0){
				return true;
			}
		}
		return false;
	}
	public static void markZeroingRowsAndCols(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		for(int i = 1; i < numRows; i ++){
			for(int j = 1; j < numCols; j ++){
				if(matrix[i][j] == 0){
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
	}
	public static void changeRows(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		for(int i = 1; i < numRows; i ++){
			if(matrix[i][0] == 0){
				for(int j = 0; j < numCols; j ++){
					matrix[i][j] = 0;
				}
			}
		}
	}


	public static void changeCols(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		for(int i = 1; i < numCols; i ++){
			if(matrix[0][i] == 0){
				for(int j = 0; j < numRows; j ++){
					matrix[j][i] = 0;
				}
			}
		}
	}

	public static void printMatrix(int[][] matrix){
		int numRows = matrix.length;
		int numCols = matrix[0].length;
		for(int i = 0; i < numRows; i ++){
			for(int j = 0; j < numCols; j ++){
				System.out.print(matrix[i][j] + "   ");
			}
			System.out.println("");
		}
	}
}
