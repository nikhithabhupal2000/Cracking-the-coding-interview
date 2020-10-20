import java.util.*;
import java.io.*;
public class prob_1_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the two strings");
		String first = ip.nextLine();
		String second = ip.nextLine();
		System.out.println(isPermutationConstantSpace(first, second));
		System.out.println(isPermutation(first, second));
	}

	public static boolean isPermutationConstantSpace(String first, String second){
		if(first.length() != second.length()){
			return false;
		}
		char[] firstChars = first.toCharArray();
		char[] secondChars = second.toCharArray();
		Arrays.sort(firstChars);
		Arrays.sort(secondChars);
		for(int i = 0; i < first.length(); i ++){
			if(firstChars[i] != secondChars[i]){
				return false;
			}
		}
		return true;
	}

	public static boolean isPermutation(String first, String second){
		if(first.length() != second.length()){
			return false;
		}
		HashMap<Character, Integer> freq = new HashMap<>();
		for(int i = 0; i < first.length(); i ++){
			if(freq.containsKey(first.charAt(i))){
				freq.put(first.charAt(i), freq.get(first.charAt(i)) + 1);
			}
			else{
				freq.put(first.charAt(i), 1);
			}
		}

		for(int i = 0; i < second.length(); i ++){
			if(freq.containsKey(second.charAt(i))){
				if(freq.get(second.charAt(i)) == 1){
					freq.remove(second.charAt(i));
				}
				else{
					freq.put(second.charAt(i), freq.get(second.charAt(i)) - 1);
				}
			}
			else{
				return false;
			}
		}
		return true;
	}

}
