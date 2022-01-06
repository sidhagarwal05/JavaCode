import java.util.*;
public class pratice {

	public static void main(String[] args) {
		 int a[][] = {{4, 5, 3, 2},
                      {2, 10, 1, 4}};
		 
     int t[][] = {{0, 7, 4, 5},
                 {0, 9, 2, 8}};
     int[] dp = new int[a[0].length];
     dp[3]= Math.min(a[0][3], a[1][3]);
     int line;
     if(dp[3]==a[0][3]) {
    	 line=0;
     }
     else {
    	 line=1;
     }
     for(int i=2;i>=0;i--) {
    	 int first;
    	 int second;
    
    	 if(line==0) {
    		 first=a[0][i];
    		 second=a[1][i]+t[1][i+1];
    	 }
    	 else {
    		 first=a[0][i]+t[0][i+1];
    		 second=a[1][i];
    	 }	
    	 
    	 if(first<second) {
    		 line=0;
    		 dp[i]= first+ dp[i+1];
    	 }
    	 else {
    		 line=1;
    		 dp[i]= second + dp[i+1];
    	 
    	
     }
    	 }
     System.out.println(dp[0]);
	}
}
