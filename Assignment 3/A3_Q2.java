// -------------------------------------------------------
// Assignment 3 Question 2 09/11/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// --------------------------------------------------------
import java.util.Scanner;
public class A3_Q2 {
	/**
	 * This program is an Inventory Management System for managing information about products.
	 * It allows the user to enter details of 5 products, display the information of all products,
	 * update the quantity of a product, search a product by name, find the product with the lowest 
	 * price,find the product with the highest price and exit the system. The program
	 * uses arrays to the the names prices and quantities of the products
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare scanner
		Scanner keyboard = new Scanner(System.in);
		
		
		//Create array for product names
		String [] product = {"Product1", "Product2", "Product3", "Product4", "Product5"};
		
		//Array for prices
		double [] price = {0.0, 0.0, 0.0, 0.0, 0.0};
		
		//Array for quantity in stock
		int [] quantity = {0, 0, 0, 0, 0};
		
		//Display welcome message to the user
		System.out.println("Welcome to Inventory Management System");
		System.out.println("Enter details for 5 products (price, quantity, name):");
		
		//Create a for loop for user to input information of all 5 products
		for (int count=1; count <=5; count++) {
			System.out.println("Product "+ count);
			System.out.println("Enter product details (price, quantity, name):");
			price[count-1] = keyboard.nextDouble();
			quantity[count-1] = keyboard.nextInt();
			product[count-1] = keyboard.nextLine();
		}
		//Initialize choice
		int choice =0;
		
		//Create a while loop for the Inventory Management Menu
		while (choice !=6) {
			System.out.println("\nInventory Management Menu:");
			System.out.println("\t1.Display information of all products");
			System.out.println("\t2.Update the quantity of a product");
			System.out.println("\t3.Search for a product by name");
			System.out.println ("\t4.Find the product with the lowest quantity");
			System.out.println("\t5.Find the product with the highest price");
			System.out.println("\t6.Exit");
			
			//Prompt user to enter choice
			System.out.print("Enter your choice:");
			choice = keyboard.nextInt();
			
			//Create switch for all 6 choices
			switch(choice) {
			
				//first case where it displays a list of all the products and their information
				case 1:
					
					//for loop that will display the information of the first index then got to the next
					for (int j=1; j<=5; j++) {
						System.out.println("Product List:");
						System.out.println("\tProduct " + j + ":");
						System.out.println("\tName:" + product[j-1]);
						System.out.println("\tPrice:$" + price[j-1]);
						System.out.println("\tQuantity:" + quantity[j-1]);
						System.out.println("---------------------------");
					}
					break;
					
					//Changing the quantity of the product
				case 2 :
					
					//prompt the user to select the product
					System.out.print("Enter the product number (1-5) to update quantity:");
					int productNumber = keyboard.nextInt();
					
					//prompt user to enter new quantity
					System.out.print("Enter new quantity for " + product[productNumber-1] + ":");
					int newQuantity = keyboard.nextInt();
					
					//update new quantity
					quantity[productNumber-1] = newQuantity;
					
					//Output the successful message
					System.out.println("Quantity updated successfully!");
					break;
					
				//Searching for a product by name
				case 3: 
					
					//prompt user to enter product name
					System.out.println("Enter the name of the product to search for:");
					keyboard.nextLine();
					String nameProduct = keyboard.nextLine();
					nameProduct = (" " + nameProduct);
					
					//create a for loop that will go through all the options stored in the product array
					//and print the information of the product if it is found
					for (int i =0; i<5; i++) {
						if (nameProduct.equalsIgnoreCase(product[i])) {
							System.out.println("\nProduct Found:");
							System.out.println("\tName:" + product[i]);
							System.out.println("\tPrice:$" + price[i]);
							System.out.println("\tQuantity:" + quantity[i]);
							break;
						}
					}
					break;
					
					//Finding the product with the lowest quantity
				case 4: 
					
					//Create starting value for the lowest quantity starting at the first index of the array
					int quantityIndex = 0;
					
					//For loop to find the lowest quantity in the array
					for (int k=1; k<5; k++) {
						if (quantity[k] < quantity[quantityIndex]) {
							quantityIndex =k;
						}
					}
					//output the information of the product with the lowest quantity
					System.out.println("\nProduct with the Lowest Quantity:");
					System.out.println("\tName:" + product[quantityIndex]);
					System.out.println("\tPrice:$" + price[quantityIndex]);
					System.out.println("\tQuantity:" + quantity[quantityIndex]);
					break;
					
					//Finding the product with the highest price
				case 5:
					
					//Starting index for price
					int priceIndex = 0;
					
					//For loop to find the highest price value in the array
					for (int h=1; h<5; h++) {
						if (price[h] > price[priceIndex]) { 
							 priceIndex = h;
						}
					}
					//out the information of the product with highest price on the console
					System.out.println("\nProduct with the Highest Price:");
					System.out.println("\tName:" + product[priceIndex]);
					System.out.println("\tPrice:$" + price[priceIndex]);
					System.out.println("\tQuatnity:" + quantity[priceIndex]);
					break;
					
					//end message
				case 6:
					
					//output final goodbye message
					System.out.println("Goodbye!");
					break;
			}
		}
		keyboard.close();
	}

}
