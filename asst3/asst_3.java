//===================================================  
// Name       :  Tsagan Garyaeva 
// SID        :  31483539  
// Course     :  IT-114  
// Section    :  452  
// Instructor :  Maura Deek 
// T.A        :   
//===================================================   
//===================================================  
// Assignment # :  3  
// Date         :  03/22/2019 
//===================================================   
//===================================================  



import java.util.Scanner;

public class asst_3 {
	
	static void weightOnBackOf(int row, int col)  
	{  
	    if (row < 0) // Base condition  
	        return;  
	  
	    // Recursive call  
	    weightOnBackOf(row - 1, col + 1);  
	    
	    int i;  
	    for (i = 0; i < col; i++) // it makes spaces  
	        System.out.printf(" ");  
	    for (i = 0; i < row; i++) // for print *  
	        System.out.print("* "); 
	         
	    System.out.printf("\n"); // for next line  
	}  
	  
	  
	
	
	
	public static void main(String[] args) {
	Scanner input =  new Scanner(System.in);
	System.out.println("How many people on bottom row? ");
	int row = input.nextInt();
	weightOnBackOf(row, 0);  
	}

}
