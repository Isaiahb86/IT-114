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


public class Member {
   //Fields 
	private String name;
	private int cal, dis, floors, steps, rate;
	
	// Constructor 
	public Member(String name, int cal, int dis, int floors, int steps, int rate) {
		super();
		this.name = name;
		this.cal = cal;
		this.dis = dis;
		this.floors = floors;
		this.steps = steps;
		this.rate = rate;
	}

   // Getter and setters of all the fields
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCal() {
		return cal;
	}


	public void setCal(int cal) {
		this.cal = cal;
	}


	public int getDis() {
		return dis;
	}


	public void setDis(int dis) {
		this.dis = dis;
	}


	public int getFloors() {
		return floors;
	}


	public void setFloors(int floors) {
		this.floors = floors;
	}


	public int getSteps() {
		return steps;
	}


	public void setSteps(int steps) {
		this.steps = steps;
	}


	public int getRate() {
		return rate;
	}


	public void setRate(int rate) {
		this.rate = rate;
	}
}
