package Assignment1;

import java.util.Scanner;

public class ques3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a=scn.nextInt();
		int b = scn.nextInt();
		int sum=0;
		int gcd=-1;
		for(int i=1;i<=a&&i<=b;i++) {
			if(a%i==0&&b%i==0) {
				gcd=i;
			}
		}
		System.out.println(gcd);
	}

}
