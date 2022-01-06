import java.util.Scanner;

public class test {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int a = 0;
		int b = 1;
		int c = 0;
		if (n == 0) {
			System.out.println(a);
		} else if (n == 1) {
			System.out.println(a);
			System.out.println(b);
		}

		else {
			System.out.println(a);
			System.out.println(b);
			for (int i = 2; i <= n; i++) {
				c = a + b;
				System.out.println(c);
				a = b;
				b = c;
			}
		}
	}

}
