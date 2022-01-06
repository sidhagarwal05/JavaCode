import java.util.*;

public class Assignment {

	public static void main(String[] args) {
		int arr[] = { 1, 2,3,5,4 };
		int n = arr.length;
		int i = n - 1;
		
		for (; i >= 1; i--) {
			if (arr[i - 1] < arr[i]) {
				break;
			}
		}
		int temp = arr[i - 1];
		arr[i - 1] = arr[n - 1];
		arr[n - 1] = temp;
		int low = i;
		int high = n - 1;
		while (low < high) {
			temp = arr[low];
			arr[low] = arr[high];
			arr[high] = temp;
			high--;
			low++;
		}
		for(int k=0;k<n;k++) {
			System.out.print(arr[k]+" ");
		}
	}

}
