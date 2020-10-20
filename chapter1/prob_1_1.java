import java.util.*;
import java.io.*;
public class prob_1_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the string");
		String input = ip.nextLine();
		System.out.println(isUniqueAscii(input));
		System.out.println(isUniqueBit(input));
		System.out.println(isUniqueInplace(input));
		System.out.println(isUniqueInplaceModification(input));
	}

	//assuming extended ascci which has 256 chars.
	//O(1) space. because size of array is already fixed. 
	//O (min(n, 256)) time 
	public static boolean isUniqueAscii(String input){
		boolean[] appeared = new boolean[256];
		for(int i = 0; i < input.length(); i ++){
			int val = (int)input.charAt(i);
			if(appeared[val]){
				return false;
			}
			appeared[val] = true;
		}
		return true;
	}

	//reducing space using the bit vector.
	public static boolean isUniqueBit(String input){
		int[] bitVector = new int[8];
		for(int i = 0; i < input.length(); i ++){
			int val = (int)input.charAt(i);
			int bit = val / 32;
			int position = val % 32;
			if(checkAndSet(bitVector,bit, position)){
			       return false;
			}	       

		}
		return true;
	}

	public static boolean checkAndSet(int[] bitVector, int bit, int position){
		int current = bitVector[bit];
		current = (current >> position);
		if(((current & 1) == 1)){
			return true;
		}
		int tmp = 1;
		tmp = tmp << position;
		bitVector[bit] |= tmp;
		return false;
	}



	//without additional space and string modification not allowed
	public static boolean isUniqueInplace(String input){
		for(int i = 0; i < input.length(); i ++){
			for(int j = i + 1; j < input.length(); j ++){
				if(input.charAt(i) == input.charAt(j)){
					return false;
				}
			}
		}
		return true;
	}

	//without additional space but modification allowed
	public static boolean isUniqueInplaceModification(String input){
		char[] chars = input.toCharArray();
		Arrays.sort(chars);
		for(int i = 1; i < chars.length; i ++){
			if(chars[i] == chars[i - 1]){
				return false;
			}
		}
		return true;
	}


}
