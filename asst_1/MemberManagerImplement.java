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


import java.util.*;

public class MemberManagerImplement implements MemberManager {

	@Override
	public List<Member> createListOfMembers() {
		// Create a new list 
		List<Member> newListOfMembers = new ArrayList<>();
      // All the scanner objects to handle user's input
		Scanner scanner1 = new Scanner(System.in);
		Scanner scanner2 = new Scanner(System.in);
		Scanner input = new Scanner(System.in);
                try {
                	// do while loop starts	
						do {
                		System.out.println("Please enter a full name: ");
                		String name = scanner1.nextLine();
            
                    System.out.println("Please enter the following data->");
                    System.out.println("calories consumed, "
                    		+ "\ndistance walked, "
                    		+ "\nnumber of floors climbed, "
                    		+ "\nnumber of steps taken,"
                    		+ "\naverage heart rate :");
               // create an array to store data from above
					int[]data = new int[5];
					// for loop to get user's input to fill the empty 
               // data array
					for(int i=0; i< data.length; i++) {
						data[i] = scanner2.nextInt();
					}
                // Instantiate a new Member object and fill it with 
                // user's input   
					 Member item = new Member(name, data[0], data[1], data[2], data[3], data[4]);
                // Add created user to the list
					 newListOfMembers.add(item);
					 // ask user for the next step
					 System.out.println("Would you like to add a new member?(yes/no)");
					      // If yes go to the next iteration of while loop
                     // If no, return the list 
                		}while(input.nextLine().equalsIgnoreCase("y"));
                } finally {
                // Close all scanners
                	scanner1.close();
                	scanner2.close();
                	input.close();
                	
                }
		
            System.out.println("All Members of the Club -->");
            // return the list
            return newListOfMembers;
	
	}
}
