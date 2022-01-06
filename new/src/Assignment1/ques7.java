package Assignment1;

public class ques7 {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		int max=Integer.MIN_VALUE;
		int index=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]>max) {
				index=i;
				max=arr[i];
			}
		}
		System.out.println("Index of Maximum Value"+index);

	}

}
