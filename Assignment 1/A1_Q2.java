// ---------------------------------------------------------
// Assignment 1- Question 2- 27/09/2024
// Written by: Sanjitt Kanagalingam 40313831
// For COMP 248 Section H – Fall 2024
// ---------------------------------------------------------

import java.util.Scanner;
public class A1_Q2 
{
	// This program is a string inspector that takes a sentence and a word as input, then performs various 
	// string operations like checking for substrings, replacing characters, joining strings, and finding specific 
	// character positions. Results are displayed in a formatted output.
	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		//Let's declare our Scanner object
		Scanner myObject = new Scanner(System.in);
		
		//Display welcome message for user
		System.out.println("********* String Inspector *********");
		
		//ask the the user to enter the given sentence (assume it is longer than 5 characters)
		System.out.print("Enter the given sentence (longer than 5 characters): ");
		String sentence = myObject.nextLine();
		
		//ask the user to enter the given word
		System.out.print("Enter the given word: ");
		String word = myObject.nextLine();
		
		//Ask the user to enter the separator
		System.out.print("Enter a separator to join the two strings: ");
		String separator = myObject.nextLine();
		
		//Now lets start string manipulation
		//enter blank line first
		System.out.println();
		
		//contains method to determine if the given word is contained in the sentence
		System.out.println("Given sentence contain the given word: " + sentence.contains(word));
		
		//print the startWith method for the letter i in the sentence
		System.out.println("Given sentence start with an 'i': " + sentence.startsWith("i"));
		
		//implement method to replace character "a" with "e"
		System.out.println("Sentence with 'a' replaced by 'e': " + sentence.replaceAll("a", "e"));
		
		//Implement method to concatenate the given sentence with the the separator
		System.out.println("Joined string: " + String.join(separator,sentence,word));
		
		//Find character position by using indexOf method for "a" or else return -1
		System.out.println("'a' appears at index " + sentence.indexOf("a") + " in the given sentence.");
		
		//Implement method to print the character at the 3rd position in the given sentence
		System.out.println("Character at 3rd position in the given sentence: " + sentence.charAt(2));
		
		//output closing message to the user
		System.out.print("\nThank you for using the String Inspector tool. Have a great day!");
		
		//close scanner
		myObject.close();
	}

}
