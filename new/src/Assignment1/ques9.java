package Assignment1;

import java.util.*;

public class ques9 {

	public static void main(String[] args) {
		HashMap<Integer, Boolean> mp = new HashMap<>();
		int[] arr= {1,2,3,9,3,4,5,4};
		int n=arr.length;	
		for (int i = 0; i < n;i++) {
			if (mp.get(arr[i]) == null) {
				mp.put(arr[i], true);
				}
			else {
				for(int j=i;j<n-1;j++) {
					arr[n-1]=0;
					arr[j]=arr[j+1];
				}
			}
		}
		for(int i=0;i<n;i++) {
			System.out.println(arr[i]);
		}
	}

}
