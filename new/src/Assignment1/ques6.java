package Assignment1;

import java.util.Scanner;

public class ques6 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int i=0;
		int j=arr.length-1;
		while(i<j) {
			int a=arr[i];
			arr[i]=arr[j];
			arr[j]=a;
			i++;
			j--;
		}
		for(int k=0;k<arr.length;k++) {
			System.out.print(arr[k]);
		}
	}

}
