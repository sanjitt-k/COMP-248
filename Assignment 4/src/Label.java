// -------------------------------------------------------
// Assignment 4 -  Class: Label-  04/12/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// --------------------------------------------------------

public class Label {
 
	//Create class attributes
	private String type;
	private int iD;
	private int day;
	private int month;
	
	//implement default constructor method
	public Label () {
		this.type = "";
		this.iD = 0;
		this.day = 0;
		this.month = 0;
		
	}
	
	//implement constructor with parameters
	public Label (String type, int iD, int day, int month) {
		this.type = type;
		this.iD = iD;
		
		//Check the if the date is between 1 and 31 if not set to 0
		if (day>=1 && day <= 31) {
			this.day = day;
		} else {
			this.day = 0;
		}
		
		//check if the month is between 1 and 12 if not set to 0
		if (month >=1 && month <=12) {
			this.month = month;
		} else {
			this.month = 0;
		}
		
	}
	
	//Implement copy constructor
	public Label(Label otherLabel) {
		this.type = otherLabel.type;
		this.iD = otherLabel.iD;
		this.day = otherLabel.day;
		this.month = otherLabel.month;
	}
	
	//Accessor methods starting with getters
	public String getType() { 
		return type; 
		}
	
	public int getID() {
		return iD;
	}
	
	public int getDay() {
		return day;
	}
	
	public int getMonth() {
		return month;
	}
	
	//Now we add the setters
	public void setType(String type) {
		this.type = type;
	}
	//make sure the id starts with 98
	public void setID(int iD) {
		if(iD >= 98000000 && iD < 99000000) {
			this.iD = iD;
		} else {
			this.iD = 0;
		}
		
	}
	
	//Mutator to make sure day is between 1 and 31
	public void setDay(int day) {
		if (day >= 1 && day <= 31) {
			this.day = day;
		} else {
			this.day = 0;
		}
	}
	
	//Mutator for month  to make sure it is between 1 and 12
	public void setMonth(int month) {
		if (month >= 1 && month <=12) {
			this.month = month;
		} else {
			this.month = 0;
		}
	}
	
	//Create ToString method 
	 public String toString() {
		 
		 //initalize day and month as a string
		 String dayString = "" + day;
		 String monthString = "" + month;
		 
		 //add the 0 before if it is a single digit
		 if (day <10) {
			 dayString = "0" + day;
		 }
		 
		 if (month < 10) {
			 monthString = "0" + month;
		 }
		 
		return "Parcel type: " + type + ", Unit iD: " + iD + ", Expiry date: " + dayString + "/" + monthString;

	 }
	 

	 //Equals method to compare two objects of type label
	 
	 public boolean equals(Object otherLabel) {
		 //if the other label is the same return true or else false
		 if (this == otherLabel) return true;
		 if (otherLabel == null || getClass() != otherLabel.getClass())
			 return false;
		 Label other = (Label) otherLabel;
		 return this.type.equals(other.getType()) &&
				this.iD == other.getID() &&
				this.day == other.getDay() &&
				this.month == other.getMonth();
	 }
	 
}
