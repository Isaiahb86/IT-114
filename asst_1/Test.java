import java.util.List;
//===================================================  
// Name       :  Tsagan Garyaeva
// SID        :  31483539
// Course     :  IT-114 
// Section    :  452
// Instructor :  Maura Deek
// T.A        :   
//===================================================  
//===================================================  
// Assignment # :  1 
// Date         :  02/14/2019
//===================================================  
//===================================================  
// Description : This program will get user's input of
// FitBit device and store it as object's properties  
// using the Singleton pattern.  
//===================================================  
public class Test {
// Test class has main method to run the program
	public static void main(String[] args) {
      // Create a new instance
		MemberManager itemManagerService = new MemberManagerImplement();
        List<Member> newlistOfMembers = itemManagerService.createListOfMembers();
         // Get the only object available and add it to the list 
        Club.getInstance().addMembers(newlistOfMembers);
        // Print to the screen
        System.out.println(Club.getInstance().printListOfMembers());
    }

	}