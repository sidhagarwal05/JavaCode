import java.util.*;

public class score {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n= scn.nextInt();
		int k= scn.nextInt();
		int count=0;
		int[] nums=new int[n];
		for(int i=0;i<n;i++) {
			int m = scn.nextInt();
			nums[i]=m;
		}
		for(int i=0;i<n;i++) {
			for(int j=i+1;j<n;j++) {
				if((nums[i]+nums[j])%k==0) {
					count++;
				}
			}
		}
		System.out.println(count);
		
		
		

	}

}
