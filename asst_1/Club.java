import java.util.*;
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

public class Club {
   // create an object
	private static final Club INSTANCE = new Club();
   // List to store objects
	private List<Member> listOfMembers = new ArrayList<>();
	// Private constructor to prevent from direct instantiation
	private Club() {}
	

	
	// Get the only object available
	public static Club getInstance() {
		return INSTANCE;
	}
   //Add new members to the list
	public void addMembers(List<Member>newListOfmembers) {
		listOfMembers.addAll(newListOfmembers);
			}
	
	// print all members 
	public String printListOfMembers() {
		StringBuilder sb = new StringBuilder();
		for (Member mem : listOfMembers) {
			sb.append("\nFull Name: " + mem.getName()+
					"\nCalories Consumed: " + mem.getCal()+
					"\nDistance walked: " + mem.getDis()+
					"\nFloors climbed: " + mem.getFloors()+
					"\nSteps taken: " + mem.getSteps()+
					"\nAverage Heart Rate: " + mem.getRate()+
					"\n*******************************************" +
					"\n*******************************************"
					);
		}
		return sb.toString();
	}
}
