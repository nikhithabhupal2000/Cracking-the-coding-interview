import java.util.*;
import java.io.*;
public class prob_10_2{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the array");
		int n = ip.nextInt();
		ip.nextLine();
		String[] words = new String[n];
		for(int i = 0; i < n; i ++){
			System.out.println("Enter the string");
			words[i] = ip.nextLine();
		}
		printArray(words);
		groupAnagrams(words);
		printArray(words);
	}

	public static void printArray(String[] words){
		System.out.println("*****************************************");
		for(int i = 0; i < words.length; i ++){
			System.out.println(words[i]);
		}
		System.out.println("*****************************************");
	}


	public static void groupAnagrams(String[] words){
		HashMap<String, ArrayList<String>> map = new HashMap<>();
		for(String  s : words){
			String sortedChars = charsSort(s);
			if(map.containsKey(sortedChars)){
				map.get(sortedChars).add(s);
			}
			else{
				ArrayList<String> tmp = new ArrayList<>();
				tmp.add(s);
				map.put(sortedChars, tmp);
			}
		}
		int i = 0;
		for(Map.Entry<String, ArrayList<String>> e : map.entrySet()){
			for(String a : e.getValue()){
				words[i ++] = a;
			}
		}
		
	}

	public static String charsSort(String str){
		char[] chars = str.toCharArray();
		Arrays.sort(chars);
		return new String(chars);
	}

}
