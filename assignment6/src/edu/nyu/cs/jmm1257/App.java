/**
 * This is the main program for a simple language learning game, that challenges the 
 * player to translate basic French words into English using their keyboard, awarding 
 * them points for each correct translation.
 * 
 * Gameplay Instructions: There are 30 available French words in each round.
 * Type the English translation of any coin and press the Return key to remove the
 * coin and receive a point. If you make a mistake while typing, press Return to start over.
 * Correct answers do not use articles, but do use the "to draw" two-word translation of
 * infinitive verbs. If a translation does not work, try synonyms!
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 6 | 04.15.20
 * Problem 6.1
 */
package edu.nyu.cs.jmm1257;

// imports packages
import java.util.ArrayList;
import java.util.Random;

import edu.nyu.cs.jmm1257.Coin;
import processing.core.*;

public class App extends PApplet {
	
	// initializes/sets variables for programs:
	
	// sets window size
	private final int w = 600;
	private final int h = 900;
	
	// makes constants for some colors
	public final int BLACK = this.color(0,0,0);
	public final int WHITE = this.color(255,255,255);
	
	// makes constants for spacing
	public final static int APP_MARGIN = 20; 
	public final static int NUM_COINS = 30;
	
	// starts player's score at 0
	private int score = 0;
	
	// starts temporary value for what player types
	private String goalWord = "";

	// creates an ArrayList to hold all instances of the Coin object
	private ArrayList<Coin> coins = new  ArrayList<Coin>();

	/**
	 * getter for the ArrayList of coin objects currently on the screen
	 * @return ArrayList of Coin objects
	 */
	public ArrayList<Coin> getCoins() {
		return this.coins;
	}

	/**
	 * setter for the ArrayList of Coin objects currently on the screen.
	 * @param coins an ArrayList of Coin objects
	 */
	public void setCoins(ArrayList<Coin> coins) {
		this.coins = coins;
	}
	
	/**
	 *  sets up program window
	 */
	public void settings() {
		this.size(this.w, this.h); //set window size		
	}
	
	/**
	 * is called once on load and creates initial settings and 
	 * Coin objects that are placed inside window 
	 */
	public void setup() {
		// sets background color of window
		this.background(this.WHITE);
		
		// sets position of first Coin
		int x = 5;
		int y = 5;
		
		// creates a new special overloaded constructor Coin with a photo of myself
		// passes my name, the x and y coordinates, and a reference to the App class
		Coin coin = new Coin("Game Creator: Julia McNeill", x + 30, y + 275, this);
		// adds this Coin to the array list
		this.coins.add(coin);
		
		// creates 7 special overloaded constructor Coins with an Eiffel Tower graphic
		// passes an X speed, the x and y coordinates, and a reference to the App class
		for (int i=0; i < 7; i++) {
			coin = new Coin(1, x * 20 * i, y + 85, this);
			// adds these Coins to the array list
			this.coins.add(coin);
		}

		// loop as many times as there is regular Coins
		for (int i=0; i<App.NUM_COINS; i++) { 
			
			// sets up placement of coins, dividing the coins into sections so that they 
			// appear to become more and more concentrated
			if (i < App.NUM_COINS / 4) {
				y = -(int)(Math.random() * 400);
				x += 70; 
			} else if (i == App.NUM_COINS / 4) {
				y = -(int)(Math.random() * 400) - 400;
				x = 0;
			} else if (i < App.NUM_COINS / 2) {
				y = -(int)(Math.random() * 300) - 800;
				x += 70; 	
			} else if (i == App.NUM_COINS / 2) {
				y = -(int)(Math.random() * 300) - 1100;
				x = 0;
			} else if (i < ((App.NUM_COINS / 2) + (App.NUM_COINS / 4))) {
				y = -(int)(Math.random() * 200) - 1400;
				x += 70; 	
			} else if (i == ((App.NUM_COINS / 2) + (App.NUM_COINS / 4))) {
				y = -(int)(Math.random() * 200) - 1600;
				x = 0;
			} else {
				y = -(int)(Math.random() * 100) - 1800;
				x += 70; 
			}
			
			// creates a new Coin, passing the x and y coordinates and a reference to the App class
			coin = new Coin(x, y, this);
			// adds this Coin to the array list
			this.coins.add(coin);
		}
	}
	
	/**
	 * is called repeatedly to update the game animation
	 */
	public void draw() {
		// clears the screen
		this.background(this.WHITE);
		// updates the user's current score
		this.text("Score: " + score, 20, 30);
		
		// loops through the ArrayList of Coins, moving and drawing each
			for (int i=0; i<this.coins.size(); i++) {
				Coin coin = this.coins.get(i);
				coin.move();
				coin.draw();
			}
		
		// creates a new ArrayList of Coins that the user has correctly translated
		ArrayList<Coin> coinsToRemove = new  ArrayList<Coin>(); 
		
		// removes each of the coins in the ArrayList from the screen
		for (Coin coin : coinsToRemove) {
			coin.kill();
		}

	}
	
	/**
	 * is called whenever a key is pressed by the user, allows the user to input 
	 * English translations, and removes coins that have been translated
	 */
	public void keyPressed() {

		    // if the user pressed the return key, assume that a word has been entered 
			if (this.key == '\n') {
				
				// creates a new ArrayList of Coins that the user has correctly translated
				ArrayList<Coin> coinsToRemove = new ArrayList<Coin>();
				
				// tests if the French word on each coin matches the English word input by the user
				// if these words match, adds this Coin to the ArrayList
				for (Coin coin : this.coins) {
					String goal = coin.messageTranslation;
					if (goal.contentEquals(goalWord)) {
						coinsToRemove.add(coin);
						updateScore();
					}		
				}
				
				// removes each of the coins in the ArrayList from the screen
				for (Coin coin : coinsToRemove) {
					coin.kill();
				}
				
				// resets the word to an empty string
				goalWord = "";
				
			// if the user presses a key besides the return key, add this key to the word string
			} else {
				
				goalWord = goalWord + this.key;
			}

	}
	
	/**
	 * is called whenever the program deletes a Coin, adds one to the user's score
	 */
	public void updateScore() {
		score++;
	}
	
	/**
	 * automatically called to start your program, calls PApplet's main method and passes it the class name of this class.
	 * @param args command-line arguments
	 */
	public static void main(String[] args) {
		PApplet.main("edu.nyu.cs.jmm1257.App");	
	}
}