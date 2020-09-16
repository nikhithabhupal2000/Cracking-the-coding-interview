import java.io.*;
import java.util.*;
public class prob_5_1{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the original number");
		int originalNumber = ip.nextInt();
		System.out.println("Enter the number you want to insert");
		int insertNumber = ip.nextInt();
		System.out.println("Enter from and to positions(from < to)");
		int from = ip.nextInt();
		int to = ip.nextInt();
		System.out.println(Integer.toBinaryString(insert(originalNumber, insertNumber, from, to)));
	}

	public static int insert(int originalNumber, int insertNumber, int from, int to){
		originalNumber = clearBits(originalNumber, from, to);
		insertNumber = insertNumber << from;
		return originalNumber | insertNumber;
	}

	public static int clearBits(int originalNumber, int from, int to){
		for(int i = from; i <= to; i ++){
			originalNumber = clear(originalNumber, i);
		}
		return originalNumber;
	}

	public static int clear(int originalNumber, int bit){
		int mask = ~(1 << bit);
		return originalNumber & mask;
	}
}