/**
 * This is the SequentiallyOrdered Interface. It holds the necessary methods for
 * all SequentiallyOrdered objects, those created of the Word and Sentence classes.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

import java.util.ArrayList;

public interface SequentiallyOrdered {
	
	/**
	 * The follow methods are required by each class that implements
	 * the SequentiallyOrdered interface.
	 */
	
	/**
	 * Find the first OrderedThing in a sequence
	 */
	public abstract OrderedThing getFirst();
	/**
	 * Find the last OrderedThing in a sequence
	 */
	public abstract OrderedThing getLast();
	/**
	 * Get an entire sequence
	 * @return The sequence in its ArrayList of OrderedThings form
	 */
	public abstract ArrayList<OrderedThing> getSequence();

}
