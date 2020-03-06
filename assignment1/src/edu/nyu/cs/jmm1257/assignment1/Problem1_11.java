/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 1.11
 */

package edu.nyu.cs.jmm1257.assignment1;
import java.text.DecimalFormat;

public class Problem1_11 {

	public static void main(String[] args) {
		
		// Sets decimal formatting	
		DecimalFormat decForm = new DecimalFormat("#");
	
		// Sets population as variable
		double population = 312032486;
	
		// Calculates number of seconds in a year
		double secondsInYear = 365.0 * 24.0 * 60.0 * 60.0;
	
		// Calculates number of births, deaths, and immigrants in a year
		double birthsInYear = secondsInYear / 7.0;
		double deathsInYear = secondsInYear / 13.0;
		double immigrantsInYear = secondsInYear / 45.0;
	
		// Calculates yearly population change
		double populationChange = birthsInYear - deathsInYear + immigrantsInYear;
		
		// Uses a for loop to add the population change and print the result for 5 years
		for (int i = 1; i <= 5; i++) {
			population += populationChange;
			System.out.println("Year " + i + "'s population = " + decForm.format(population));
		}
	
	}

}
