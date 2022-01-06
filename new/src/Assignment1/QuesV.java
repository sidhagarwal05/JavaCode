package Assignment1;

public class QuesV {
	 public static void main(String a[]){    
	        int[] a1= {10,20,30,50,70,90};    
	        int element = 50;    
	        System.out.println(" Index of element "+linearSearch(a1, element));    
	    }  
	public static int linearSearch(int[] arr, int element){    
        for(int i=0;i<arr.length;i++){    
            if(arr[i] == element){    
                return i;    
            }    
        }    
        return -1;    
    }    
}
