import java.util.*;

public class take2 {
	
	public static void main(String[] args) {
		int[] arr= {10,20,30,40,50,60,70};
		BST a=new BST(arr);
		
		a.remove(40);
		a.display();
	}
	
	

}
//50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false