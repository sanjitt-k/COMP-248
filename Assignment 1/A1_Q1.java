// ---------------------------------------------------------
// Assignment 1- Question 1- 27/09/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;
public class A1_Q1 
{
	//This program will serve as a solar roof energy calculator using inputs given by the user to calculate the daily 
	//and annual energy production for solar panels
	public static void main(String[] args)
	{
		//Let's declare our scanner
		Scanner myKeyboard = new Scanner(System.in);
		
		//Displays a Welcome Message to the user of the program
		System.out.println("*********Solar Roof Energy Calculator*********");
		
		//Variable Declaration of int
		int numPanels, panelWattage; 
		
		//Variable declaration of double
		double sunlightHours, efficiency;
		
		//let's ask the user for some input on the number of solar panels
		System.out.print("Enter the number of Solar pannels: ");
		numPanels = myKeyboard.nextInt();
		
		//User input for wattage rating for each solar panel
		System.out.print("Enter the wattage rating of each solar pannel (in watts): ");
		panelWattage = myKeyboard.nextInt();
		
		//Ask the user to input the average number of sunlight hours per day
		System.out.print("Enter the average number of sunlight hours per day: ");
		sunlightHours = myKeyboard.nextDouble();
		
		//Ask the user to enter the efficiency of the solar panels as a percentage
		System.out.print("Enter the efficiency of the solar pannels (as a percentage): ");
		efficiency = myKeyboard.nextDouble();
		
	
		//Calculate daily energy production in kWh using the formula
		double dailyEnergy = numPanels * panelWattage * sunlightHours * efficiency/(1000*100);
		
		//Calculate the annual energy production in kWh
		double annualEnergy = dailyEnergy * 365;
		
	    //output code for the daily and annual energy in kWh
		System.out.printf("\nDaily Energy Production: %.4f kwh\n", dailyEnergy);
		System.out.printf("Annual Energy Produtction: %.4f kWh\n", annualEnergy);
		
		//Goodbye message
		System.out.println("Thank you for using the Solar Roof Energy Calculator!");
		
		//close Scanner
		myKeyboard.close();
	}

}
