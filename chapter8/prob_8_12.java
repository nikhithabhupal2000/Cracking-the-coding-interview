import java.util.*;
import java.io.*;
public class prob_8_12{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the number of quuens");
		int n = ip.nextInt();
		nQueens(n);
	}



	public static boolean isSafe(int pos, int n, int[] sol){
		for(int i = 0; i < n; i ++){
			if(sol[i] == pos){
				return false;
			}
			if((sol[i] != -1) && (Math.abs(n - pos) == Math.abs(i - sol[i]))){
				return false;
			}
		}
		return true;
	}



	public static void nQueensHelper(int current, int n, int[] sol){
		for(int i = 0; i < n; i ++){
			if(isSafe(i, current, sol)){
				sol[current] = i;
				if(current == n){
					return;
				}
				nQueensHelper(current + 1, n, sol);
			}
		}
	}



	public static void nQueens(int n){
		int[] sol = new int[n];
		for(int i = 0; i < n; i ++){
			sol[i] = -1;
		}
		nQueensHelper(0, n, sol);
		for(int i = 0; i < n; i ++){
			System.out.println(sol[i]);
		}
	}

}
