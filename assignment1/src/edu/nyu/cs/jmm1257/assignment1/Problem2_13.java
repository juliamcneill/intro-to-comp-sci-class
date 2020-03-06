/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 2.13
 */

package edu.nyu.cs.jmm1257.assignment1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Problem2_13 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			// Sets decimal formatting
			DecimalFormat decForm = new DecimalFormat("###.##");
			
			// Sets interest rate
			double interestRate = 0.00417;
			
			// Prompts user to enter a monthly saving amount
			System.out.print("Enter the monthly saving amount: ");
			
			double monthlyAmount = input.nextDouble();
			
			// Sets total amount equal to 0
			double totalAmount = 0;
			
			// Uses a for loop to calculate the account value after six months 
			for (int i = 1; i <= 6; i++) {
				// Adds monthly amount and interest
				double newAmount = (monthlyAmount + totalAmount) * (1 + interestRate);
				totalAmount = newAmount;
			}
			
			// Prints results
			System.out.println("After the sixth month, the account value is $" + decForm.format(totalAmount));
			
		} finally {
			
			// Closes scanner
			input.close();
		}

	}

}
