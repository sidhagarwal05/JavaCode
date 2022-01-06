package Assignment1;

import java.util.*;

public class ques2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int target=scn.nextInt();
		int sum=0;
		int i=1;
		while(true) {
		if(sum>=target) {
			break;
		}
		else {
			sum+=i;
			i++;
		}
		}
		System.out.println(--i);
		
	}

}
