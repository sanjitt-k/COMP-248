// -------------------------------------------------------
// Assignment 3 Question 1 11/11/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// --------------------------------------------------------
import java.util.Scanner;
public class A3_Q1 {
	/**
	 * This program is meant to be an ATM machine that allows users to deposit and withdraw money
	 * The options available to the user are: checking the balance, depositing money, withdrawing money
	 * and exiting the program
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Declare the Scanner + variables
		Scanner key = new Scanner(System.in);
		int choice=1; 
		double balance = 0;  double deposit=0;
		
		//Display the welcome message
		System.out.println("Welcome to the Best Bank ATM!");
		System.out.println("---------------------------------------------------- ");
		
		//While loop for ATM menu options
		while (choice !=4) {
			//output options
			System.out.println("Please choose an option:");
			System.out.println("\t1.Check Balance");
			System.out.println("\t2.Deposit");
			System.out.println("\t3.Withdraw");
			System.out.println("\t4.Exit");
		
		//Prompt user to enter choice
			System.out.print("Enter your choice:");
			choice = key.nextInt();
			
		//Create a switch statement for the choices
		
		switch (choice) {
			case 1: 
				//Display the balance
				System.out.printf("Your balance is:$ %.2f", balance);
				break;
			
			case 2:
				//Prompt the user to enter the amount of deposit
				System.out.print("Enter amount to deposit:");
				deposit = key.nextInt();
				
				//make sure it is within the limits and a multiple of 5
				if (deposit>=5&&deposit<=10000) {
					if(deposit%5==0) {
						System.out.println("Deposit successful!");
						//Update the balance
						balance += deposit;				
					} else {
						System.out.println("Invalid, you can only deposit an amount that can be split into bills.");
					}
				}else {
					System.out.println("Invalid, you can only deposit an amount between $5 and $10000.");
					
				}
				
				break;	
				
			case 3: 
				//user input for amount of withdrawal
				System.out.print("Enter amount to withdraw (multiples of 5, 10, 50, or 100):");
				int withdraw = key.nextInt();	
				
				//Create the bills 
				int fifty = 50;
				int ten = 10;
				int five = 5;
				
				//Check if the amount being withdrawn is in the range and respects the conditions	
				if (withdraw>=5&&withdraw<=1000) {
					if (withdraw<=balance) {
						if (withdraw%5==0) {
							int amount = withdraw;
							
							//find the number for each bill						
							int billFifty = amount/fifty;
							amount%= fifty;
							
							int billTen = amount/ten;
							amount %= ten;
							
							int billFive = amount/five;
							amount %= five;
							
							//Check if amount has been properly split into bills and output the
							//number of each bill
							if (amount==0) { 
								System.out.println("You will receive:");
								if (billFifty>0)
									System.out.println("\t" + billFifty + " bill(s) of $50");
								if (billTen>0)
								System.out.println("\t" + billTen + " bill(s) of $10");
								if (billFive>0)
									System.out.println("\t" + billFive + " bill(s) of 5$");
								
								//Updated balance with new amount after withdrawal
								balance -= withdraw;
								System.out.println("Wihdrawal successful!");
							} 
						  //Display error message
						} else {
							System.out.println("Invalid withdrawal amount! You can only withdraw amounts that are multiples of 5, 10, 50,\r\n"
									+ "or 100.");
							}
						} else {
							System.out.printf("Insufficient funds, your balance is: $%.2f", balance);
							}
						} else {
							System.out.println("\nInvalid, enter an amount between $5 and $1000");
						}
				break;
				
				case 4 : 
					//Output closing message if the user decides to exit the program
					System.out.println("Goodbye!");
					break;
				
			    //default message in case no valid choice is inputed
				default : 
					System.out.println("Invalid choice! Please try again. ");
				
			}
		if (choice!=4)
		System.out.println("\n---------------------------------------------------- ");		
		
		}	
		//close scanner
		key.close();
		}
		
		
	}
		
	

