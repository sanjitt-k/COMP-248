
public class Registry {

	//Create object for Stamps and array of objects for Labels
	public Stamps stamps;
	public Label[] labels; 

	//Default constructor
	public Registry() {
		this.stamps = new Stamps();
		this.labels = null;
	}
	
	//Constructor with 2 parameters
	public Registry(Stamps stamps, Label[] labels) {
		
		//if else statements for stamps to prevent privacy leaks
		if (stamps != null) {	
			this.stamps = new Stamps(stamps);
		} else {
			this.stamps = new Stamps();
		}
		
		
		
		if (labels != null) {
			
			this.labels = new Label[labels.length];
			for (int i = 0; i <labels.length; i++) {
				if (labels[i] != null) {
					this.labels[i] = new Label(labels[i]);
				} else {
					this.labels[i] = null;
				}
			}
		} else {
			this.labels = null;
		}
		
	}
	
	//method for to compare the total value of 2 stamps in the registry
	public boolean equalsTotal(Registry otherRegistry) {
		return this.stamps.stampsTotal() == otherRegistry.stamps.stampsTotal();
	}
	
	//method to compare the number of each stamps category 
	public boolean equals(Registry other) {
		
		return this.stamps.getCategory_A() == other.stamps.getCategory_A() &&
			   this.stamps.getCategory_B() == other.stamps.getCategory_B() &&
			   this.stamps.getCategory_C() == other.stamps.getCategory_C() &&
			   this.stamps.getCategory_D() == other.stamps.getCategory_D() &&
			   this.stamps.getCategory_E() == other.stamps.getCategory_E();
	}
	
	//total $ amount of of shipment stamps of a Registry
	public int totalShipment() {
		return this.stamps.stampsTotal();
	}
	
	//finding the number of labels in the registry
	public int totalLabels() {
		if (this.labels != null) {
			return this.labels.length;
		} else {
			return 0;
		}
	}
	
	//Method to add a new Label to the registry
	public int addLabel(Label otherLabel) {
		if (this.labels == null) {
			this.labels = new Label[1];
			this.labels[0] = otherLabel;
		} else {
			//increase size of labels by 1
			Label[] newLabels = new Label[this.labels.length + 1];
			
			//for loop to copy elements from the old array
			for (int i =0; i < this.labels.length; i++) {
				newLabels[i] = this.labels[i];
			}
			
			//add new label to the array
			newLabels[this.labels.length] = otherLabel;
			
			//change array to have updated labels
			this.labels = newLabels;
		}
		//return the updated label amount
		return this.labels.length;
	}
	
	//method to remove a label of the registry
	public boolean removeLabel(Label otherLabel) {
		
		//if statement if there is no label to remove
		if (this.labels == null || this.labels.length ==0) {
			return false; 
		}
		
		int indexRemove = -1; 
		for (int i = 0; i < this.labels.length; i++) {
			if (this.labels[i].equals(otherLabel)) {
				indexRemove = i;
				break;
			}
		}
		//if the label is not found
		if (indexRemove == -1) {
			return false;
		}
		
		//Implement a new array to be able to remove the label
		Label[] newLabels = new Label[this.labels.length -1];
		for (int i =0, j=0; i < this.labels.length; i++) {
			if (i != indexRemove) {
				newLabels[j++] = this.labels[i];
			}
		}
		this.labels = newLabels; 
		return true;
		
	}
	
	//Implement method to change the expiry day and month of a label
	public boolean newExpiryDate(Label updatedLabel, int newDay, int newMonth) {
		if (this.labels!= null) {
			//update the values of the label
			for(Label l : this.labels) {
				if (l.equals(updatedLabel)) {
					l.setDay(newDay);
					l.setMonth(newMonth);
					return true;
				}
			}
		}
		return false;
	}
	
	//Implement method to add stamps to the registry
	public int addShipmentStamps(int category_A, int category_B, int category_C, int category_D, int category_E) {
		this.stamps.addStamps(category_A, category_B, category_C, category_D, category_E);
		return this.stamps.stampsTotal();
	}
	
	//implement equals method to compare the value and the total number of labels
	public boolean equals(Object otherObject) {
		if (this == otherObject)
			return true;
		if(otherObject == null || getClass() != otherObject.getClass()) 
			return false;
		
		Registry otherRegistry = (Registry) otherObject;
		return this.stamps.stampsTotal() == otherRegistry.stamps.stampsTotal() &&
				this.totalLabels() == otherRegistry.totalLabels();
	}
	
	//implement to string method 
	public String toString() {
		//the breakdown of each stamp
		String result = "Stamps Breakdown:\n";
		result += stamps.toString() + "\n";
		result += "Labels:\n";
		
		//now for the label details
		if(labels != null && labels.length > 0) {
			for (Label label : labels) {
				result += label.toString() + "\n";
			}
		} else {
			//if there a no prepaid labels
			result += "No prepaid labels\n";
		}
		return result; 
	}
	//return the the toString
	public String getStampsBreakdown() {
		return stamps.toString();
	}
}
