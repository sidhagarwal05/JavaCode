package Assignment1;

public class QuesIV {

	public static void main(String[] args) {
		 
		 int mat1[][] = {{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9}};
		 int mat2[][] = {{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9},{1,2,3,4,5,6,7,8,9,10},{4,5,6,7,8,9,8,9,8,9}};
			int res[][] = new int[mat1.length][mat1[0].length];
	        for (int i = 0; i < 10; i++) {
	            for (int j = 0; j < 10; j++) {
	                res[i][j] = 0;
	                for (int k = 0; k < 10; k++)
	                    res[i][j] += mat1[i][k]
	                                 * mat2[k][j];
	            }
	        }
	        
	        for(int i=0;i<mat1.length;i++) {
				for(int j=0;j<mat1[0].length;j++) {
					System.out.print(res[i][j]+" ");
				}
				System.out.println("");
			}
	}

}