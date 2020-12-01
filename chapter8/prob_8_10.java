import java.io.*;
import java.util.*;
class Point{
	int x;
	int y;
	Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public String toString(){
		return (x + "   " + y);
	}
}
public class prob_8_10{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the rows and cols");
		int rows = ip.nextInt();
		int cols = ip.nextInt();
		int[][] image = new int[rows][cols];
		for(int i = 0; i < rows; i ++){
			for(int j = 0; j < cols; j ++){
				System.out.println("Enter val");
				image[i][j] = ip.nextInt();
			}
		}
		System.out.println("Enter x val and y vals and color");
		int x = ip.nextInt();
		int y = ip.nextInt();
		int color = ip.nextInt();
		printImage(image);
		//int[][] image2 = (int[][] )image.clone();
		//floodFillDFS(image, x, y, color, image[x][y]);
		//printImage(image);
		floodFillBFS(image, x, y, color, image[x][y]);
		printImage(image);
	}

	public static void floodFillBFS(int[][] image, int i, int j, int color, int val){
		ArrayList<Point> que = new ArrayList<>();
		que.add(new Point(i,j));
		while(que.size() != 0){
			//System.out.println(que);
			Point tmp = que.get(0);
			que.remove(tmp);
			image[tmp.x][tmp.y] = color;
			//printImage(image);
			if((!notInRange(tmp.x + 1, image.length)) && (image[tmp.x + 1][tmp.y] == val)){
				que.add(new Point(tmp.x + 1, tmp.y));
			}
			if((!notInRange(tmp.x - 1, image.length)) && (image[tmp.x - 1][tmp.y] == val)){
				que.add(new Point(tmp.x - 1, tmp.y));
			}
			if((!notInRange(tmp.y + 1, image[0].length)) && (image[tmp.x][tmp.y + 1] == val)){
				que.add(new Point(tmp.x, tmp.y + 1));
			}
			if((!notInRange(tmp.y - 1, image[0].length)) && (image[tmp.x][tmp.y - 1] == val)){
				que.add(new Point(tmp.x, tmp.y - 1));
			}
		}
	}

	public static void floodFillDFS(int[][] image, int i, int j, int color, int val){
		if((notInRange(i, image.length)) || (notInRange(j, image[0].length)) || (image[i][j] != val)){
			return;
		}
		image[i][j] = color;
		floodFillDFS(image, i + 1, j, color, val);
		floodFillDFS(image, i - 1, j, color, val);
		floodFillDFS(image, i, j + 1, color, val);
		floodFillDFS(image, i, j - 1, color, val);
		
	}

	public static boolean notInRange(int x, int r){
		return ((x < 0) || (x >= r));
	}

	public static void printImage(int[][] image){
		for(int i = 0;  i < image.length; i ++){
			for(int j = 0; j < image[0].length; j ++){
				System.out.print(image[i][j] + "  ");
			}
			System.out.println("");
		}
	}
}
