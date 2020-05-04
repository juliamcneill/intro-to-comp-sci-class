/**
 * This is the TestSequence class that provides an implementation of all
 * other classes in the program.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 7 | 05.04.20
 * Problem 7.1
 */
package edu.nyu.cs.jmm1257;

import java.util.ArrayList;

public class TestSequence {

	public static void main(String[] args) {
		
		// create a new Sentence object of the interface SequentiallyOrdered
		SequentiallyOrdered sentence = new Sentence("Julia was here");
		
		// print this sentence, using the toString method from the Sentence class
		System.out.println(sentence);
		
		// call various methods on the sentence from the Sentence class
		ArrayList<OrderedThing> wordSequence = sentence.getSequence();
		OrderedThing firstWord = sentence.getFirst();
		OrderedThing lastWord = sentence.getLast();
		// call the position method from the OrderedThing class that is implemented by the Word class 
		int firstWordPosition = firstWord.getPosition();
		int lastWordPosition = lastWord.getPosition();
		
		// print the results of assigning the results of these methods
		System.out.println(wordSequence);
		System.out.println(firstWord);
		System.out.println(lastWord);
		System.out.println(firstWordPosition);
		System.out.println(lastWordPosition);
		
		// find the first word of the Sentence object and cast to a SequentiallyOrdered type
		SequentiallyOrdered word = (SequentiallyOrdered)sentence.getFirst();
		
		// call various methods on the word from the Word class
		ArrayList<OrderedThing> charsSequence = word.getSequence();
		OrderedThing firstChar = word.getFirst();
		OrderedThing lastChar = word.getLast();
		// call the position method from the OrderedThing class that is implemented by the Character class 
		int firstCharPosition = firstChar.getPosition();
		int lastCharPosition = lastChar.getPosition();
		
		// print the results of assigning the results of these methods
		System.out.println(charsSequence);
		System.out.println(firstChar);
		System.out.println(lastChar);
		System.out.println(firstCharPosition);
		System.out.println(lastCharPosition);

	}

}
