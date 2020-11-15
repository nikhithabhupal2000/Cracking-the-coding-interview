import java.util.*;
import java.io.*;
public class prob_1_5{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the two strings");
		String first = ip.nextLine();
		String second = ip.nextLine();
		System.out.println(oneAway(first, second));
	}

	public static boolean oneAway(String first, String second){
		if(Math.abs(first.length() - second.length()) > 1){
			return false;
		}

		if(second.length() > first.length()){
			String tmp = second;
			second = first;
			first = tmp;
		}

		int index1 = 0;
		int index2 = 0;
		boolean misMatch = false;
		while((index1 < first.length()) && (index2 < second.length())){
			if(first.charAt(index1) != second.charAt(index2)){
				if(misMatch){
					return false;
				}
				else{
					misMatch = true;
					if(first.length() == second.length()){
						index1 ++;
						index2 ++;
					}
					else{
						index1 ++;
					}
				}
			}
			else{
				index1 ++;
				index2 ++;
			}
		}
		return true;
	}
}
