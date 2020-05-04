/**
 * This is the Word class that extends the OrderedThing parent class because 
 * words are ordered into each sentence and implements the SequentiallyOrdered 
 * interface because words consist of ordered characters.
 * It represents a single word.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

import java.util.ArrayList;

public class Word extends OrderedThing implements SequentiallyOrdered {
	
	private ArrayList<OrderedThing> characters = new ArrayList<OrderedThing>();
	
	/**
	 * Create a new Word object, getting its position from the OrderedThing class,
	 * by creating a new Character at each index of the Word
	 * @param character The word as a String
	 * @param position The position of a word in its sentence, as an int
	 */
	public Word(String word, int position) {
		// get the position of the word in the sentence from the OrderedThing class
		super(position);
		
		// for each character, find the char at and create a new character 
		// using the Character class
		for (int i = 0; i < word.length(); i++) {
			characters.add(new Character(word.charAt(i), i));
		}
	}
	
	/**
	 * Find the first OrderedThing, or character, of the word
	 * @return The first character of the word
	 */
	public OrderedThing getFirst() {
		return characters.get(0);	
	}
	
	/**
	 * Find the last OrderedThing, or character, of the word
	 * @return The last character of the word
	 */
	public OrderedThing getLast() {
		return characters.get(characters.size() - 1);
	}
	
	/**
	 * Get the ArrayList of OrderedThing characters
	 * @return The character ArrayList of OrderedThings
	 */
	public ArrayList<OrderedThing> getSequence() {
		return characters;
	}
	
	/**
	 * To display to the user, iterate through the word ArrayList and add 
	 * each character part to a string
	 * @return The word as a String
	 */
	public String toString() {
		String string = "";
		
		// for each character in the word, add to a string
		for (int i = 0; i < characters.size(); i++) {
			string += characters.get(i);
		}
		
		return string;
	}

}
