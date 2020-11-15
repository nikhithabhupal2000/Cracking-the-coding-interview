import java.util.*;
import java.io.*;
public class prob_1_4{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = ip.nextLine();
		input = input.replace(" ", "");
		System.out.println(isPallindromePermBit(input));
		System.out.println(isPallindromePerm(input));
	}

	public static boolean isPallindromePerm(String input){
		if(input == null){
			return false;
		}
		int oddCount = 0;
		HashMap<Character, Integer> freq = new HashMap<>();
		for(int i = 0; i < input.length(); i ++){
			if(freq.containsKey(input.charAt(i))){
				freq.put(input.charAt(i), freq.get(input.charAt(i)) + 1);
			}
			else{
				freq.put(input.charAt(i), 1);
			}
		}

		for(Map.Entry<Character, Integer> e : freq.entrySet()){
			if(e.getValue() % 2 == 1){
				oddCount ++;
			}
		}
		return ((oddCount == 0) || (oddCount == 1));
		
	}

	//assuming only lower case 26 chars as domain
	public static boolean isPallindromePermBit(String input){
		int bitVec = 0;
		for(int i = 0; i < input.length(); i ++){
			int val = (int)input.charAt(i) - (int)'a';
			bitVec = bitVec ^ (1 << val);
		}
		return (((bitVec & (bitVec - 1)) == 0) || (bitVec == 0));
	}
}
