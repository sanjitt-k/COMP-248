// ---------------------------------------------------------
// Assignment 2- Question 1- 21/10/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;
public class A2_Q1 
{
	//This program will serve as a fall adventure planner by asking the user
	//to input information concerning the weather, temperature to 
	//and give tips to the user depending on the input of the user
	public static void main(String[] args) 
	{
		// Let's declare our Scanner
		Scanner keyboard = new Scanner(System.in);
		
		//Let's declare our variables
		int temperature;
		
		//Name of program
		System.out.println("###########################################################################");
		System.out.println("		         Fall Adventure Planner!!!");
		System.out.println("###########################################################################");
		
		//Display Welcome message to the user
		System.out.println("\nWelcome to the Fall Adventure Planner!");
		
		//Prompt the user to enter the temperature in degree Celsius
		System.out.print("Enter the current temperature (°C): ");
		temperature = keyboard.nextInt();
		
		//Prompt the user to enter the weather condition
		System.out.print("Enter the weather condition (sunny/rainy/snowy): ");
		String weather = keyboard.next().toLowerCase();
		
		//Assign empty String for clothing recommendation and safety tip 
		String recommendation = "";
		String tip = "";
		
		//if else statement for clothing
		if (weather.equals("snowy")) {
			recommendation = "Heavy winter clothing.";
	    } 
		else if (weather.equals("rainy")) {
			recommendation = "Waterproof clothing.";
	    }
		else if (weather.equals("sunny"))
		{
		  if (temperature > 20) {
			  recommendation = "Light clothing (t-shirt and shorts).";
		  } 
		  else if (temperature >= 10 && temperature <= 20) {
			  recommendation = "A light jacket.";
		  } 
		  else if (temperature < 10) {
			  recommendation = "Warm clothing (a sweater and a coat).";
		  }
	    }
		//if else statements for safety precautions
		if (weather.equals("sunny")) {
			tip = "Don’t forget sunscreen and stay hydrated!";
		}
		else if (weather.equals("rainy")) {
			tip = "Be cautious of slippery paths!";
		}
		else if (weather.equals("snowy")) {
			tip = "Stay warm and watch out for icy conditions!";
		}
		 
		//Output the clothing recommendation on the console
		System.out.println("\nRecommended clothing: " + recommendation);
		
		//Display the safety tip on the console
		System.out.println("Safety tip: " + tip);
	
		//Display closing message on the console
		System.out.println("Thank you for using the Fall Adventure Planner!");
		
		//Close scanner
		keyboard.close();
	}

}
