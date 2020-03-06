/**
 * Julia McNeill
 * Introduction to Computer Science
 * Assignment 1 | 02.03.20
 * Problem 1.7
 */

package edu.nyu.cs.jmm1257.assignment1;

public class Problem1_7 {

	public static void main(String[] args) {
		
		// Calculates pi with two different precisions
		double pi1 = 4.0 * (1.0 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11));
		double pi2 = 4.0 * (1.0 - (1.0/3) + (1.0/5) - (1.0/7) + (1.0/9) - (1.0/11) + (1.0/13));
		
		// Prints results
		System.out.println("First estimation of pi: " + pi1);
		System.out.println("Second estimation of pi: " + pi2);
		
	}

}
