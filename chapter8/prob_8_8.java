import java.io.*;
import java.util.*;
public class prob_8_8{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the string");
		String s = ip.nextLine();
		System.out.println(permutations(s));
	}

	public static HashSet<String> permutations(String s){
		HashSet<String> perms = new HashSet<>();
		permsHelper(s.toCharArray(), 0, perms);
		return perms;
	}

	public static void permsHelper(char[] s, int index, HashSet<String> sol){
		if(index == s.length - 1){
			sol.add(new String(s));
		}
		for(int i = index; i < s.length; i ++){
			swap(s, index, i);
			permsHelper(s, index + 1, sol);
			swap(s, index, i);
		}
	}

	public static void swap(char[] s, int i, int j){
		char tmp = s[i];
		s[i] = s[j];
		s[j] = tmp;
	}
}
