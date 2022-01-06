



package RecursionDpBacktracking;

import java.util.ArrayList;

public class BoardPath {

	public static void main(String[] args) {
		System.out.println(getPath(0,10));

	}
	public static ArrayList<String> getPath(int st,int end)  {
		
		if(st==end) {
			ArrayList<String> result =new ArrayList<>();
			result.add("");
			return result;
		}
		if(st>end) {
			ArrayList<String> result =new ArrayList<>();
			
			return result;
		}
		ArrayList<String> result =new ArrayList<>();
		for(int i=1;i<=6;i++) {
			ArrayList<String> base = getPath(st+i,end);
			
			for(String rrs:base) {
				result.add(i+rrs);
			}
			
		}
		return result;
	}

}
