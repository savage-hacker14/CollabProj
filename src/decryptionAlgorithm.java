import java.util.*;

/**
 * This program will take in a set number choices and max capacity of the output and generate
 * all possible outcomes/possibilities for the output. 
 * @author Arjun
 * Date: 6/20/19
 */

public class decryptionAlgorithm {	//TODO - finish up the special character logic

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> outcomes = new ArrayList<String>();
		int keypadNumber;
		int maxCap;
		String specialCases;
		
		System.out.print("Any Special Characters?(Y/N): ");
		specialCases = input.next();
		System.out.print("Enter Number of Givens: ");  //less than or equal to 10 if no specials
		keypadNumber = input.nextInt();
		
		while((specialCases.equalsIgnoreCase("N")) && (keypadNumber >10)) {
			
			System.out.print("Incorrect Numbers! Try Again: ");
			keypadNumber = input.nextInt();
			
		}
		
		System.out.print("Enter Max Capacity: ");
		maxCap = input.nextInt();
				
		outcomes = solveAllOutcomes(keypadNumber, maxCap, specialCases);
		
		for(int count = 0; count < outcomes.size(); count++) {
			
			System.out.println(Integer.valueOf(outcomes.get(count)));
			
		}
		
		// Run time goes up exponentially
		// 9 givens and 35 max capacity takes over 2 min to run
		// Thankfully, this algorithm is only meant to run upto 8 characters. 
		
	}
	
	/**
	 * This method will create and return an array list of all possible combinations from the choices given and the 
	 * maximum capcaity of numbers. 
	 * 
	 * @param keyNums, max, special characters
	 * 
	 * pre: the parameters must be specified
	 * post: returns the array list of all possible outcomes
	 */
	public static ArrayList<String> solveAllOutcomes(int keyNums, int max, String specials){
		Random generator = new Random();
		ArrayList<String> answers = new ArrayList<String>();	//creates arraylist holding answers
		int[] numberChoices = new int[keyNums]; //dummy array just for the traversal process to put numbers in ArrayList
		String number;
		int total;
		
		int maxPoss = (factorial(keyNums)) / ((factorial(keyNums - max)) * (factorial(max)));
		// the maxPoss for a given set of numbers is the factorial of the numbers, thinking mathematically. 
		
		for(total = 0; total < maxPoss; total++) { //TODO - CHANGE THIS PLEB LOOP 
			
			if(specials.equalsIgnoreCase("N")) {
				
				number = "";
				number += generateRandomCombo(number, keyNums, max);	//generate random number combo
				
				answers.add(checkRepeats(number, keyNums, max, answers));
				
			} else if(specials.equalsIgnoreCase("Y")) {
				
				number = "";
				int termUse = generator.nextInt(2); //pick at random to use either '*', '#', or both
				
			}
			
		}
		
		return answers;
		
	}
	
	/**
	 * Recursively computes the value of the factorial for the number passed
	 * @param theNumber
	 * 
	 * pre: the number passed must be initialized from main or some other number must be passed. 
	 * post: returns its factorial
	 */
	public static int factorial(int theNumber) {
		if(theNumber == 0) {
			
			return 1; //if there are no more numbers to multiply, then it returns 1 to make a non zero answer
			
		} else {
			
			return theNumber * factorial(theNumber - 1);
			//calls the method again recursively to find the factorial.
			
		}
		
	}
	
	
	/**
	 * Generates the random number combination. 
	 * 
	 * @param num, keys, maximum
	 * 
	 * pre: the maximum capacity, choices given and the String must be defined and initialized.
	 * post: returns a random maxCap number. 
	 */
	public static String generateRandomCombo(String num, int keys, int maximum) {
		Random generator = new Random();
		
		int maxx = (int)Math.pow(10, maximum);
		String rand = String.valueOf(generator.nextInt(maxx));
		
		while(rand.length() < maximum) {
			
			rand = String.valueOf(generator.nextInt(maxx));
			
			//As long as the number generated has lesser digits than the max digits given, 
			//the loop keeps going. 
		}
		
		num += rand;		
		return num;
		
	}

	/**
	 * Checks if the randomly generated number is repeated anywhere in the array list. If it is, it regenerates a new 
	 * number until the number generated is never repeated in the array list.
	 * 
	 * @param theNum, the Choices, theMax, theAnswers
	 * 
	 * pre: The array list must be defined and initialized
	 * post: returns a newly generated random number within the bounds specified
	 */
	public static String checkRepeats(String theNum, int theChoices, int theMax, ArrayList<String> theAnswers) {
		int index = 0;
		int numberCon = Integer.valueOf(theNum);
		
		while(index < theAnswers.size()) {
			
			if(numberCon == (Integer.valueOf(theAnswers.get(index)))){
				
				//traverses through the array list to see if there are any repeats. If there are, then it redoes the 
				//random generation and begins from the top again
				
				theNum = "";
				theNum += generateRandomCombo(theNum, theChoices, theMax);
				numberCon = Integer.valueOf(theNum);
				index = 0;
				
			} else {
				
				index++;	//if no repeats, proceed.
				
			}
			
		}
		
		return theNum;
		
	}

}
