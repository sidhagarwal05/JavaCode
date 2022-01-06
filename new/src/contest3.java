import java.util.Arrays;
import java.util.Scanner;

public class contest3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int m = scn.nextInt();
		int k = scn.nextInt();
		int sum=0;
		for(int t=0;t<n;t++) {
			int maxnum=m/2;
			int arr[]=new int[m];
			for(int i=0;i<m;i++) {
				arr[i]=scn.nextInt();
			}
			Arrays.sort(arr);
			for(int i=m-1;i>=m-maxnum;i--) {
				sum=sum+arr[i];
			}
			
		}
			sum=sum-(sum%k);
			System.out.println(sum);

	}

}
