import java.util.*;
import java.io.*;
public class prob_1_3{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the string and true length");
		String input = ip.nextLine();
		char[] in = new char[input.length()];
		for(int i = 0; i < in.length; i ++){
			in[i] = input.charAt(i);
		}
		int length = ip.nextInt();
		System.out.println(replaceSpaces(in, length));
	}

	public static  String replaceSpaces(char[] in, int len){
		int j = in.length - 1;
		for(int i = len - 1; i >= 0; i --){
			if(in[i] == ' '){
				in[j --] = '0';
				in[j --] = '2';
				in[j] = '%';
			}
			else{
				in[j] = in[i];	
			}
			j --;
		}
		return new String(in);
	}	
}
