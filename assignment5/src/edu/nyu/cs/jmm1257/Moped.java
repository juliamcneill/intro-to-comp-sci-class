/**
 * Program to hold methods to drive a virual Moped around Manhattan
 *
 * @author Julia McNeill
 * Introduction to Computer Science
 * Assignment 5 | 04.01.20
 * Problem 5.1
 */
package edu.nyu.cs.jmm1257;

// class that encapsulates all of the attributes and methods that the Moped needs to perform its functions
public class Moped {
	
	// starting values of Moped's attributes
	private boolean parked = false;
	private String orientation = "South";
	private boolean reverse = false;
	private int tank = 20;
	private int avenue = 5;
	private int street = 10;	
	
	/**
	 * Print introduction to your Moped ride
	 */
	public static void introduction() {
		
		System.out.println("Thanks for jumping on the moped.\n"
				+ "We're currently parked outside Dr. Rossinsky DDS's office at 10th St. and 5th Ave, facing South.\n"
				+ "May I say your teeth look very clean.\n"
				+ "What would you like to do?  At any time, say \"help\" for assistance.");
	
	}
	
	/**
	 * Set a changed street value
	 * @param newStreet a new street int
	 */
	public void setStreet(int newStreet) {
		
		// ensure that the Moped isn't going off the grid
		if (newStreet >= 1 && newStreet <= 200) {
			// set the new street value
			this.street = newStreet;
		} else {
			System.out.println("You're at the edge of Manhattan! "
					+ "Head in another direction so that you don't fall off.");
		}
		
	}
	
	/**
	 * Get the current street value
	 * @return the current street int
	 */
	public int getStreet() {
		 return this.street;
	}
	
	/**
	 * Set a changed avenue value
	 * @param newAvenue a new avenue int
	 */
	public void setAvenue(int newAvenue) {
		
		// ensure that the Moped isn't going off the grid
		if (newAvenue >= 1 && newAvenue <= 10) {
			// set the new avenue value
			this.avenue = newAvenue;
		} else {
			System.out.println("You're at the edge of Manhattan! "
					+ "Head in another direction so that you don't fall off.");
		}
		
	}

	/**
	 * Get the current avenue value
	 * @return the current avenue int
	 */
	public int getAvenue() {
		 return this.avenue;
	}
	
	/**
	 * Set a new orientation value of North, East, South, or West
	 * @param newOrientation a new orientation String
	 */
	public void setOrientation(String newOrientation) {
		// set the new orientation value
		this.orientation = newOrientation;
	}
	
	/**
	 * Get the current orientation value of North, East, South, or West
	 * @return the current orientation String
	 */
	public String getOrientation() {
		return this.orientation;
	}
	
	/**
	 * Set the Moped to move in reverse or in drive
	 * @param newReverse a boolean value of false (drive) or true (reverse)
	 */
	public void setInReverse(boolean newReverse) {
		// set the new drive/reverse value
		this.reverse = newReverse;
	}
	
	/**
	 * Get whether the Moped is in reverse or in drive
	 * @return a boolean value of false (drive) or true (reverse)
	 */
	public boolean getInReverse() {
		return this.reverse;
	}
	
