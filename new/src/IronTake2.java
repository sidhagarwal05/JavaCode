import java.util.*;
import java.util.Scanner;

public class IronTake2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		int[] ans = new int[t];
		for (int a = 0; a < t; a++) {
			String s1b = scn.next();
			String s2b = scn.next();

			int n = s1b.length();
			int index = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (s1b.charAt(i) != s2b.charAt(i)) {
					index = i;
					break;
				}
			}
			if (index == Integer.MAX_VALUE) {
				System.out.println(0);
			} else {
				s1b = s1b.substring(index);
				s2b = s2b.substring(index);
				StringBuilder s1 = new StringBuilder(s1b);
				StringBuilder s2 = new StringBuilder(s2b);
				n = s1.length();
				int flag=0;
				int count = 0;
				for (int i = 0; i < n; i = i + 2) {
					if (s1.charAt(i) != s2.charAt(i)) {
						s1.setCharAt(i, s2.charAt(i));
						if(flag==0) {
							count++;
						}
						flag=1;
					} else {
						flag=0;
					}
				}
				flag=0;
				for (int i = 1; i < n; i = i + 2) {
					if (s1.charAt(i) != s2.charAt(i)) {
						s1.setCharAt(i, s2.charAt(i));
						if(flag==0) {
							count++;
						}
						flag=1;
						
					} else {
						flag=0;
					}
				}
				System.out.print(count);
			}
		}

	}

}
