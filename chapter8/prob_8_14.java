import java.io.*;
import java.util.*;
public class prob_8_14{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the expression");
		String exp = ip.nextLine();
		System.out.println("Enter the result needed");
		int ans = ip.nextInt();
		System.out.println("Number of ways " + numWays(exp, ans));
	}

	public static int numWays(String exp, int ans){
		if((exp == null) || (exp.length() == 0)){
			return 0;
		}
		else if(exp.length == 1){
			if(Integer.parseInt(exp.charAt(0)) == ans){
				return 1;
			}
			else{
				return 0;
			}
		}
		char[] expSplit = exp.toCharArray();
		for(int i = 1; i < exp.length - 1; i += 2){
			if(expSplit[i] == '|'){
				if(ans == 1){
				}
				else{
				}
			}
		}
	}
}
