import java.util.*;

public class challenge3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);

		int size = scn.nextInt();
		int[] arr = new int[size];
		takeInput(arr, scn);
		sort(arr);
		Output(arr);
	}

	public static void takeInput(int[] arr, Scanner scn) {

		for (int i = 0; i < arr.length; i++) {
			int value = scn.nextInt();
			arr[i] = value;
		}
	}
	public static void Output(int[] arr) {

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	

    static void sort(int arr[])
    {
        int n = arr.length;
 
        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;
 
            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
