import java.util.Arrays;
import java.util.Scanner;

public class price {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] bill = new int[n];
		for (int i = 0; i < n; i++) {
			int input = scn.nextInt();
			bill[i] = input;
			
		}
		Arrays.sort(bill); 
		int pair=0;
		int i=0;
		int j=0;
		int count=0;
		while(i<n) {
			j=i;
			while(j<n&&bill[j]==bill[i]) {
				pair++;
				j++;
				System.out.println(bill[i]+ " "+ pair);
				if(pair==2) {
					
					pair=0;
					count++;
				}
				
			}
			pair=0;
			i=j;
			
		}
		System.out.print(count);
		
	}

}
