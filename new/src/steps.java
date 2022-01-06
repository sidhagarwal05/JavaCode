import java.util.Scanner;

public class steps {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		String[] ans = new String[n];
		for (int t = 0; t < n; t++) {
			int catA = scn.nextInt();
			int catB = scn.nextInt();
			int mouse = scn.nextInt();
			int diff1 = Math.abs(catA - mouse);
			int diff2 = Math.abs(catB - mouse);
			if (diff1 > diff2) {
				ans[t] = "Cat B";
			} else if (diff1 < diff2) {
				ans[t] = "Cat A";
			} else {
				ans[t] = "Mouse C";
			}

		}
		for (int t = 0; t < n; t++) {
			System.out.println(ans[t]);
		}
		
	}

}
