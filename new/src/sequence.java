import java.util.*;

public class sequence {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		ArrayList<Integer> ans= new ArrayList<Integer>();
		for (int f = 0; f < t; f++) {
			int n = scn.nextInt();
			int[] b = new int[n];
			for (int i = 0; i < n; i++) {
				b[i] = scn.nextInt();
			}
			int[] a = new int[n];

			a[0] = 2;
			int k=2;
			for(int i=0;i<n;i++) {
				a[i]=k;
				k=k+1;
				for(int j=2;j<k;j++) {
					if(k%j==0) {
						k=k+1;
						j=2;
					}
				}
				
			}
			for(int i=0;i<n;i++) {
				if(i!=n) {
					if(b[i]-1!=i) {
						a[b[i]-1]=a[i]*a[b[i]-1];
					}
				}
			}
			for (int l = 0; l < n; l++) {
				ans.add(a[l]);
			}
			ans.add(-1);
		}
		for (int i = 0; i < ans.size(); i++) {
			if(ans.get(i)==-1) {
				System.out.println("");
			}
			else {
				System.out.print(ans.get(i)+ " ");
			}
		}
	}
}
