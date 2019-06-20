/**
 * Title: Collab Project
 * Authors: Jacob Krucinski and Arjun Viswanathan
 * Date: 6/18/2019
 * 
 * Welcome to our project. We do not have a specific goal or title at the moment, but will have it
 * soon!! 
 */

import java.util.*;
import java.text.*;

public class HelloWorld {
	
	public static void main(String[] args) {
		// Displays Hello World on the screen!
		System.out.println("Hello World!");
		
		Scanner input = new Scanner(System.in);
		String name;
		int age;
		//a scanner object will take in name and age from keyboard input.
		
		System.out.print("Enter Name: ");
		name = input.next();
		System.out.print("Enter Age: ");
		age = input.nextInt();
		
		System.out.println("Welcome"+" "+name);
		System.out.println("This challenger is currently"+" "+age+" "+"years old!");
		//prints out the name and age in a sentence. 
	}
}
