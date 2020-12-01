import java.util.*;
import java.io.*;
public class prob_8_6{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("enter the number of discs");
		int discs = ip.nextInt();
		towersOfHanoi(discs);
	}

	public static void towersOfHanoi(int discs){
		towersOfHanoiHelper(discs, "source", "auxillary", "destination");
	}

	public static void towersOfHanoiHelper(int discs, String source, String auxillary, String destination){
		if(discs <= 0){
			return;
		}
		towersOfHanoiHelper(discs - 1, source, destination, auxillary);
		System.out.println("Move from " + source + "   " + destination);
		towersOfHanoiHelper(discs - 1, auxillary, source, destination);
	}
}
