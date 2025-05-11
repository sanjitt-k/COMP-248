// -------------------------------------------------------
// Assignment 4 -  Class:Stamps-  04/12/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// --------------------------------------------------------

//This program will serve as a integrated courier service for montreal universities.

public class Stamps {

	//Declare the stamp categories
	private int category_A;
	private int category_B;
	private int category_C;
	private int category_D;
	private int category_E;
	
	//Static constant for each stamp category
	public static final int CATEGORY_A_VALUE = 2; 
    public static final int CATEGORY_B_VALUE = 5; 
    public static final int CATEGORY_C_VALUE = 10;
    public static final int CATEGORY_D_VALUE = 15;
    public static final int CATEGORY_E_VALUE = 20;
    
    //Implement default constructor
	public Stamps() {
		
		this.category_A = 0;
		this.category_B = 0;
		this.category_C = 0;
		this.category_D = 0;
		this.category_E = 0;
	}
	public Stamps(int category_A, int category_B, int category_C, int category_D, int category_E) {
		
		this.category_A = category_A;
		this.category_B = category_B;
		this.category_C = category_C;
		this.category_D = category_D;
		this.category_E = category_E;
	}
	
	//Implement copy constructor
	public Stamps(Stamps otherStamps) {
		
		this.category_A = otherStamps.category_A;
		this.category_B = otherStamps.category_B;
		this.category_C = otherStamps.category_C;
		this.category_D = otherStamps.category_D;
		this.category_E = otherStamps.category_E;
	}
	
	//Implement getter
	public int getCategory_A() {
	    return category_A;
	 }

	public int getCategory_B() {
	    return category_B;
	 }

	public int getCategory_C() {
	    return category_C;
	 }

	public int getCategory_D() {
	    return category_D;
	 }

	 public int getCategory_E() {
	    return category_E;
	 }
	    
	//implement settters
	    public void setCategory_A(int category_A) {
	        this.category_A = category_A;
	    }

	    public void setCategory_B(int category_B) {
	        this.category_B = category_B;
	    }

	    public void setCategory_C(int category_C) {
	        this.category_C = category_C;
	    }

	    public void setCategory_D(int category_D) {
	        this.category_D = category_D;
	    }

	    public void setCategory_E(int category_E) {
	        this.category_E = category_E;
	    }    
	
	//create addStamps() method
	public void addStamps(int category_A, int category_B, int category_C, int category_D, int category_E ) {
		this.category_A += category_A;
		this.category_B += category_B;
		this.category_C += category_C;
		this.category_D += category_D;
		this.category_E += category_E;
	}
	
	//stampsTotal method for the total shipment value
	public int stampsTotal() {
		return (this.category_A * CATEGORY_A_VALUE) +
	           (this.category_B * CATEGORY_B_VALUE) +
	           (this.category_C * CATEGORY_C_VALUE) +
	           (this.category_D * CATEGORY_D_VALUE) +
	           (this.category_E * CATEGORY_E_VALUE);
	}
	
	//To string to return a string with all the stamps
	public String toString() {
	return this.category_A + " x $2 +" +
		   this.category_B + " x $5 +" +
		   this.category_C + " x $10 +" +
		   this.category_D + " x $15 +" +
		   this.category_E + " x $20 ";
	}
	
	//equal method that compares the breakdown of stamps 
	public boolean equals(Stamps otherStamps) {
		
		return this.category_A == otherStamps.category_A &&
			   this.category_B == otherStamps.category_B &&
			   this.category_C == otherStamps.category_C &&
			   this.category_D == otherStamps.category_D &&
			   this.category_E == otherStamps.category_E;
	}
		
		
	
}

