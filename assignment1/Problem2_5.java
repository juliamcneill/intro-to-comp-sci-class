/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 2.5
 */

package edu.nyu.cs.jmm1257.assignment1;
import java.util.Scanner;

public class Problem2_5 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			// Prompts user to enter subtotal and gratuity rate
			System.out.print("Enter the subtotal and a gratuity rate: ");
			
			double subtotal = input.nextDouble();
			double gratuityRate = input.nextDouble();
			
			// Converts gratuity rate to a decimal
			double gratuityRateDec = gratuityRate / 100.0;
			
			// Calculates gratuity amount and add to subtotal
			double gratuity = subtotal * gratuityRateDec;
			double total = subtotal + gratuity;
			
			// Prints results
			System.out.println("The gratuity is $" + gratuity + " and total is $" + total);
			
		} finally {
			
			// Closes scanner
			input.close();
		}

	}

}
