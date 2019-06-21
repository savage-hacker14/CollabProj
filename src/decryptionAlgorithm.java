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
		
		if((specialCases.equalsIgnoreCase("N")) && (keypadNumber >10)) {
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
	
	public static ArrayList<String> solveAllOutcomes(int keyNums, int max, String specials){
		Random generator = new Random();
		ArrayList<String> answers = new ArrayList<String>();
		int[] numberChoices = new int[keyNums];
		String number;
		
		for(int i = 0; i < numberChoices.length; i++) {
			if(specials.equalsIgnoreCase("N")) {
				number = "";
				number += String.valueOf(generator.nextInt(keyNums));
				number += String.valueOf(generator.nextInt(keyNums));
				number += String.valueOf(generator.nextInt(keyNums));
				number += String.valueOf(generator.nextInt(keyNums));
				answers.add(number);
			} else {
				number = "";
				int termUse = generator.nextInt(2);
			}
		}
		return answers;
	}

}
