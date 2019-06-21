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
		int index = 0;
		
		for(int i = 0; i < numberChoices.length; i++) {
			if(specials.equalsIgnoreCase("N")) {
				number = "";
				number += generateRandomCombo(number, keyNums, max);	//generate random number combo
							
				int numberCon = Integer.valueOf(number);
				
				while(index < answers.size()) {
					if(numberCon == (Integer.valueOf(answers.get(index)))){
						
						//traverses through the array list to see if there are any repeats. If there are, then it redoes the 
						//random generation and begins from the top again
						
						number = "";
						number += generateRandomCombo(number, keyNums, max);
						numberCon = Integer.valueOf(number);
						index = 0;
					} else {
						index++;	//if no repeats, proceed.
					}
				}
				
				answers.add(number);	//add number to array list
			} else if(specials.equalsIgnoreCase("Y")) {
				number = "";
				int termUse = generator.nextInt(2); //pick at random to use either '*', '#', or both
			}
		}
		return answers;
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
		
		for(int r = 0; r < maximum; r++) {
			num += String.valueOf(generator.nextInt(keys));
		}
		
		return num;
	}

}
