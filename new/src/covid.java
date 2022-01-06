import java.util.*;

public class covid {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();

		ArrayList<Integer> sol = new ArrayList<Integer>();
		for (int i = 0; i < t; i++) {

			int count = 0;
			int n = scn.nextInt();// days
			int k = scn.nextInt();// maximum
			int[] ques = new int[n];
			for (int j = 0; j < n; j++) {
				int num = scn.nextInt();
				ques[j] = num;
			}
			for (int j = 0; j < n; j++) {
				if (ques[j] < k) {
					sol.add(j + 1);

					break;
				}

				if (k <= (ques[j])) {
					ques[j] = ques[j] - k;
					count = ques[j];
					if (j < n - 1) {
						ques[j + 1] = ques[j + 1] + count;
					}
				}

			}
			if (count > k) {
				n = n + 1;
				count = count + k;

				while (count > k) {
					n++;
					count = count - k;

				}
				sol.add(n);

			}
		}

		for (int i = 0; i < sol.size(); i++) {
			System.out.println(sol.get(i));
		}

	}

}
