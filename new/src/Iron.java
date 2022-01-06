import java.util.*;

public class Iron {

	public static void main(String[] args) {
//		System.out.println((int)(Math.log(45)/Math.log(2)));
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for (int p = 0; p < t; p++) {
			int n = scn.nextInt();
			int k = scn.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = scn.nextInt();
			}
			int i = 0;
			int j = 1;
			int maxp1 = 0;
			int maxp2 = 0;
			while (i < n - 1 && j < n && k > 0) {
				if (arr[i] == 0 && arr[j] == 0) {
					i = i + 2;
					j = j + 2;
				} else {
					if (arr[i] == 0) {
						i = j;
						j = j + 1;
					}
					if (j < n && arr[j] == 0) {
						j = j + 1;
					}
				}
				if (i > n - 2 || j > n - 1) {
					break;
				}
				maxp1 = (int) (Math.log(arr[i]) / Math.log(2));
				maxp2 = (int) (int) (Math.log(arr[j]) / Math.log(2));
				int maxp = Math.min(maxp1, maxp2);
				arr[i] = arr[i] ^ ((int) (Math.pow(2, maxp)));
				arr[j] = arr[j] ^ ((int) (Math.pow(2, maxp)));
				k--;
			}
			if (n == 2 && k > 0) {
				maxp1 = (int) (Math.log(arr[0]) / Math.log(2));
				maxp2 = (int) (int) (Math.log(arr[1]) / Math.log(2));
				int maxp = Math.min(maxp1, maxp2);
				arr[0] = arr[0] ^ ((int) (Math.pow(2, maxp)));
				arr[1] = arr[1] ^ ((int) (Math.pow(2, maxp)));
			}
			if(k>0&&k%2!=0) {
				maxp1 = (int) (Math.log(arr[n-2]) / Math.log(2));
				maxp2 = (int) (int) (Math.log(arr[n-1]) / Math.log(2));
				int maxp = Math.min(maxp1, maxp2);
				arr[0] = arr[0] ^ ((int) (Math.pow(2, maxp)));
				arr[1] = arr[1] ^ ((int) (Math.pow(2, maxp)));
			}
		}
	}

}
