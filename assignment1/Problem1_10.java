/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 1.10
 */

package edu.nyu.cs.jmm1257.assignment1;
import java.text.DecimalFormat;

public class Problem1_10 {

	public static void main(String[] args) {
		
		// Sets decimal formatting
		DecimalFormat df = new DecimalFormat("###.###");
		
		// Calculates number of miles ran
		double kilometers = 14.0;
		double miles = kilometers / 1.6;
		
		// Calculates number of hours ran
		double hours = (45.0 / 60.0) + (30.0 / 3600.0);
		
		// Calculates speed in miles per hour
		double mph = miles / hours;
		
		// Prints results
		System.out.println("The runner's average speed was " + df.format(mph) + " mph.");

	}

}