	/**
	 * Print the Moped's current location, including street, avenue, and orientation
	 */
	public void printLocation() {
		
		// determine the street's ending string
		String streetEnding;
		switch(this.street) {
			case 1:
		 		streetEnding = "st";
		 		break;
		 	case 2:
		 		streetEnding = "nd";
		 		break;
		 	case 3:
		 		streetEnding = "rd";
		 		break;
		 	default:
		 		streetEnding = "th";
		 		break;
		 }
		
		// determine the avenue's ending string
		String avenueEnding;
		switch(this.avenue) {
		 	case 1:
		 		avenueEnding = "st";
		 		break;
		 	case 2:
		 		avenueEnding = "nd";
		 		break;
		 	case 3:
		 		avenueEnding = "rd";
		 		break;
		 	default:
		 		avenueEnding = "th";
		 		break;
		 }
		
		 // print the Moped's current location
		 System.out.print("Now at " + this.street + streetEnding + " St. and " + this.avenue + avenueEnding + " Ave., facing " + this.orientation + ". ");
		 // print the relevant ad on the same line, if applicable
		 if (this.street == 79 && this.avenue == 8) {
			 System.out.println("Did you know that the American Museum of Natural History has a 429-seat Space Theater, which features a custom-made Zeiss "
			 		+ "Mark IX Star Projector that displays a hyperrealistic view of planets, star clusters, nebulae, and galaxies?"); 
		 } else if (this.street == 74 && this.avenue == 1) {
			 System.out.println("Did you know that Memorial Sloan Kettering Cancer Center uses targeted tumor sequencing tests to detect gene mutations and "
			 		+ "other critical genetic aberrations in both rare and common cancers?");
		 } else if (this.street == 12 && this.avenue == 4) {
			 System.out.println("Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?");
		 } else if (this.street == 3 && this.avenue == 6) {
			 System.out.println("Did you know that Fay Da Bakery sells sponge cakes, mmango mochi, fruit tarts, chocolate éclairs, and many other tasty "
			 		+ "snacks?");
		 } else {
			 // move the next line if no ad is applicable
			 System.out.println("");
		 }
		 
	}
	
	/**
	 * Turn the Moped left and move a block
	 */
	public void goLeft() {
		
		// list of movement for each drive setting/orientation combination
		if (this.reverse == true) {
			switch (this.orientation) {
			   case "North":
				   this.setAvenue(this.avenue + 1);
				   this.setOrientation("East");
				   break;
			   case "East":
				   this.setStreet(this.street + 1);
				   this.setOrientation("South");
				   break;
			   case "South":
				   this.setAvenue(this.avenue - 1);
				   this.setOrientation("West");
				   break;
			   case "West":
				   this.setStreet(this.street - 1);
				   this.setOrientation("North");
				   break;
			 }
		} else {
			switch (this.orientation) {
			   case "North":
				   this.setAvenue(this.avenue + 1);
				   this.setOrientation("West");
				   break;
			   case "East":
				   this.setStreet(this.street + 1);
				   this.setOrientation("North");
				   break;
			   case "South":
				   this.setAvenue(this.avenue - 1);
				   this.setOrientation("East");
				   break;
			   case "West":
				   this.setStreet(this.street - 1);
				   this.setOrientation("South");
				   break;
			 }
		}
		
		// print location and reduce gas
		this.printLocation();
		this.setGas(this.tank - 1);
	
	}
	
	/**
	 * Turn the Moped right and move a block
	 */
	public void goRight() {
		
		// list of movement for each drive setting/orientation combination
		if (this.reverse == true) {
			switch (this.orientation) {
			   case "North":
				   this.setAvenue(this.avenue - 1);
				   this.setOrientation("West");
				   break;
			   case "East":
				   this.setStreet(this.street - 1);
				   this.setOrientation("North");
				   break;
			   case "South":
				   this.setAvenue(this.avenue + 1);
				   this.setOrientation("East");
				   break;
			   case "West":
				   this.setStreet(this.street + 1);
				   this.setOrientation("South");
				   break;
			 }
		} else {
			switch (this.orientation) {
			   case "North":
				   this.setAvenue(this.avenue - 1);
				   this.setOrientation("East");
				   break;
			   case "East":
				   this.setStreet(this.street - 1);
				   this.setOrientation("South");
				   break;
			   case "South":
				   this.setAvenue(this.avenue + 1);
				   this.setOrientation("West");
				   break;
			   case "West":
				   this.setStreet(this.street + 1);
				   this.setOrientation("North");
				   break;
			 }
		}
		
		// print location and reduce gas
		this.printLocation();
		this.setGas(this.tank - 1);
	
	}
	
