import java.util.*;

public class leet1 {
 
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int t= scn.nextInt();
		int[] ans = new int[t];
		int[] ans1 = new int[t];
		for(int f=0;f<t;f++) {
			int n= scn.nextInt();
			int[] arr= new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=scn.nextInt();
			}
			Arrays.sort(arr);
			if(n==1) {
				
				ans[f]=(arr[0]);
			}
			else if(n==2) {
				ans[f]=(arr[1]);
			}
			else if(n==3) {
				ans[f]=(Math.max(arr[0]+arr[1], arr[2]));
			}
			else if(n==4) {
				int s1= arr[3];
				int s2=arr[1]+ arr[2];
				if(s1>s2) {
					s2=s2+arr[0];
				}
				else
				{
					s1=s1+arr[0];
				}
				ans[f]=(Math.max(s1, s2));
			}
		}
		for(int f=0;f<t;f++) {
			System.out.println(ans1[f]);
			
		}
	}

}
