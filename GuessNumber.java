package com.test.vendor;
import java.util.Random;
import java.util.Scanner;
/*This program guesses the number chosen by user.
 *Range to guess the number is from 1-100*/
public class GuessNumber {
	
	public static String userInput = "";
	public static Scanner in = new Scanner(System.in);
	public static Random rand = new Random();
	public static int tempNum = 0;
	public static int upperLimit = 100;
	public static int lowerLimit = 1;

	//This method validates the user input.
	//It accepts only higher,lower or yes as the inputs without case-sensitivity. 
	
	public static boolean validateUserinput(String input) {
		boolean goAhead=false;
		if (input.equalsIgnoreCase("lower") || input.equalsIgnoreCase("higher")
				|| input.equalsIgnoreCase("Yes")) {			
			goAhead = true;
		} else {
			System.out.println("Enter Valid user input like higher or lower or Yes...");
			userInput = in.nextLine();
		}
		return goAhead;
	}
	
	//main method 
	public static void main(String[] args) {
	    
	    do {
	    	//This try/catch block keeps generating the random number
	        try{
	        	tempNum = rand.nextInt(upperLimit - lowerLimit + 1) + lowerLimit;
	        	//Accepts user input from the console        
		        System.out.println("your number is " + tempNum);
	        }
	        catch(Exception e){System.out.println("Proper input not provided.. Please run again");
	        System.exit(1);
	        //break;
	        }
	    	
	        userInput = in.nextLine();
	        
	        //This if loop and elseif loop keep setting the upper and lower limit while making a guess in every iteration.
	        if(validateUserinput(userInput)==true){

		        if(userInput.equalsIgnoreCase("Lower")) {
		            lowerLimit = tempNum + 1;
		            System.out.println("The lowerLimit is set to: " + lowerLimit);
		        }
		        else if(userInput.equalsIgnoreCase("Higher")) { 
		            upperLimit = tempNum - 1;
		            System.out.println("The upperLimit is set to: " + upperLimit);
		        }	        
	        }
	    
	    }while(!userInput.equalsIgnoreCase("yes"));
	    //Close the input after the correct number is guessed.
	    in.close();
	    System.out.println("Your number is --" + userInput);
	}
}
