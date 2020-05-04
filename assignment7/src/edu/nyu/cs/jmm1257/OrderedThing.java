/**
 * This is the OrderedThing Class. I chose to make this a non-abstract parent class
 * in order to hold and implement the common position property and getPosition method 
 * that is used by objects created out of the Word and Character child classes.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

public class OrderedThing {
	
	private int position;
	
	/**
	 * Create an OrderedThing and assign its position 
	 * @param position The position of the OrderedThing in its sequence
	 */
	public OrderedThing(int position) {
		// assign the position of this specific Word or Char to the private position property
		this.position = position;
	}
	
	/**
	 * Getter for the position value
	 * @return The position of an OrderedThing in its sequence
	 */
	public int getPosition() {
		return this.position;
	};

}
