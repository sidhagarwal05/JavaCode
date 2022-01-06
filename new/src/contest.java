import java.util.Scanner;

public class contest {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int test= scn.nextInt();
		int ans[] = new int[test];
		for(int t=0;t<test;t++) {
			int n=scn.nextInt();
			int[] arr= new int[n];
			for(int i=0;i<n;i++) {
				arr[i]=scn.nextInt();
			}
			int count=-1;
			int loop=0;
			for(int i=n-1;i>=0;i--) {
				loop++;
				if(arr[i]==1) {
					break;
				}
			} 
			int loop1=0;
			for(int i=0;i<n;i++) {
				loop1++;
				if(arr[i]==1) {
					break;
				}
			}
			loop=loop-1;
			
			for(int i=loop1;i<n-loop;i++) {
				
					if(arr[i]==0) {
						count++;
					}
				
			}
			ans[t]=count+1;
			
		}
		for(int i=0;i<test;i++) {
			System.out.println(ans[i]);
		}

	}

}
