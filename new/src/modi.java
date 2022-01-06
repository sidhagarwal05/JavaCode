import java.util.*;

public class modi {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long test = scn.nextLong();
		long n= test;
		long i=0;
		long number=0;
		if(n-(n/10)!=0&&n>=0&&n<=100000000000000000d) {
		while(n/10!=0){
			int digit = (int) (n%10);
			if(9-digit<digit) {
				digit = 9-digit;
			}
			n=n/10;
			number+=digit*Math.pow(10, i);
			i++;
			
		}
		int digit = (int) (n%10);
		if(9-digit<digit) {
			digit = 9-digit;
		}
		number+=digit*Math.pow(10, i);
		System.out.println(number);
		}
		else
		{
			System.out.println(-1);
		}
	}

}
