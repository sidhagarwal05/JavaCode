package Assignment1;

import java.util.Scanner;

public class ques4 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a=scn.nextInt();
		boolean flag=true;
		for(int i=2;i<=Math.sqrt(a);i++) {
			if(a%i==0) {
				flag=false;
			}
		}
		if(flag) {
			System.out.println("Prime");
		}
		else {
			System.out.println("Not Prime");
		}

	}

}
