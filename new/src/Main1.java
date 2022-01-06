import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int first=scn.nextInt();
		int last = scn.nextInt();
		int sum=0;
		for(int i=first;i<=last;i++) {
			sum+=i;
		}
			System.out.println(sum);

	}
	

	
	

}
