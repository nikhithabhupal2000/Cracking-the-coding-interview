import java.util.*;
import java.io.*;
public class prob_8_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the rows of the matrix");
		int rows = ip.nextInt();
		System.out.println("Enter the cols of the matrix");
		int cols = ip.nextInt();
		int[][] grid = new int[rows][cols];
		System.out.println("Enter the vals in grid");
		for(int i = 0; i < rows; i ++){
			for(int j = 0; j < cols; j ++){
				grid[i][j] = ip.nextInt();
			}
		}
		System.out.println("Is reachable : " + isReachable(grid));
	}

	public static boolean isReachable(int[][] grid){
		if((grid == null) || (grid.length == 0) || (grid[0].length == 0)){
			return false;
		}
		int rows = grid.length;
		int cols = grid[0].length;
		boolean obstacleFound = false;
		for(int i = 0; i < cols; i ++){
			if(obstacleFound == true){
				grid[0][i] = 0;
			}
			else{
				if(grid[0][i] == 0){
					obstacleFound = true;
				}
			}
		}

		obstacleFound = false;
		for(int i = 0; i < rows; i ++){
			if(obstacleFound == true){
				grid[i][0] = 0;
			}
			else{
				if(grid[i][0] == 0){
					obstacleFound = true;
				}
			}
		}

		for(int i = 1; i < rows; i ++){
			for(int j = 1; j < cols; j ++){
				if(grid[i][j] == 1){
					if((grid[i - 1][j] == 1) || (grid[i][j - 1] == 1)){
						grid[i][j] = 1;
					}
					else{
						grid[i][j] = 0;
					}
				}
			}
		}
		return (grid[rows - 1][cols - 1] == 1);
	}
}
