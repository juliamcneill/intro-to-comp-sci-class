/**
 * This is the Character class that extends the OrderedThing parent class
 * because characters are ordered into each word. It represents a single character.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

public class Character extends OrderedThing {
	
	private char baseCharacter;
	
	/**
	 * Create a new Character object, getting its position from the OrderedThing class
	 * @param character The character as a char
	 * @param position The position of a character in its word, as an int
	 */
	public Character(char character, int position) {
		super(position);
		// assign the character recieved from the Word class to the private property
		baseCharacter = character;
	}
	
	/**
	 * To display to the user, convert the char baseCharacter to a String
	 * @return The char baseCharacter as a String
	 */
	public String toString() {
		return String.valueOf(baseCharacter);
	}

}
