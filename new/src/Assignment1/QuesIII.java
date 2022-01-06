package Assignment1;

public class QuesIII {

	public static void main(String[] args) {
		int mat1[][] = {{1,2,3,4,5},{4,5,6,7,8}};
		int mat2[][] = {{10,20,30,40,50},{40,50,60,70,80}};
		int res[][] = new int[mat1.length][mat1[0].length];
		System.out.println("Sum");
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[0].length;j++) {
				res[i][j]=mat1[i][j]+mat2[i][j];
				System.out.print(res[i][j]+" ");
			}
			System.out.println("");
		}
		System.out.println("Difference");
		for(int i=0;i<mat1.length;i++) {
			for(int j=0;j<mat1[0].length;j++) {
				res[i][j]=mat1[i][j]-mat2[i][j];
				System.out.print(res[i][j]+" ");
			}
			System.out.println("");
		}

	}

}
