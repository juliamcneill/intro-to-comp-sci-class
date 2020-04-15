/**
 * This is the Coin class for a simple language learning game. See main file for more
 * details on gameplay.
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 6 | 04.15.20
 * Problem 6.1
 */
package edu.nyu.cs.jmm1257;

// imports packages
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

import processing.core.PImage;

public class Coin {

	// holds a reference to the App object, which inherits from PApplet and handles Processing
	private App app;
	
	// grabs image file paths from src folder
	private final static String COIN_IMAGE_PATH = "Coin.png";
	private final static String ICON_IMAGE_PATH = "Icon.jpg";
	private final static String EIFFEL_IMAGE_PATH = "Eiffel.png";
	// holds image for Coin
	private PImage img;
	private PImage icon;
	private PImage eiffel;
	// holds French word for Coin
	private String message;
	// holds English translation of French word
	public String messageTranslation;
	
	// holds position and speed of Coin
	private int x, y;
	private int speedX;
	private int speedY = 1;
	
	/**
	 * sets up initial properties for the special overloaded constructor 
	 * Coin with a photo of myself
	 * @param a String with my own name to label the photo
	 * @param x the x position of the Coin object
	 * @param y the y position of the Coin object
	 * @param app passes a reference to the PApplet class
	 */
	public Coin(String creatorName, int x, int y, App app) {
		
		// keeps a reference to the PApplet class
		this.app = app;
		
		// positions the Coin in the window
		this.x = x;
		this.y = y;
		
		// loads the image and stores it in the PImage variable
		this.icon = this.app.loadImage(Coin.ICON_IMAGE_PATH);
		this.img = this.icon;
		
		// assigns my own name to the String variables for this Coin
		this.message = creatorName;
		this.messageTranslation = creatorName;
	}
	
	/**
	 * sets up initial properties for the special overloaded constructor 
	 * Coins with Eiffel Tower graphics
	 * @param the X speed
	 * @param x the x position of the Coin object
	 * @param y the y position of the Coin object
	 * @param app passes a reference to the PApplet class
	 */
	public Coin(int speedX, int x, int y, App app) {
		
		// keeps a reference to the PApplet class
		this.app = app;
		
		// positions the Coin in the window
		this.x = x;
		this.y = y;
		
		this.speedX= speedX;
		
		// loads the image and stores it in the PImage variable
		this.icon = this.app.loadImage(Coin.EIFFEL_IMAGE_PATH);
		this.img = this.icon;
		
		// leaves the String variables for this Coin empty
		this.message = "";
		this.messageTranslation = "";
	}

	/**
	 * sets up initial properties for each regular Coin object
	 * @param x the x position of the Coin object
	 * @param y the y position of the Coin object
	 * @param app passes a reference to the PApplet class
	 */
	public Coin(int x, int y, App app) {
		
		// keeps a reference to the PApplet class
		this.app = app;
		
		// positions the Coin in the window
		this.x = x;
		this.y = y;
		
		// loads the image and stores it in the PImage variable
		this.img = this.app.loadImage(Coin.COIN_IMAGE_PATH);
		
		// grabs the French, English String pair from the generateMessage function
		String result[] = generateMessage();
		
		// splits this pair into the French word and the English word
		this.message = result[0];
		this.messageTranslation = result[1];
	}

	/**
	 * gets the width of the coin, based on the width of its image
	 * @return the width of the coin
	 */
	public int getWidth() {
		return this.img.width;
	}
	
	/**
	 * gets the height of the coin, based on the height of its image
	 * @return the height of the coin
	 */
	public int getHeight() {
		return this.img.height;
	}
	
	/**
	 * moves the coin down the screen
	 */
	public void move() {
		// create new Y value based on old Y value and Y speed
		int newY = this.y + this.speedY;

		// updates the Coin's position
		this.y = newY;	
		
		if (this.speedX == (int)this.speedX) {
			int newX = this.x + this.speedX;
			//keep this alien within the borders!
			if (newX < 0) {
				newX = this.app.width; //if  it went too far to the left, wrap it to  the right
			}
			else if (newX > this.app.width) {
				newX = 0; //if it went too far to the right, wrap  it to the left
			}
			this.x = newX;
		}
	}
	
	/**
	 * removes a Coin from the ArrayList of Coins once the user has translated it
	 */
	public void kill() {
		this.app.getCoins().remove(this);		
	}
	
	/**
	 * setter for Y-axis speed
	 * @param speedY sets the speedY of the Coin object
	 */
	public void setSpeed(int speedY) {
		this.speedY = speedY;
	}
	
	/**
	 * draws each Coin with its respective French word to the window
	 */
	public void draw() {
		this.app.image(this.img, this.x, this.y);
		this.app.fill(0, 0, 0);
		this.app.textSize(24);
		this.app.text(this.message, this.x + 5, this.y - 10);
	}
	
	/**
	 * generates the respective French word for each Coin based on a .txt file
	 * @return a random French, English pair from the words.txt file
	 */
	public String[] generateMessage() {
		// uses a try-catch block to handle exceptions
		try {
			// reads in words.txt file stored in src folder
			FileInputStream fs= new FileInputStream("src/words.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			String line;
			
			// iterates through each line of the file, adding lines to an ArrayList
			while ((line = br.readLine()) != null) {
				array.add(line);
			}
			
			// finds a random line of the file
			Random rand = new Random();
			int randomIndex = rand.nextInt(array.size());
			
			// if this random number is odd, change it to the prior even number
			if (randomIndex % 2 == 1) {
				randomIndex--;
			}
			
			br.close();
			
			// this random number is the index of a random French word
			String french = array.get(randomIndex);
			// at the next index is the English translation of this French word
			String english = array.get(randomIndex + 1);

			// return these two words together as a String pair
			return new String[] {french, english};
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		 // returns empty Strings if there is an error	
		return new String[] {"", ""};
				
				
	}

}
