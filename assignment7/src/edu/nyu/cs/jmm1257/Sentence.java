/**
 * This is the Sentence class that implements the SequentiallyOrdered 
 * interface because sentences consist of ordered words.
 * It represents a single sentence.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

import java.util.ArrayList;

public class Sentence implements SequentiallyOrdered {
	
	private ArrayList<OrderedThing> words = new ArrayList<OrderedThing>();
	
	/**
	 * Create a new Sentence object by splitting the user-provided
	 * sentence and creating a new Word at each index of the Sentence
	 * @param sentence The sentence as a String
	 */
	public Sentence(String sentence) {
		// split the sentence by specific characters
		String[] split = sentence.split("[^\\w']+");
		
		// for each String subset, create a new word using the Word class
		for (int i = 0; i < split.length; i++) {
			words.add(new Word(split[i], i));
		}
	}
	
	/**
	 * Find the first OrderedThing, or word, of the sentence
	 * @return The first word of the sentence
	 */
	public OrderedThing getFirst() {
		return words.get(0);
	}
	
	/**
	 * Find the last OrderedThing, or word, of the sentence
	 * @return The last word of the sentence
	 */
	public OrderedThing getLast() {
		return words.get(words.size() - 1);	
	}
	
	/**
	 * Get the ArrayList of OrderedThing words
	 * @return The word ArrayList of OrderedThings
	 */
	public ArrayList<OrderedThing> getSequence() {
		return words;
	}
	
	/**
	 * To display to the user, iterate through the sentence ArrayList and add 
	 * each word part to a string
	 * @return The sentence as a String
	 */
	public String toString() {
		String string = "";
		
		// for each word in the sentence, add to a string
		for (int i = 0; i < words.size(); i++) {
			string += words.get(i) + " ";
		}
		
		return string;
	}

}
