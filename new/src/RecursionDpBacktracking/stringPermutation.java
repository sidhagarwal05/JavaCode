package RecursionDpBacktracking;
import java.util.*;

public class stringPermutation {

	public static void main(String[] args) {

		System.out.println(getP("abc"));
	}

	public static ArrayList<String> getP(String str) {
		if(str.length()==0) {
			ArrayList<String> result = new ArrayList<>();
			result.add("");
			return result;
		}
		

		char ch = str.charAt(0);
		String str1 = str.substring(1);
		ArrayList<String> base = getP(str1);
		ArrayList<String> result = new ArrayList<>();

		for (String rrs : base) {

			for (int i = 0; i <= rrs.length(); i++) {
				String val = rrs.substring(0, i) + ch + rrs.substring(i);
				result.add(val);
			}
		}
		return result;

	}

}
