package RecursionDpBacktracking;

import java.util.ArrayList;

public class MazePath {

	public static void main(String[] args) {
		
System.out.println(mazePath(0,0,2,2));
	}
	
	public static ArrayList<String> mazePath(int cr,int cc,int er,int ec){
		if(cc==ec&&cr==er) {
			ArrayList<String> result =new ArrayList<>();
			result.add("");
			return result;
		}
		if(cc>ec||cr>er) {
			ArrayList<String> result =new ArrayList<>();
			return result;
		}
		
		
		
		ArrayList<String> result = new ArrayList<>();
			ArrayList<String> base1=mazePath(cr+1,cc,er,ec);
			for(String rrs:base1) {
				result.add("R"+rrs);
			}
			ArrayList<String> base2=mazePath(cr,cc+1,er,ec);
			for(String rrs:base2) {
				result.add("C"+rrs);
			}	
			return result;
			
	}

}
