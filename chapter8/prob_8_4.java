import java.io.*;
import java.util.*;
public class prob_8_4{
	public static void main(String[] args){
		Scanner ip = new Scanner(System.in);
		System.out.println("Enter the size of the set");
		int size = ip.nextInt();
		int[] set = new int[size];
		for(int i = 0; i < size; i ++){
			System.out.println("Enter the val");
			set[i] = ip.nextInt();
		}
		System.out.println(powerSet(set));
		System.out.println(powerSet2(set));
	}
	public static HashSet<ArrayList<Integer>> powerSet(int[] set){
		if((set == null) || (set.length == 0)){
			return null;
		}
		ArrayList<ArrayList<Integer>> prevPowerSet = new ArrayList<>();
		ArrayList<Integer> lastIndex = new ArrayList<>();
		HashSet<ArrayList<Integer>> sol = new HashSet<>();
		ArrayList<Integer> emptySet = new ArrayList<>();
		prevPowerSet.add(emptySet);
		lastIndex.add(-1);
		while(prevPowerSet.size() != 0){
			int count = prevPowerSet.size();
			while(count != 0){
				int last = lastIndex.get(0);
				for(int i = last + 1; i < set.length; i ++){
					ArrayList<Integer> current = (ArrayList<Integer>)prevPowerSet.get(0).clone();
					current.add(set[i]);
					prevPowerSet.add(current);
					lastIndex.add(i);
				}
				count --;
				sol.add(prevPowerSet.get(0));
				prevPowerSet.remove(0);
				lastIndex.remove(0);
			}
		}
		return sol;
	}


	public static ArrayList<ArrayList<Integer>> powerSet2(int[] set){
		if((set == null) || (set.length == 0)){
			return null;
		}
		ArrayList<ArrayList<Integer>> sol = new ArrayList<>();
		sol.add(new ArrayList<>());
		for(int i = 0; i < set.length; i ++){
			int count = sol.size();
			int c = 0;
			while(count != 0){
				ArrayList<Integer> tmp = (ArrayList<Integer>)sol.get(c).clone();
				tmp.add(set[i]);
				sol.add(tmp);
				count --;
				c ++;
			}
		}
		return sol;
	}

}
