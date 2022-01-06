package RecursionDpBacktracking;

import java.util.ArrayList;

public class dp {

	public static void main(String[] args) {
		System.out.println(CountBoardPathIteratively(0, 10));

	}

	public static int fibonacci(int n, int[] storage) {
		if (n == 0) {
			return n;
		}
		if (n == 1) {
			return n;
		}
		if (storage[n] != 0) {
			return storage[n];
		}
		int n1 = fibonacci(n - 1, storage);
		int n2 = fibonacci(n - 2, storage);
		int ans = n1 + n2;
		storage[n] = ans;
		return ans;
	}

	public static int CountBoardPath(int st, int end,int[] storage) {

		if (st == end) {
			return 1;
		}
		if (st > end) {
			return 0;
		}
		if(storage[st]!=0) {
			return storage[st];
		}
		int count = 0;
		for (int i = 1; i <= 6; i++) {
			count = count + CountBoardPath(st + i, end,storage);
		}
		storage[st]=count;
		return count;

	}
	
	public static int CountBoardPathIteratively(int st,int end) {
		int[] storage=new int[end+1];
		storage[end]=1;
		
		for(int i=end-1;i>=st;i--) {
			int count=0;
			for(int dice=1;dice<=6&&dice+i<storage.length;dice++) {
				count=count+ storage[dice+i];
			}
			storage[i]=count;
		}
		return storage[st];
	}

}
