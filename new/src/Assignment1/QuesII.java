package Assignment1;

import java.util.Scanner;

public class QuesII {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int arr[]= {1,2,3,4,5};
		int sum=0;
		int max= Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
			max=Math.max(max, arr[i]);
		}
		System.out.println("Sum: "+ sum);
		System.out.println("Maximum Element: "+ max);
		System.out.println("Enter the element to be searched: ");
		int n = scn.nextInt();
		int flag=0;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]==n) {
				System.out.println("Index of ELement:"+ i);
				flag=1;
				break;
			}
		}
		if(flag==0) {
			System.out.println("Element not found");
		}
	}

}
