/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 2.9
 */

package edu.nyu.cs.jmm1257.assignment1;
import java.util.Scanner;
import java.text.DecimalFormat;

public class Problem2_9 {

	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		try {
			
			// Sets decimal formatting
			DecimalFormat decForm = new DecimalFormat("###.####");
			
			// Prompts user to input variables
			System.out.print("Enter v0, v1, and t: ");
			
			double v0 = input.nextDouble();
			double v1 = input.nextDouble();
			double t = input.nextDouble();
			
			// Calculates average acceleration
			double avgAcceleration = (v1 - v0) / t;
			
			// Prints result
			System.out.println("The average acceleration is " + decForm.format(avgAcceleration));
			
		} finally {
			
			// Closes scanner
			input.close();
		}

	}

}
