import java.io.*;
import java.util.*;
public class prob_8_11{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter n value");
		int n = ip.nextInt();
		System.out.println(numberOfWays(n));
	}

	public static int numberOfWays(int n){
		int[] sol = new int[n + 1];
		sol[0] = 0;
		if(n >= 1){
			sol[1] = 1;
		}
		if(n >= 5){
			sol[5] = 1;
		}
		if(n >= 10){
			sol[10] = 1;
		}
		if(n >= 25){
			sol[25] = 1;
		}
		for(int i = 2; i <= n; i ++){
			if(i - 1 > 0){
				sol[i] += sol[i - 1];
			}
			if(i - 5 > 0){
				sol[i] += sol[i - 5];
			}
			if(i - 10 > 0){
				sol[i] += sol[i - 10];
			}
			if(i - 25 > 0){
				sol[i] += sol[i - 25];
			}
		}
		return sol[n];
	}
}