	/**
	 * Set the Moped to drive and move the car straight one block
	 */
	public void straightOn() {
		
		// set the moped to drive
		this.setInReverse(false);
		
		// list of movement for each orientation
		switch (this.orientation) {
		   case "North":
			   this.setStreet(this.street + 1);
			   break;
		   case "East":
			   this.setAvenue(this.avenue - 1);
			   break;
		   case "South":
			   this.setStreet(this.street - 1);
			   break;
		   case "West":
			   this.setAvenue(this.avenue + 1);
			   break;
		 }
		
		this.printLocation();
		this.setGas(this.tank - 1);
	
	}
	
	/**
	 * Set the Moped to reverse and move the car back one block
	 */
	public void backUp() {
		
		// set the moped to reverse
		this.setInReverse(true);
		
		// list of movement for each orientation
		switch (this.orientation) {
		   case "North":
			   this.setStreet(this.street - 1);
			   break;
		   case "East":
			   this.setAvenue(this.avenue + 1);
			   break;
		   case "South":
			   this.setStreet(this.street + 1);
			   break;
		   case "West":
			   this.setAvenue(this.avenue - 1);
			   break;
		 }
		
		this.printLocation();
		this.setGas(this.tank - 1);
		
	}
	
	/**
	 * Drive the Moped to Bluestone Lane
	 */
	public void goToBluestoneLane() {
		
		// set the moped to drive
		this.setInReverse(false);
		// set flag for when you arrive
		Boolean arrived = false;
		
		// while you have not arrived
		while (arrived == false) {
			
			// make the necessary moves to get to Bluestone Lane
			if (this.street > 8) {
				this.setStreet(this.street - 1);
				this.setOrientation("South");
			} else if (this.street < 8) {
				this.setStreet(this.street + 1);
				this.setOrientation("North");
			} else if (this.avenue > 4) {
				this.setAvenue(this.avenue - 1);
				this.setOrientation("East");
			} else if (this.avenue < 4) {
				this.setAvenue(this.avenue + 1);
				this.setOrientation("West");
			}
			
			// if you have arrived, change flag
			if (this.street == 8 && this.avenue == 4) {
				arrived = true;
			}
			
			// print location and reduce gas
			this.printLocation();
			this.setGas(this.tank - 1);
		}
		
		System.out.println("You have reached the Bluestone Lane. Enjoy your cappuccino.");
	
	}
	
	/**
	 * Set the gas level of the Moped to a new value, and check if the car has run out of gas
	 * @param newGas int for new gas level
	 */
	public void setGas(int newGas) {
		
		// assign new gas value to tank
		this.tank = newGas;
		// if your Moped has run out of gas, park it
		if (this.tank <= 0) {
			System.out.println("Oh no! Your Moped has run out of gas.");
			setParked();
		}
	
	}
	
	/**
	 * Get the gas level of the Moped
	 * @return the gas level of the Moped
	 */
	public int getGas() {
		return this.tank;
	}
	
	/**
	 * Print the gas level of the Moped
	 */
	public void howWeDoin() {
		System.out.println("Your tank is currently " + (this.tank * 100) / 20 + "% full.");
	}
	
	/**
	 * Fill the gas tank of the Moped
	 */
	public void fillErUp() {
		
		this.setGas(20);
		System.out.println("Filling tank...");
		this.howWeDoin();
		
	}
	
	/**
	 * Print a list of commands the user may use
	 */
	public static void help() {
		
		System.out.println("Here are some commands that you may use:\n"
				+ "	- go left\n"
				+ "	- go right\n"
				+ "	- straight on\n"
				+ "	- back up\n"
				+ "	- go to Bluestone Lane\n"
				+ "	- how we doin'?\n"
				+ "	- fill 'er up\n"
				+ "	- help\n"
				+ "	- park");
		
	}
	
	/**
	 * Park the Moped
	 */
	public void setParked() {
		
		this.parked = true;
		System.out.println("You've parked your Moped. Ride again soon!");	 
	
	}
	
	/**
	 * Check if the Moped is parked
	 */
	public boolean getParked() {
		return parked;
	}
	
	/**
	 * Let the user know if there command isn't found and call the help method
	 */
	public static void commandNotFound() {
		
		System.out.print("That's not a valid command! ");
		Moped.help();
		
	}

}

