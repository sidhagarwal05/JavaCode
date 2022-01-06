import java.util.*;

public class practice {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t=scn.nextInt();
		for(int p=0;p<t;p++) {
			long a=scn.nextLong();
			long b=scn.nextLong();
			long c = a*b;
				if(a%2==0||b%2==0) {
					
				System.out.println((c)/2);
				}
				else {
					System.out.println(((c)/2)+1);
				}
			
			
		}
	}

}
