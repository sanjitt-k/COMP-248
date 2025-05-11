// ---------------------------------------------------------
// Assignment 2- Question 2- 21/10/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;
public class A2_Q2 {
	//The purpose of this program is to guide users through the process of buying 
	//CAD using foreign currency or sell CAD for another currency
	public static void main(String[] args) {
		// Let's declare our scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Declare the variables and intialize 
		double money = 0.0;
		double cad = 0.0 ;
		
		//Declare the string
		String currency;
		
		//Display the title 
		System.out.println("****************************************************************************************");
		System.out.println(" 	         	    Montreal Currency Exchange Shop!");
		System.out.println("****************************************************************************************");
		
		//Display Welcome message to the user
		System.out.println("\nWelcome to the Montreal Currency Exchange Shop!");
		
		//Ask if the user wants buy or sell currency
		System.out.print("Do you want to buy foreign currency (B) or sell foreign currency (S)? ");
		String user = keyboard.next();
		
		//if the user wants to Sell
		if (user.equalsIgnoreCase("s")) {
			System.out.print("Enter the CAD amount you would like to receive: ");
			cad = keyboard.nextDouble();
		
		//Prompt the seller to enter the target currency
		System.out.print("Enter the target currency to sell (USD, EUR, GBP, JPY, AUD): ");
		currency = keyboard.next().toUpperCase();

		//construct switch statement for the currency(sell)
		switch(currency) {
			case "USD":
				money = cad/1.30;
				break;
			case "EUR": 
				money = cad/1.55;
				break;
			case "GBP": 
				money = cad/1.80;
				break;
			case "JPY": 
				money = cad/0.012;
				break;
			case "AUD": 
				money = cad/1.00;
			}
		
		//Output the amount of currency needed sell to acquire the desired Canadian amount
		System.out.printf("You will need to spend %.2f %s to receive %.2f CAD",money, currency, cad);	
		}
		
		//Now if the user wants to buy foreign currency
		if (user.equalsIgnoreCase("b")) {
			System.out.print("Enter the currency you want to buy (USD, EUR, GBP, JPY, AUD): ");
			currency = keyboard.next().toUpperCase();
		
		//User input for foreign currency that is desired to be bought
			System.out.print("Enter the amount of " + currency + " you want to buy: ");
			money = keyboard.nextDouble();
		
		//Now lets the create the buy switch statement
		switch (currency) {
			case "USD":
				cad = money*1.25;
				break;
			case "EUR":
				cad = money*1.50;
				break;
			case "GBP":
				cad = money*1.75;
				break;
			case "JPY":
				cad = money*0.01;
				break;
			case "AUD":
				cad = money*0.95;
				break;
			}
		
		//Output the amount of cad needed in order to buy the foreign currency
		System.out.printf("You will need to spend %.2f CAD to receive %.2f %s", cad, money, currency);
		}
		
		//Now let's print the closing message on the console
		System.out.print("\nThank you for visiting!");
		
		//close the scanner 
		keyboard.close();
	}
	
}

		
		
	


