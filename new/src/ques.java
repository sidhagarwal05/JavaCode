import java.util.*;

public class ques {

	public static void main(String[] args) {
//		LinkedList<Integer> a= new LinkedList<Integer>();
//		a.add(1);
//		a.add(20);
//		a.add(30);
//		a.add(40);
//		LinkedList<Integer> b= new LinkedList<Integer>();
//		b.add(1);
//		b.add(20);
//		b.add(30);
//		b.add(40);
//		b.sort(null);
//		System.out.println(a);
			int[] nums= new int[3];
			nums[0]=3;
			nums[1]=2;
			nums[2]=3;
			int target=9;
			int[] ans = twoSum(nums,target);
			for(int i=0;i<ans.length;i++) {
				System.out.print(ans[i]);
			}
	}
	   public static int[] twoSum(int[] nums, int target) {
	        int[] ans= new int[2];
	        for(int i=0;i<nums.length;i++){
	             for(int j=0;i<nums.length;i++){
	            	 System.out.print(nums[i]+ " "+ nums[j]);
	                if(nums[i]+nums[j]==target){
	                    ans[0]=i;
	                    ans[1]=j;
	                    return ans;
	                }
	        }
	        }
	        return ans;
	    }

}
