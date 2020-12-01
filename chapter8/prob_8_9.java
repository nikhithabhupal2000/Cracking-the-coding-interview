import java.io.*;
import java.util.*;
public class prob_8_9{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter n value");
		int n = ip.nextInt();
		printParans(n);
		System.out.println("\n\n" + printParanthesis(n));
	}

	public static void printParans(int n){
		ArrayList<String> sol = new ArrayList<>();
		helper("",n,n, sol);
		System.out.println(sol);
	}

	public static void helper(String ans, int open, int close, ArrayList<String> sol){
		if((open == 0) && (close == 0)){
			sol.add(ans);
			return;
		}
		if(open > 0){
			ans += "(";
			helper(ans, open - 1, close, sol);
			ans = ans.substring(0, ans.length() - 1);
		}
		if(close > open){
			ans += ")";
			helper(ans, open, close - 1, sol);
			ans = ans.substring(0, ans.length() - 1);
		}
	}
/*
 *
 *wrong because n = 4 can also be egenrated from n = 2
 *
 *
	public static ArrayList<String> printParanthesis(int n){
		ArrayList<String> prev = new ArrayList<>();
		prev.add(new String());
		for(int i = 0; i < n; i ++){
			int count = prev.size();
			HashSet<String> current = new HashSet<>();
			while(count != 0){
				String tmp = prev.get(0);
				prev.remove(0);
				current.add("()" + tmp);
				current.add(tmp + "()");
				current.add("(" + tmp + ")");
				count --;
			}
			for(String a : current){
				prev.add(a);
			}
		}
		return prev;
	}
	*/
}
