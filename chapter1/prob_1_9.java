import java.util.*;
import java.io.*;
public class prob_1_9{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		String s1 = ip.nextLine();
		String s2 = ip.nextLine();
		System.out.println(isRotateSame(s1,s2));
	}

	public static boolean isRotateSame(String s1, String s2){
		if((s1 == null) && (s2 == null)){
			return true;
		}
		if((s1 == null) || (s2 == null)){
			return false;
		}
		if(s1.length() != s2.length()){
			return false;
		}
		s1 = s1 + s1;
		return s1.contains(s2);
	}
}
