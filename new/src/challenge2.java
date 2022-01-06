import java.util.*;

public class challenge2 {
	static int inversionCount;
	static void merge_row(int[][] matrix, int r1, int r2, int c1, int c2)
	{
	    for(int i=c1;i<=c2;i++)
	    {
	        for(int j=r1;j<=r2;j++)
	        {
	            for (int k=r1;k<r2;k++)
	            {
	                if (matrix[i][k] > matrix[i][k + 1])
	                {
	                	int a = matrix[i][k];
	                	matrix[i][k]=matrix[i][k + 1];
	                	matrix[i][k + 1]=a;
	                	
	                }
	            }
	        }
	    }
	}

	

	static void print_matrix(int[][] matrix,int row,int col)
	{
	    for(int i=0;i<row;i++)
	    {
	        for(int j=0;j<col;++j)
	        	System.out.print(matrix[i][j]+" ");
	    }
	}

	static void merge_col(int[][] matrix, int r1, int r2, int c1, int c2)
	{
	    for(int i=r1;i<=r2;i++)
	    {
	        for(int j=c1;j<=c2;j++)
	        {
	        	int a=matrix[j][i];
	        	int x=j;
	            for (int k=j;k<c2+1;k++)
	            {
	                if (matrix[k][i]<a)
	                {
	                    a=matrix[k][i];
	                    x=k;
	                }
	            }
	            int abc =matrix[j][i];
	            matrix[j][i]=matrix[x][i];
	            matrix[x][i]=abc;
	        }
	    }
	}

	static void merge_sort(int[][] matrix, int r1, int r2, int c1, int c2)
	{
		int midRow=(r1+r2)/2;
	    int midCol=(c1+c2)/2;
	    if(r1>=r2)
	    {
	    	if(c1>=c2)
	    	{
	    		return;
	    	}
	    	else
	    	{
	    		merge_col(matrix,r1,r2,c1,c2);
	    	}
	    }
	    else if (c1>=c2)
	    {
	    	merge_row(matrix,r1,r2,c1,c2);
	    	return;
	    }
	    merge_sort(matrix, r1, midRow, c1, midCol);
	    merge_sort(matrix, midRow+1, r2, c1, midCol);
	    merge_sort(matrix, r1, midRow, midCol+1, c2);
	    merge_sort(matrix, midRow+1, r2, midCol+1, c2);
	    merge_row(matrix, r1, r2, c1, c2);
	    merge_col(matrix, r1, r2, c1, c2);
	}

	public static void main(String[] args) {
		 int M,N;
		 Scanner scn = new Scanner(System.in);
		 M=scn.nextInt();
		 N=scn.nextInt();
		    int[][] matrix= new int[M][N];
		 
		    for(int i=0;i<M;i++)
		    {
		        for(int j=0;j<N;j++)
		        {
		        	matrix[i][j]=scn.nextInt();
		        }
		    }
		 
		    merge_sort(matrix, 0, N-1, 0, M-1);
		    print_matrix(matrix,M,N);
	}


}

