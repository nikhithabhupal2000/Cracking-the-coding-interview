import java.util.*;
import java.io.*;
public class prob_8_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter  n value");
		int n = ip.nextInt();
		System.out.println("Number of ways to reach : " + waysToReachNthStair(n));
		System.out.println("Number of ways to reach : " + waysToReachNthStair2(n));
	}

	public static int waysToReachNthStair(int n){
		if(n <= 0){
			return -1;
		}
		int[] numberOfWays = new int[n];
		numberOfWays[0] = 1;
		numberOfWays[1] = 2;
		numberOfWays[2] = 4;
		for(int i = 3; i < n; i ++){
			numberOfWays[i] = numberOfWays[i - 1] + numberOfWays[i - 2] + numberOfWays[i - 3];
		}
		return numberOfWays[n - 1];
	}

	public static int waysToReachNthStair2(int n){
		if(n <= 0){
			return -1;
		}
		if((n == 1) || (n == 2)){
			return n;
		}
		if(n == 3){
			return 4;
		}
		int waysForN_1 = 4;
		int waysForN_2 = 2;
		int waysForN_3 = 1;
		for(int i = 4; i <= n; i ++){
			int waysForN = waysForN_1 + waysForN_2 + waysForN_3;
			waysForN_3 = waysForN_2;
			waysForN_2 = waysForN_1;
			waysForN_1 = waysForN;
		}
		return waysForN_1;
	}
}
